package com.apptest.Users;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apptest.R;
import com.apptest.adapter.UsersAdapter;
import com.apptest.models.User;

import butterknife.BindView;

/**
 * Created by davidpayel on 06/02/2017.
 */

public class BaseUserFragment extends Fragment {
    @BindView(R.id.recyclerview) protected RecyclerView recyclerview;
    @BindView(R.id.text_info) protected TextView textInfo;
    @BindView(R.id.progress) protected ProgressBar progress;

    protected void initRecyclerView() {
        UsersAdapter adapter = new UsersAdapter();
        adapter.onItemClickListener(new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user, View view) {

            }
        });
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
