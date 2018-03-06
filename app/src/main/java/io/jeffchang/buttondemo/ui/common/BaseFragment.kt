package io.jeffchang.buttondemo.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import dagger.android.support.DaggerFragment

/**
 * The base which Fragments in this project will extend.
 */

abstract class BaseFragment : DaggerFragment() {

    private var parentView: FrameLayout? = null

    private var progressBarView: ProgressBarView? = null

    private var errorView: ErrorView? = null

    private var mainView: View? = null

    abstract var layoutResourceID: Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        context?.let {
            parentView = FrameLayout(it)
            parentView?.layoutParams = params

            progressBarView = ProgressBarView(it)
            progressBarView?.layoutParams = params
            progressBarView?.visibility = View.GONE
            parentView?.addView(progressBarView)

            errorView = ErrorView(it)
            errorView?.layoutParams = params
            errorView?.visibility = View.GONE
            parentView?.addView(errorView)

            mainView = inflater.inflate(layoutResourceID, container, false)
            parentView?.addView(mainView)
        }
        return parentView
    }

    fun showProgressBar(loadingText: String) {
        mainView?.visibility = View.GONE
        errorView?.visibility = View.GONE
        progressBarView?.loadingText = loadingText
        progressBarView?.visibility = View.VISIBLE
    }

    fun showMainContent() {
        progressBarView?.visibility = View.GONE
        errorView?.visibility = View.GONE
        mainView?.visibility = View.VISIBLE
    }

    fun showErrorView(drawableInt: Int?, error: Int, callback: () -> Unit) {
        progressBarView?.visibility = View.GONE
        mainView?.visibility = View.GONE
        errorView?.tryAgainCallback = callback
        errorView?.titleText = error
        errorView?.iconDrawable = drawableInt
        errorView?.visibility = View.VISIBLE
    }
}
