package io.jeffchang.buttondemo.ui

import android.os.Bundle

import dagger.android.support.DaggerAppCompatActivity
import io.jeffchang.buttondemo.R
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateFragment
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment

/**
 * Hosts our two main fragments.
 */

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToListFragment()
    }

    private fun goToDetailFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment_container, UserCreateFragment.newInstance())
                .commit()
    }

    private fun goToListFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment_container, UserListFragment.newInstance())
                .commit()
    }
}
