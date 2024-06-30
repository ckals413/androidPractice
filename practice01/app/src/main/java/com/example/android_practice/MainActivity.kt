package com.example.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.android_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        // 초기 화면 설정
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, HomeFragment())
            .commitAllowingStateLoss()

        // BottomNavigationView 아이템 선택 리스너 설정
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.likeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, LikeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.menuFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, MenuFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
