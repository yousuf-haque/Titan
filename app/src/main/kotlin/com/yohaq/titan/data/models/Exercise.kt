package com.yohaq.titan.data.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by yousufhaque on 6/7/16.
 */
open class Exercise(
        @PrimaryKey
        var id: String = UUID.randomUUID().toString(),
        var name: String = ""
) : RealmObject() {
}