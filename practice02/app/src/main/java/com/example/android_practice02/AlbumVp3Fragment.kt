package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentAlbumVp1Binding
import com.example.android_practice02.databinding.FragmentAlbumVp3Binding

class AlbumVp3Fragment : Fragment(){
    lateinit var binding: FragmentAlbumVp3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAlbumVp3Binding.inflate(inflater,container,false)
        return binding.root
    }
}