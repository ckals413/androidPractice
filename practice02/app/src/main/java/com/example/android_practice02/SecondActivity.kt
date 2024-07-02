package com.example.android_practice02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice02.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러뷰를 위한

        val itemList = listOf(
            Item("Title1", "Singer1", "2024-01-01", R.drawable.img_album_exp2),
            Item("Title2", "Singer2", "2024-01-02", R.drawable.img_album_exp2),
            Item("Title3", "Singer1", "2024-01-01", R.drawable.img_album_exp2),
            Item("Title4", "Singer2", "2024-01-02", R.drawable.img_album_exp2),
            Item("Title5", "Singer1", "2024-01-01", R.drawable.img_album_exp2),
            Item("Title6", "Singer2", "2024-01-02", R.drawable.img_album_exp2),
            // 추가 아이템들

        )

        val secondRVAdapter = SecondRVAdapter(this,itemList)

        secondRVAdapter.setMyItemClickListener(object : SecondRVAdapter.MyItemClickListener {
            override fun onRemoveItem(position: Int) {
                // 아이템 제거 로직

            }
        })


        binding.secondActivityRv.layoutManager = LinearLayoutManager(this)
        binding.secondActivityRv.adapter = secondRVAdapter




        binding.backButton.setOnClickListener {
            finish()
        }

    }
}
