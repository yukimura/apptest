package com.apptest.view

import android.os.Bundle
import android.os.Handler
import android.view.View
import butterknife.ButterKnife
import com.apptest.R
import com.apptest.adapter.UsersAdapter
import com.apptest.model.User
import com.apptest.presenter.MainPresenter
import java.util.*

class MainActivity : BaseMainActivity(), MainView {
    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        presenter = MainPresenter()
        presenter?.attachView(this)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        val handler = Handler()
        handler.postDelayed(Runnable { presenter?.loadUers(1, 0) }, 2000)
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

    override fun showMessage(stringId: Int) {
        progress.setVisibility(View.GONE)
        textInfo.setVisibility(View.VISIBLE)
        recyclerview.setVisibility(View.GONE)
        textInfo.setText(getString(stringId))
    }

    override fun showProgressIndicator() {
        progress?.setVisibility(View.VISIBLE)
        textInfo?.setVisibility(View.GONE)
        recyclerview.setVisibility(View.GONE)
    }
}
