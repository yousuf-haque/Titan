package com.yohaq.titan.presenters.base

import rx.subscriptions.CompositeSubscription

/**
 * Created by yousufhaque on 2/15/16.
 */
abstract class BasePresenter<MvpView> : Presenter<MvpView> {
    override var view: MvpView? = null

    var subscriptions: CompositeSubscription? = null

    override fun attachView(view: MvpView) {
        super.attachView(view)
        subscribe()

    }

    override fun detachView() {
        super.detachView()
        unsubscribe()
    }

    open fun subscribe() {
        subscriptions = CompositeSubscription()
    }

    open fun unsubscribe() {
        subscriptions?.unsubscribe()
        subscriptions = null
    }

}