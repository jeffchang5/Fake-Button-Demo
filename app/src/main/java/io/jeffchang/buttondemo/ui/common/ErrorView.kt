package io.jeffchang.buttondemo.ui.common

import android.content.Context
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.widget.RelativeLayout
import io.jeffchang.buttondemo.R
import kotlinx.android.synthetic.main.view_error.view.*

/**
 * View that displays a screen when the user has lost connectivity.
 *
 * @property[tryAgainCallback] A callback to load to reattempt the network call.
 */
class ErrorView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    var iconDrawable: Int? = R.drawable.ic_cloud_off_black_24dp
        set(icon) {
            icon?.let { error_view_imageview_icon.setImageResource(it) }
        }

    var titleText: Int = R.string.device_offline
        set(title) = error_view_error_textview.setText(title)

    var tryAgainCallback: (() -> Unit)? = null
        set(callback) {
            error_view_error_description_textview.setOnClickListener({
                callback?.invoke()
            })
        }

    constructor(context: Context): this(context, null)

    @ColorInt
    var textColor: Int? = null
        set(colorRes) {
            colorRes?.let {
                val color = ContextCompat.getColor(context, colorRes)
                error_view_error_textview.setTextColor(color)
                error_view_error_description_textview
                        .setTextColor(color)
                error_view_imageview_icon?.setColorFilter(color,
                        android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }



    init {
        inflate(context, R.layout.view_error, this)
        val tryAgainSpan = SpannableString(error_view_error_description_textview.text)
        tryAgainSpan.setSpan(UnderlineSpan(), 0 , tryAgainSpan.length, 0)
        error_view_error_description_textview.text = tryAgainSpan
    }
}