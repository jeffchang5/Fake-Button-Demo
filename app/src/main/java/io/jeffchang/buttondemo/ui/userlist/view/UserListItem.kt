package io.jeffchang.buttondemo.ui.userlist.view

import android.content.Context
import android.widget.RelativeLayout

import io.jeffchang.buttondemo.R
import kotlinx.android.synthetic.main.user_list_item.view.*

/**
 * Custom view that lists user items in a list.
 */

class UserListItem constructor(context: Context)
    : RelativeLayout(context, null, 0) {

    var name: String? = null
        set(fullName) {
            user_list_item_name_text_view.text = fullName
        }

    var email: String? = null
        set(fullName) {
            user_list_item_email_text_view.text = fullName
        }

    init {
        inflate(context, R.layout.user_list_item, this)
    }
}
