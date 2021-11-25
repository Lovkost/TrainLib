package com.example.trainlib.data.schedulers

import io.reactivex.Scheduler


interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler

}