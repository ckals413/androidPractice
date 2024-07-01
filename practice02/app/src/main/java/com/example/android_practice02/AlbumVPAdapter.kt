package com.example.android_practice02

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlbumVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->AlbumVp1Fragment()
            1->AlbumVp2Fragment()
            else->AlbumVp3Fragment()
        }
    }
}