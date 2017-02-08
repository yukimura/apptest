package com.apptest.main

import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.apptest.R
import com.apptest.Users.UserFragment
import com.apptest.Users.UserPresenter
import com.apptest.utils.ActivityUtils

import butterknife.BindView

/**
 * Created by davidpayel on 05/02/2017.
 */

open class BaseMainActivity : AppCompatActivity() {
    @Nullable @JvmField @BindView(R.id.toolbar) var toolbar: Toolbar? = null

    protected var userFragment: UserFragment? = null

    protected fun initToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setHomeButtonEnabled(true)
        }
    }

    protected fun initView() {
        userFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as UserFragment?
        if (userFragment == null) {
            userFragment = UserFragment.newInstance()
            ActivityUtils.addFragmentToActivity(
                    supportFragmentManager, userFragment!!, R.id.contentFrame)
        }

    }

    protected fun initPresenter() {
        UserPresenter(userFragment!!)
    }
}
