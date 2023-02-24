package com.jae1jeong.github.utlis

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T> Flow<T>.throttleFirst(duration:Long):Flow<T> = flow{
    var lastEmissionTime = 0L
    collect { value ->
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastEmissionTime > duration){
            lastEmissionTime = currentTime
            emit(value)
        }
    }
}