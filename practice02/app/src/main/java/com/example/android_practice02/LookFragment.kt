package com.example.android_practice02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice02.databinding.FragmentLookBinding

class LookFragment : Fragment() {

    lateinit var binding: FragmentLookBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLookBinding.inflate(inflater, container, false)

        val lookAdapter = LookVPAdapter(this)
        binding.homeRecommendVp.adapter = lookAdapter
        binding.homeRecommendVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }


}