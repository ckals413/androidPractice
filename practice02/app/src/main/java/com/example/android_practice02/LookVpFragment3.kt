package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentVp3Binding

class LookVpFragment3 : Fragment() {

    lateinit var binding: FragmentVp3Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVp3Binding.inflate(inflater, container, false)

        return binding.root
    }
}