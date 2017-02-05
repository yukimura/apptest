package com.apptest.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apptest.R;
import com.apptest.adapter.UsersAdapter;
import com.apptest.model.User;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by davidpayel on 04/02/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    @BindView(R.id.tv_name) TextView mName;
    @BindView(R.id.tv_username) TextView mUsername;
    @BindView(R.id.tv_email) TextView mEmail;

    public UserViewHolder(Context context, @NotNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bind(@NotNull final User user, @NotNull int position, @Nullable final UsersAdapter.OnItemClickListener listener) {

        mName.setText(user.getName());
        mUsername.setText(user.getUsername());
        mEmail.setText(user.getEmail());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(user, v);
            }
        });
    }
}