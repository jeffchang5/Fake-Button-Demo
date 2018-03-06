package io.jeffchang.buttondemo.ui.usercreate.view

import io.jeffchang.buttondemo.models.User

/**
 * View contract for the dog detail fragment.
 */

interface UserCreateView {
    
    fun postUserSuccess(user: User)

    fun postUserFailure(error: Throwable)
}
