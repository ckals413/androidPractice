package com.example.android_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_practice.databinding.FragmentLikeBinding
import com.example.android_practice.databinding.FragmentMenuBinding

class MenuFragment: Fragment(){
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding= FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

}