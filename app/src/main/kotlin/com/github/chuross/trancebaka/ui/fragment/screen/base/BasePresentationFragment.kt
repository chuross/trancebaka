package com.github.chuross.trancebaka.ui.fragment.screen.base

import android.databinding.ViewDataBinding
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.library.mvp.view.fragment.SupportPresentationFragment
import com.github.chuross.trancebaka.ui.activity.ScreenActivity


abstract class BasePresentationFragment<PRESENTER : SupportFragmentPresenter<*>, BINDING : ViewDataBinding> : SupportPresentationFragment<PRESENTER, BINDING>() {

    val screenActivity: ScreenActivity get() = activity as ScreenActivity
}