package io.jeffchang.buttondemo.ui.usercreate.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import io.jeffchang.buttondemo.R
import io.jeffchang.buttondemo.models.User
import io.jeffchang.buttondemo.ui.common.BaseFragment
import io.jeffchang.buttondemo.ui.usercreate.presenter.UserCreatePresenter
import kotlinx.android.synthetic.main.fragment_user_create.*
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject
import java.util.regex.Pattern


/**
 * Fragment that displays details about a dog breed.
 */

class UserCreateFragment : BaseFragment(), UserCreateView {

    override var layoutResourceID = R.layout.fragment_user_create

    private var isFullNameFieldValid = false

    private var isEmailFieldValid = false

    @Inject lateinit var userCreatePresenter: UserCreatePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail_fragment_full_name_text_input_edit_text.addTextChangedListener( object: TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                val text = editable.toString()
                val regex = "[a-zA-Z]+\\.?"
                val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                val matcher = pattern.matcher(text)
                isFullNameFieldValid = matcher.find()
                checkIfFieldsAreValid()
            }
        })

        detail_fragment_email_text_input_edit_text.addTextChangedListener( object: TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                val text = editable.toString()
                isEmailFieldValid =
                        !TextUtils.isEmpty(text) and Patterns.EMAIL_ADDRESS.matcher(text).matches()
                checkIfFieldsAreValid()
            }
        })
        detail_fragment_create_button.setOnClickListener {
            userCreatePresenter.postUser(
                    detail_fragment_full_name_text_input_edit_text.text.toString(),
                    detail_fragment_email_text_input_edit_text.text.toString()
            )
        }
    }

    override fun postUserSuccess(user: User) {
        activity?.onBackPressed()
    }

    override fun postUserFailure(error: Throwable) {
        when (error) {
            is HttpException -> {
                if (error.code() == 401) {
                    Toast.makeText(context, "Unauthorized", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Unknown error", Toast.LENGTH_LONG).show()
                }
            }
            is UnknownHostException ->
                Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show()

        }
    }

    private fun checkIfFieldsAreValid() {
        detail_fragment_create_button.isEnabled = isEmailFieldValid and isFullNameFieldValid
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
