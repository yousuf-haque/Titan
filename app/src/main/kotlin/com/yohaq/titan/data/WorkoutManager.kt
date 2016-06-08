package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import com.yohaq.titan.data.models.Workout
import io.realm.Realm
import io.realm.RealmList
import rx.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/8/16.
 */
class WorkoutManager @Inject constructor(val realm : Realm){



    fun createWorkout(dateCreated: Date) {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            val workout = realm.createObject(Workout::class.java)
            workout.date = Date()
            workout.exercises = RealmList<Exercise>()

        }

        realm.close()
    }

    fun getWorkouts() : Observable<List<Workout>> {
        return realm.where(Workout::class.java).findAllAsync().asObservable().map map@{
            val result = realm.copyFromRealm(it)
            return@map result

        }
    }
}