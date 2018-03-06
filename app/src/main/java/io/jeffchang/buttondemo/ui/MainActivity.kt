package io.jeffchang.buttondemo.ui

import android.os.Bundle
import android.view.MenuItem

import dagger.android.support.DaggerAppCompatActivity
import io.jeffchang.buttondemo.R
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateFragment
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Hosts our two main fragments.
 */

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Users"
        main_activity_fab.setOnClickListener {
            goToUserCreateFragment()
        }

        goToListFragment()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                onBackPressed()
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        main_activity_fab.show()
        title = "Users"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun goToUserCreateFragment() {
        main_activity_fab.hide()
        title = "New User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment_container, UserCreateFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    private fun goToListFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment_container, UserListFragment.newInstance())
                .commit()
    }
}
