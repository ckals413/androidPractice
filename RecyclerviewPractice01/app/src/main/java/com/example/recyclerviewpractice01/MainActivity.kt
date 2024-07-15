package com.example.recyclerviewpractice01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice01.databinding.ActivityMainBinding

//****************************************************************//
//***********     리사이클러뷰 참고 블로그    ************************//
//  https://jutole.tistory.com/9#4.%20CustomAdapter-1
//****************************************************************//

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding.root로 바꿔줘야, 화면에 나온다!!!!!!!!!!!!!!!
        setContentView(binding.root)

        val profileList = ArrayList<Profile>()
        profileList.add(Profile("hello",1))
        profileList.add(Profile("hello",2))
        profileList.add(Profile("hello",3))
        profileList.add(Profile("hello",4))
        profileList.add(Profile("hello",5))
        profileList.add(Profile("hello",6))
        profileList.add(Profile("hello",7))
        profileList.add(Profile("hello",8))
        profileList.add(Profile("hello",9))
        profileList.add(Profile("hello",10))
        profileList.add(Profile("hello",12))
        profileList.add(Profile("hello",13))
        profileList.add(Profile("hello",14))



        binding.rv.adapter = CustomAdapter(profileList)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

    }
}