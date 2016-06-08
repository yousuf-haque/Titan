package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import io.realm.Realm
import rx.Observable
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesManager @Inject constructor() {


    lateinit private var exercises: List<Exercise>

    lateinit var realm: Realm

    init {
//
//        exercises = ArrayList<Exercise>()
//        for (name in arrayOf("push up", "sit up", "DataManager working", "RX working")) {
//            (exercises as ArrayList<Exercise>).add(Exercise(name = name))
//        }
//        realm = Realm.getDefaultInstance()
//
//        realm.executeTransaction {
//            val exercise = realm.createObject(Exercise::class.java)
//            exercise.id = UUID.randomUUID().toString()
//            exercise.name = "realmWorking"
//        }
//
//        realm.close()


    }


    fun getExercises(): Observable<List<Exercise>> {

        realm = Realm.getDefaultInstance()

        val realmResults = realm.where(Exercise::class.java).findAllAsync().asObservable().map map@{
            val result = realm.copyFromRealm(it)
            realm.close()
            return@map result

        }

        return realmResults
    }
}