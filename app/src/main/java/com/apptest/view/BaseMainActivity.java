package com.apptest.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apptest.R;
import com.apptest.adapter.UsersAdapter;
import com.apptest.model.User;
import com.apptest.presenter.MainPresenter;

import butterknife.BindView;

/**
 * Created by davidpayel on 05/02/2017.
 */

public class BaseMainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recyclerview) protected RecyclerView recyclerview;
    @BindView(R.id.text_info) protected TextView textInfo;
    @BindView(R.id.progress) protected ProgressBar progress;

    protected MainPresenter presenter;

    protected void initRecyclerView() {
        UsersAdapter adapter = new UsersAdapter();
        adapter.onItemClickListener(new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user, View view) {

            }
        });
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
