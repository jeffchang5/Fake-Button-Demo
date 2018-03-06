package io.jeffchang.buttondemo.ui.userlist.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.util.ArrayList

import io.jeffchang.buttondemo.models.User

/**
 * RecyclerView Adapter for dog breed list.
 */

class UserListRecyclerViewAdapter constructor(
        private val context: Context,
        users: List<User>) : RecyclerView.Adapter<UserListRecyclerViewAdapter.UserViewHolder>() {
    private val users: ArrayList<User> = ArrayList(users)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
        = UserViewHolder(UserListItem(context))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userListItem.name = users[position].name
        holder.userListItem.email = users[position].email
    }

    override fun getItemCount() = users.size

    inner class UserViewHolder(val userListItem: UserListItem)
        : RecyclerView.ViewHolder(userListItem)
}
