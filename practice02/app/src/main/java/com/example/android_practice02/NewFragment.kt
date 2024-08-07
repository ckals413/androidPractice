package com.example.android_practice02

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice02.databinding.FragmentNewBinding

class NewFragment : Fragment() {

    lateinit var binding: FragmentNewBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBinding.inflate(inflater, container, false)

        binding.button1.setOnClickListener {
            val intent = Intent(activity,SecondActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}