package com.example.android_practice02

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LookVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LookVpFragment1()
            1-> LookVpFragment2()
            2-> LookVpFragment3()
            else -> LookVpFragment1()
        }
    }
}