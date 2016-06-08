package com.yohaq.titan.presenters.base

/**
 * Created by yousufhaque on 6/7/16.
 */
interface Presenter <MvpView> {
    var view: MvpView?

    fun attachView(view: MvpView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}