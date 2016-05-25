package com.github.chuross.trancebaka.ui.activity.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import com.github.chuross.library.mvp.presenter.ActivityPresenter
import com.github.chuross.library.mvp.view.activity.PresentationActivity
import com.trello.rxlifecycle.ActivityEvent
import com.trello.rxlifecycle.ActivityLifecycleProvider
import com.trello.rxlifecycle.LifecycleTransformer
import com.trello.rxlifecycle.RxLifecycle
import rx.Observable
import rx.subjects.BehaviorSubject


abstract class BasePresentationActivity<PRESENTER : ActivityPresenter<*>, BINDING : ViewDataBinding> : PresentationActivity<PRESENTER, BINDING>(), ActivityLifecycleProvider {

    private val lifecycleSubject: BehaviorSubject<ActivityEvent> = BehaviorSubject.create();

    override fun <T : Any?> bindUntilEvent(event: ActivityEvent): LifecycleTransformer<T> = RxLifecycle.bindUntilEvent(lifecycleSubject, event);

    override fun lifecycle(): Observable<ActivityEvent> = lifecycleSubject.asObservable();

    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> = RxLifecycle.bindActivity(lifecycleSubject);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    override fun onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause()
    }

    override fun onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop()
    }

    override fun onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy()
    }
}