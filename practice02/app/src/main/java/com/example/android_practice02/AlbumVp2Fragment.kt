package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentAlbumVp1Binding
import com.example.android_practice02.databinding.FragmentAlbumVp2Binding

class AlbumVp2Fragment : Fragment(){
    lateinit var binding: FragmentAlbumVp2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAlbumVp2Binding.inflate(inflater,container,false)
        return binding.root
    }
}