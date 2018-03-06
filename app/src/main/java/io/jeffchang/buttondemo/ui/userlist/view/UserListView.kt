package io.jeffchang.buttondemo.ui.userlist.view

import io.jeffchang.buttondemo.models.User

/**
 * View contract for the list fragment.
 */

interface UserListView {

    fun onGetUsersSuccess(users: List<User>)

    fun onGetUsersFailure(throwable: Throwable)
}