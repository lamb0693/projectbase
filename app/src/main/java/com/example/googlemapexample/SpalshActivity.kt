package com.example.googlemapexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.googlemapexample.util.CustomTimer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpalshActivity : AppCompatActivity() {
    lateinit var binding : ActivityS

    val splashTimer : CustomTimer = CustomTimer()
    var count : Int = 0

    val onTimer : () -> Unit = fun () {
        count ++
        changeImageView(count)

        if(count==4) {
            Log.i("SpalshActivity", count.toString())
            splashTimer.stop()
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }
    }

    fun changeImageView(idx : Int){

        val mainScope = CoroutineScope(Dispatchers.Main)
        mainScope.launch {
            binding.frameLayout.removeViewAt(0 )// 첫번째 view를 제거
            when {
                idx ===1 -> binding.frameLayout.addView(binding.imageView1)
                idx ===2 -> binding.frameLayout.addView(binding.imageView2)
                idx ===3 -> binding.frameLayout.addView(binding.imageView3)
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpalshBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashTimer.setOnTimerCallback( onTimer)
        splashTimer.start(2000,1000)

    }
}