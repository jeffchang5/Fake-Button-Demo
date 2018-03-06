package io.jeffchang.buttondemo.ui.common

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.RelativeLayout
import io.jeffchang.buttondemo.R
import kotlinx.android.synthetic.main.view_progress_bar.view.*

/**
 * View that displays a progress bar and a message that is the rationale for the progress bar.
 */

class ProgressBarView constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
    : RelativeLayout(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)

    var loadingText: String? = null
        set(text) {
            progress_loading_textview.text = text
        }

    init {
        inflate(context, R.layout.view_progress_bar, this)
        progress_progress_bar?.progressDrawable?.setColorFilter(
                Color.WHITE,
                android.graphics.PorterDuff.Mode.SRC_IN)
        progress_progress_bar?.indeterminateDrawable?.setColorFilter(
                Color.WHITE,
                android.graphics.PorterDuff.Mode.SRC_IN)
    }
}
