package com.example.recyclerviewpractice01

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice01.databinding.ItemRecyclerviewBinding

class CustomAdapter(val profileList : ArrayList<Profile>): RecyclerView.Adapter<CustomAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = profileList[position].name
        holder.age.text = profileList[position].age.toString()
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root){
        val name = binding.rvName
        val age = binding.rvAge
    }
}