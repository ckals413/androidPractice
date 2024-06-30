package com.example.android_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_practice.databinding.FragmentHomeBinding
import com.example.android_practice.databinding.FragmentLikeBinding

class LikeFragment: Fragment(){
    lateinit var binding: FragmentLikeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding= FragmentLikeBinding.inflate(inflater,container,false)
        return binding.root
    }

}