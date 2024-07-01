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

    //탭 레이아웃에 들어갈 칸마다 문자


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLookBinding.inflate(inflater, container, false)

        // =====================================================
        //뷰페이저 설정
        val lookAdapter = LookVPAdapter(this)
        binding.lookRecommendVp.adapter = lookAdapter
        binding.lookRecommendVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //인디케이터 연결
        binding.lookPannelIndicator.setViewPager(binding.lookRecommendVp)


        //======================================================
        //뷰페이저 설정
        val lookAdapter2 = LookVPAdapter(this)
        binding.lookRecommendVp2.adapter = lookAdapter2
        binding.lookRecommendVp2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }


}