package com.apptest.Users.adapters

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.apptest.R
import com.apptest.Users.models.User

import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by davidpayel on 04/02/2017.
 */

class UserViewHolder(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

    @Nullable @JvmField @BindView(R.id.tv_name) var mName: TextView? = null
    @Nullable @JvmField @BindView(R.id.tv_username) var mUsername: TextView? = null
    @Nullable @JvmField @BindView(R.id.tv_email) var mEmail: TextView? = null

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(user: User, position: Int, listener: UsersAdapter.OnItemClickListener?) {

        mName?.text = user.name
        mUsername?.text = user.username
        mEmail?.text = user.email

        itemView.setOnClickListener {
            v -> listener?.onItemClick(user, v)
        }
    }
}