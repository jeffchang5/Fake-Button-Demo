package io.jeffchang.buttondemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.support.DaggerAppCompatActivity;
import io.jeffchang.buttondemo.R;
import io.jeffchang.buttondemo.ui.usercreate.view.DogDetailFragment;
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment;

/**
 * Hosts our two main fragments.
 */

public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToListFragment();
    }

    void goToDetailFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, DogDetailFragment.newInstance())
                .commit();
    }

    void goToListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, UserListFragment.newInstance())
                .commit();
    }
}
