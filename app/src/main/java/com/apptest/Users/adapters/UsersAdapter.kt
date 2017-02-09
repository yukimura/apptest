package com.apptest.Users.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.apptest.R
import com.apptest.Users.models.User

import java.util.ArrayList

/**
 * Created by davidpayel on 04/02/2017.
 */

class UsersAdapter : RecyclerView.Adapter<UserViewHolder> {
    private var users: ArrayList<User>? = null
    private var context: Context? = null
    private var mListener: OnItemClickListener? = null

    constructor(context: Context, listener: OnItemClickListener) {
        this.context = context
        this.mListener = listener
    }

    fun setUsers(users: ArrayList<User>) {
        this.users = users
    }

    interface OnItemClickListener {
        fun onItemClick(user: User, v: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_adapter, parent, false)
        return UserViewHolder(context!!, view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users!![position]
        holder.bind(user, position, mListener)
    }

    override fun getItemCount(): Int {
        return users!!.size
    }
}