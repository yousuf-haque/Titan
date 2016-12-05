package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.Workout
import com.yohaq.titan.data.models.WorkoutSet
import io.realm.Realm
import io.realm.RealmList
import rx.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutManager @Inject constructor(val realmFactory: () -> Realm) {


    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: List<WorkoutSet>) {

        realmFactory.invoke().executeTransaction {
                val workout = Workout( dateCreated, exercise, RealmList<WorkoutSet>(*sets.toTypedArray()))

            realmFactory.invoke().copyToRealmOrUpdate(workout)
        }

    }

    fun getWorkouts(): Observable<List<Workout>> {
        val realm = realmFactory.invoke()

        return realm.where(Workout::class.java).findAllAsync().asObservable().map { realm.copyFromRealm(it) }.doOnUnsubscribe { realm.close() }
    }

}