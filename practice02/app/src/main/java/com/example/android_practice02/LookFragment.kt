package com.example.android_practice02

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice02.databinding.FragmentLookBinding
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class LookFragment : Fragment() {

    lateinit var binding: FragmentLookBinding

    //자동 넘김을 의한 변수
    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())



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

        startAutoSlide(lookAdapter2)

        return binding.root
    }

    private fun startAutoSlide(adpater : LookVPAdapter) {
        // 일정 간격으로 슬라이드 변경 (3초마다)
        timer.scheduleAtFixedRate(3000, 3000) {
            handler.post {
                val nextItem = binding.lookRecommendVp2.currentItem + 1
                if (nextItem < adpater.itemCount) {
                    binding.lookRecommendVp2.currentItem = nextItem
                } else {
                    binding.lookRecommendVp2.currentItem = 0 // 마지막 페이지에서 첫 페이지로 순환
                }
            }
        }
    }


}