package com.yohaq.titan.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.jakewharton.rxbinding.view.clicks
import com.jakewharton.rxbinding.view.enabled
import com.jakewharton.rxbinding.widget.textChanges
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import rx.Observable
import rx.functions.Action1

/**
 * Created by yousufhaque on 12/5/16.
 */
infix fun  <T> Observable<T>.boundTo(view : View) =
        bindToLifecycle(view).share()

infix fun  <T> Observable<T>.subScribeWith(action : Action1<in T>) =
        subscribe(action)

@BindingAdapter("android:onClick")
fun bindToClicks(view: View, handler : Action1<Unit>) {
    view.clicks().bindToLifecycle(view).subscribe(handler)
}
@BindingAdapter("onTextChange")
fun bindToTextChanges(view: EditText, handler : Action1<CharSequence>) {
    view.textChanges().bindToLifecycle(view).subscribe(handler)
}

@BindingAdapter("android:enabled")
fun bindEnabled(view: Button, isEnabledObservable : Observable<Boolean>) {
    isEnabledObservable.bindToLifecycle(view).subscribe(view.enabled())
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter : RecyclerView.Adapter<*>) {
    view.adapter = adapter
}


@BindingAdapter("layout_manager")
fun  layoutManager(view: RecyclerView, manager : RecyclerView.LayoutManager ) {
    view.layoutManager = manager
}