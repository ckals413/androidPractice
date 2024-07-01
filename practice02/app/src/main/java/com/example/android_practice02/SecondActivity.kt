package com.example.android_practice02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice02.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener {
            finish()
        }
        setContentView(binding.root)
    }
}
