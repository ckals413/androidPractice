package com.example.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var binding: // 뷰 바인딩 함수


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigation()



    }
    private initBottomNavigation(){
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,HomeFragment()).commitAllowingStateLoss()

    }
}