package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import io.realm.Realm
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesManager @Inject constructor(val realm: Realm) {


    fun createExercise(name: String) {

        realm.executeTransaction {
            val exercise = realm.createObject(Exercise::class.java)
            exercise.name = name
        }

    }

    fun getExercises(): Observable<List<Exercise>> {


        return realm.where(Exercise::class.java).findAllAsync().asObservable().map map@{
            val result = realm.copyFromRealm(it)
            return@map result

        }

    }
}