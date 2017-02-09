package com.apptest.main.activities

import android.content.SharedPreferences
import android.os.Bundle
import butterknife.ButterKnife
import com.apptest.R
import com.apptest.sharedpreferences.DaggerSharedPrerenceComponent
import com.apptest.sharedpreferences.SharedPreferenceModule

class MainActivity : BaseMainActivity() {
    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    private var mSharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initToolbar()
        initView()
        initPresenter()

        mSharedPreferences = DaggerSharedPrerenceComponent.builder()
                .sharedPreferenceModule(SharedPreferenceModule(application))
                .build().getSharedPreference()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
