package com.yohaq.titan.data.models

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

/**
 * Created by yousufhaque on 6/8/16.
 */

@RealmClass
open class Workout(
        var date: Date = Date(),
        var exercise: Exercise? = null,
        var sets: RealmList<WorkoutSet> = RealmList<WorkoutSet>()
) : RealmModel {
    @PrimaryKey
    var id: String

    init {
        id = UUID.randomUUID().toString()
    }
}