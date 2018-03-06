package io.jeffchang.buttondemo.ui.usercreate.presenter

/**
 * Presenter contract for creating an user.
 */

interface UserCreatePresenter {

    fun postUser(name: String, email: String)

}
