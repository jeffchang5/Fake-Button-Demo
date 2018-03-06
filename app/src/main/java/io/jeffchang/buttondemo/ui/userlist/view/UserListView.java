package io.jeffchang.buttondemo.ui.userlist.view;

import java.util.List;

import io.jeffchang.buttondemo.models.User;

/**
 * View contract for the list fragment.
 */

public interface UserListView {

    void onGetUsersSuccess(List<User> user);

    void onGetUsersFailure(Throwable throwable);
}