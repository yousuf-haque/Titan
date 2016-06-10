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
class WorkoutManager @Inject constructor(val realm : Realm){


    fun createWorkout(dateCreated: Date, exercise: Exercise, sets: RealmList<WorkoutSet>) {

        realm.executeTransaction {
            val workout = Workout(date = dateCreated, exercise = exercise, sets = sets)

            realm.copyToRealmOrUpdate(workout)
        }

    }

    fun getWorkouts() : Observable<List<Workout>> {
        return realm.where(Workout::class.java).findAllAsync().asObservable().map map@{
            val result = realm.copyFromRealm(it)
            return@map result

        }
    }
}