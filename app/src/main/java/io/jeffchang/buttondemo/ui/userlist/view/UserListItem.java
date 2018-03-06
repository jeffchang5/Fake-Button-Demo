package io.jeffchang.buttondemo.ui.userlist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import io.jeffchang.buttondemo.R;

/**
 * Created by jeffreychang on 3/4/18.
 */

class UserListItem extends RelativeLayout {

    public UserListItem(Context context) {
        super(context);
        init(context, null);
    }

    public UserListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public UserListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.dog_breed_list_item, this);
    }
}
