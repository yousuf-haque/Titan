package com.yohaq.titan.data.models

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

/**
 * Created by yousufhaque on 6/7/16.
 */
@RealmClass
open class Exercise(
        @PrimaryKey
        var id: String = UUID.randomUUID().toString(),
        var name: String = ""
) : RealmModel {
}