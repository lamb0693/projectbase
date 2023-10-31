package com.example.googlemapexample.util

import java.util.Timer
import java.util.TimerTask

class CustomTimer {
    private lateinit var onTimerCallback : ()->Unit  // listener를 함수 형태로 선언
    private val timer = Timer() // timer 선언

    fun setOnTimerCallback(onTimerCallback : ()->Unit){
        this.onTimerCallback = onTimerCallback
    }

    // delay 와 간격 설정
    fun start(delay : Long, period : Long) {
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                onTimerCallback()
            }
        }, delay, period)
    }

    fun stop(){
        timer.cancel()
    }
}