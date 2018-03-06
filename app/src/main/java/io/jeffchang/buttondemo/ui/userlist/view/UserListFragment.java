package io.jeffchang.buttondemo.ui.userlist.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import io.jeffchang.buttondemo.R;
import io.jeffchang.buttondemo.models.User;
import io.jeffchang.buttondemo.ui.common.BaseFragment;
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenter;

import javax.inject.Inject;

/**
 * Fragment that displays a list of dog breeds.
 */

public class UserListFragment extends BaseFragment implements UserListView {

    @Inject
    UserListPresenter userListPresenter;
    private RecyclerView usersRecyclerView;
    private UserListRecyclerViewAdapter userListRecyclerViewAdapter;

    public static UserListFragment newInstance() {
        Bundle args = new Bundle();
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_user_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersRecyclerView = findParentViewById(R.id.user_list_fragment_recycler_view);
        showProgressBar("HELLO WORLD");
        userListPresenter.getUsers();
    }

    @Override
    public void onGetUsersSuccess(List<User> users) {
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        userListRecyclerViewAdapter = new UserListRecyclerViewAdapter(getContext(),
                users);
        usersRecyclerView.setAdapter(userListRecyclerViewAdapter);
        showMainContent();
    }

    @Override
    public void onGetUsersFailure(Throwable throwable) {

    }
}
