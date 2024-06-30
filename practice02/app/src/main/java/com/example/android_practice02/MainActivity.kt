package com.example.android_practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

    }

    private fun initBottomNavigation(){
        //처음 실행 할 때 main_frm에 보일 뷰 설정
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm,HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { itme->
            when(itme.itemId){
                R.id.homeFragment->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm,HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lookFragment->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm,LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                //여기에 바텀네비뷰에 항목(아이템)이 더 있다면, 위와 같은 템플릿으로 추가하기
            }
            false
        }
    }
}