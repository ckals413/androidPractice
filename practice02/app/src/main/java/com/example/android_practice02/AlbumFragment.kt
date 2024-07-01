package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentAlbumBinding
import com.example.android_practice02.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding
    //탭레이아웃에 들어갈 칸마다의 문자
    private val information = arrayListOf("1번","2번","3번")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        val albumAdapter = AlbumVPAdapter(this)
        binding.albumContentVp.adapter = albumAdapter
        //탭레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.albumContentTb,binding.albumContentVp){
            tab,position->
            tab.text = information[position]
        }.attach()



        return binding.root
    }
}