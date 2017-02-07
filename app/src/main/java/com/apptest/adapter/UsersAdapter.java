package com.apptest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apptest.R;
import com.apptest.models.User;
import com.apptest.viewholder.UserViewHolder;

import java.util.ArrayList;

/**
 * Created by davidpayel on 04/02/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> users;
    private Context context;
    private OnItemClickListener mListener;

    public void onItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public UsersAdapter() {
        this.users = new ArrayList<>();
    }

    public UsersAdapter(Context context, ArrayList<User> users, OnItemClickListener listener) {
        this.context = context;
        this.users = users;
        this.mListener = listener;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public interface OnItemClickListener {
        void onItemClick(User user, View v);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_adapter, parent, false);
        return new UserViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        //User user = users.get(position);
        //holder.bind(user, position, mListener);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}