package com.apptest.main;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.apptest.R;
import com.apptest.Users.UserFragment;
import com.apptest.Users.UserPresenter;
import com.apptest.utils.ActivityUtils;

import butterknife.BindView;

/**
 * Created by davidpayel on 05/02/2017.
 */

public class BaseMainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    protected UserFragment userFragment;

    protected void initToolbar(){
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    protected void initView(){
        userFragment = (UserFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (userFragment == null) {
            userFragment = UserFragment.Companion.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), userFragment, R.id.contentFrame);
        }

    }

    protected void initPresenter(){
        new UserPresenter(userFragment);
    }
}
