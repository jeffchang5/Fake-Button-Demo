package io.jeffchang.buttondemo.ui.userlist.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import io.jeffchang.buttondemo.models.User;

/**
 * RecyclerView Adapter for dog breed list.
 */

public class UserListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<User> users;

    UserListRecyclerViewAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = new ArrayList<>(users);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        UserListItem userListItem = new UserListItem(context);
        userListItem.setLayoutParams(layoutParams);
        return new UserViewHolder(userListItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

         UserViewHolder(View itemView) {
            super(itemView);
        }
    }
}
