package com.yohaq.titan.data

import com.yohaq.titan.data.models.Exercise
import java.util.*
import javax.inject.Inject

/**
 * Created by yousufhaque on 6/7/16.
 */
class ExercisesManager @Inject constructor() {


    lateinit private var exercises: List<Exercise>

    init {

        exercises = ArrayList<Exercise>()
        for (name in arrayOf("push up", "sit up", "DataManager working")) {
            (exercises as ArrayList<Exercise>).add(Exercise(name))
        }

    }


    fun getExercises() = exercises
}