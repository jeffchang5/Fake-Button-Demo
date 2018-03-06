package io.jeffchang.buttondemo.ui.usercreate.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.jeffchang.buttondemo.R

/**
 * Fragment that displays details about a dog breed.
 */

class UserCreateFragment : Fragment(), UserCreateView {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {

        fun newInstance(): UserCreateFragment {
            val args = Bundle()
            val fragment = UserCreateFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
