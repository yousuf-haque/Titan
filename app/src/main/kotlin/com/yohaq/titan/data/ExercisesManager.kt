package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import io.realm.Realm
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesManager @Inject constructor(val realmFactory: () -> Realm) {


    fun createExercise(name: String) {

        realmFactory.invoke().executeTransaction {
            realmFactory.invoke().copyToRealm(Exercise(name = name))
        }

    }

    fun getExercises(): Observable<List<Exercise>> {
        val realm = realmFactory.invoke()
        return realm.where(Exercise::class.java).findAllAsync().asObservable().map { realm.copyFromRealm(it) }.doOnUnsubscribe { realm.close() }
    }

}