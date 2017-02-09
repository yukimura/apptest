package com.apptest.Users.base

import android.support.annotation.Nullable
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView

import com.apptest.R
import com.apptest.Users.adapters.UsersAdapter
import com.apptest.Users.models.User

import butterknife.BindView

/**
 * Created by davidpayel on 06/02/2017.
 */

open class BaseUserFragment : Fragment() {
    @Nullable @JvmField @BindView(R.id.recyclerview) var recyclerview: RecyclerView? = null
    @Nullable @JvmField @BindView(R.id.text_info) protected var textInfo: TextView? = null
    @Nullable @JvmField @BindView(R.id.progress) protected var progress: ProgressBar? = null

    protected fun initRecyclerView() {
        val adapter = UsersAdapter(activity, object : UsersAdapter.OnItemClickListener {
            override fun onItemClick(user: User, v: View) {
                Snackbar.make(v, user.name.toString(), Snackbar.LENGTH_LONG).show()
            }
        })
        recyclerview?.adapter = adapter
        recyclerview?.layoutManager = LinearLayoutManager(activity)
    }
}
