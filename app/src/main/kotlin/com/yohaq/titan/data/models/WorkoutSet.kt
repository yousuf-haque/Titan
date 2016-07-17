package com.yohaq.titan.data.models

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

/**
 * Created by yousufhaque on 6/8/16.
 */
@RealmClass
open class WorkoutSet(
        @PrimaryKey
        var id: String = UUID.randomUUID().toString(),
        var weight: Float = 0f,
        var reps: Int = 0
)
: RealmModel {

}