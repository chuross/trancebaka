package com.github.chuross.trancebaka.ui.fragment.base

import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.library.mvp.view.fragment.SupportPresentationFragment
import com.github.chuross.trancebaka.ui.activity.ScreenActivity
import com.trello.rxlifecycle.FragmentEvent
import com.trello.rxlifecycle.FragmentLifecycleProvider
import com.trello.rxlifecycle.LifecycleTransformer
import com.trello.rxlifecycle.RxLifecycle
import rx.Observable
import rx.subjects.BehaviorSubject
import rx.subscriptions.CompositeSubscription


abstract class BasePresentationFragment<PRESENTER : SupportFragmentPresenter<*>, BINDING : ViewDataBinding> : SupportPresentationFragment<PRESENTER, BINDING>(), FragmentLifecycleProvider {

    val screenActivity: ScreenActivity get() = activity as ScreenActivity
    val subscriptions by lazy { CompositeSubscription() }
    private val lifecycleSubject: BehaviorSubject<FragmentEvent> = BehaviorSubject.create();


    override fun lifecycle(): Observable<FragmentEvent> = lifecycleSubject.asObservable();

    override fun <T : Any?> bindUntilEvent(event: FragmentEvent): LifecycleTransformer<T> = RxLifecycle.bindUntilEvent(lifecycleSubject, event);

    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> = RxLifecycle.bindFragment(lifecycleSubject);

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        lifecycleSubject.onNext(FragmentEvent.ATTACH);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE);
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW);
    }

    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(FragmentEvent.START);
    }

    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    override fun onPause() {
        lifecycleSubject.onNext(FragmentEvent.PAUSE);
        super.onPause()
    }

    override fun onStop() {
        lifecycleSubject.onNext(FragmentEvent.STOP);
        super.onStop()
    }

    override fun onDestroyView() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView()
    }

    override fun onDestroy() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY);
        subscriptions.unsubscribe()
        super.onDestroy()
    }

    override fun onDetach() {
        lifecycleSubject.onNext(FragmentEvent.DETACH);
        super.onDetach()
    }
}