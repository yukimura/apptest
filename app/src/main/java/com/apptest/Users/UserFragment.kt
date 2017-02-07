package com.apptest.Users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.apptest.R
import com.apptest.adapter.UsersAdapter

import com.apptest.models.User
import com.meetphone.monsherif.annotation.database.AUser

import java.util.ArrayList

/**
 * Created by davidpayel on 07/02/2017.
 */

class UserFragment : BaseUserFragment(), UserContract.View {
    companion object {
        val TAG = UserFragment::class.java.simpleName
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    protected var mPresenter: UserContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.content_main, container, false)
        ButterKnife.bind(this, rootView)
        initRecyclerView()
        return rootView
    }

    override fun showUsers(users: ArrayList<User>) {
        val adapter = recyclerview?.getAdapter() as UsersAdapter
        adapter.setUsers(users)
        adapter.notifyDataSetChanged()
        recyclerview?.requestFocus()
        progress?.setVisibility(View.GONE)
        textInfo?.setVisibility(View.GONE)
        recyclerview?.setVisibility(View.VISIBLE)
    }

    override fun showMessage(resStringId: Int) {
        progress.setVisibility(View.GONE)
        textInfo.setVisibility(View.VISIBLE)
        recyclerview.setVisibility(View.GONE)
        textInfo.setText(getString(resStringId))
    }

    override fun showProgressIndicator() {
        progress?.setVisibility(View.VISIBLE)
        textInfo?.setVisibility(View.GONE)
        recyclerview.setVisibility(View.GONE)
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.start(AUser.USERS)
    }

    override fun setPresenter(presenter: UserContract.Presenter) {
        mPresenter = checkNotNull(presenter)
    }
}
