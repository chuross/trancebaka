package com.github.chuross.trancebaka.ui.fragment.base

import android.databinding.ViewDataBinding
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.library.mvp.view.fragment.SupportPresentationFragment
import com.github.chuross.trancebaka.ui.activity.ScreenActivity
import rx.subscriptions.CompositeSubscription


abstract class BasePresentationFragment<PRESENTER : SupportFragmentPresenter<*>, BINDING : ViewDataBinding> : SupportPresentationFragment<PRESENTER, BINDING>() {

    val screenActivity: ScreenActivity get() = activity as ScreenActivity
    val subscriptions by lazy { CompositeSubscription() }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }

}