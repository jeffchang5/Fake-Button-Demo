package io.jeffchang.buttondemo.di.components

import dagger.Subcomponent
import dagger.android.AndroidInjector
import io.jeffchang.buttondemo.ui.MainActivity

/**
 * Component that injects dependencies into [MainActivity] such as
 * its Presenter and View contracts.
 */

@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}