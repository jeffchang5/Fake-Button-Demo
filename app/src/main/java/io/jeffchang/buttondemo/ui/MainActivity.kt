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

    private var fragmentState =  USER_LIST_FRAGMENT_TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Users"
        main_activity_fab.setOnClickListener {
            goToUserCreateFragment()
        }

        /**
         * Show the last viewed fragment if the activity was destroyed.
         **/
        savedInstanceState?.getString(FRAGMENT_STATE_ARG)?.let {
            fragmentState = it
        }

        if (fragmentState == USER_LIST_FRAGMENT_TAG) {
            goToListFragment()
        } else {
            goToUserCreateFragment()
        }

    }

    /**
     * Save which fragment is the current viewed.
     **/
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(FRAGMENT_STATE_ARG, fragmentState)
    }


    /**
     * Handle back press from menu.
     **/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                onBackPressed()
        }
        return true
    }

    /**
     * Handles the event where the device back button is pressed.
     **/
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

        val transaction = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.backStackEntryCount < 1)
            transaction.addToBackStack(null)


        /**
         * Get fragment if it is in the support fragment manager.
         * Otherwise, create a new instance.
        **/

        var fragment = supportFragmentManager
                .findFragmentByTag(USER_CREATE_FRAGMENT_TAG)
        if (fragment == null)
            fragment = UserCreateFragment.newInstance()

        transaction
                .replace(
                        R.id.main_fragment_container,
                        fragment,
                        USER_CREATE_FRAGMENT_TAG)
                .commit()
    }

    private fun goToListFragment() {
        fragmentState = USER_LIST_FRAGMENT_TAG

        /**
         * Get fragment if it is in the support fragment manager.
         * Otherwise, create a new instance.
         **/

        var fragment = supportFragmentManager.findFragmentByTag(USER_LIST_FRAGMENT_TAG)
        if (fragment == null)
            fragment = UserListFragment.newInstance()

        supportFragmentManager
                .beginTransaction()
                .replace(
                        R.id.main_fragment_container,
                        fragment,
                        USER_LIST_FRAGMENT_TAG)
                .commit()


    }

    companion object {

        private const val FRAGMENT_STATE_ARG = "FRAGMENT_STATE_ARG"

        private const val USER_LIST_FRAGMENT_TAG = "USER_LIST_FRAGMENT_TAG"

        private const val USER_CREATE_FRAGMENT_TAG = "USER_CREATE_FRAGMENT_TAG"
    }
}
