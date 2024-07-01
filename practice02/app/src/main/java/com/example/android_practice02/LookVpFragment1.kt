package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentVp1Binding

class LookVpFragment1 : Fragment() {

    lateinit var binding: FragmentVp1Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVp1Binding.inflate(inflater, container, false)

        return binding.root
    }
}