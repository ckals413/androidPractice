package com.example.android_practice02

import com.example.android_practice02.databinding.ItemSecondActivityBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Item(
    val title: String,
    val singer: String,
    val releaseDate: String,
    val imageResId: Int
)

class SecondRVAdapter(private val context: Context, private val itemList: List<Item>) : RecyclerView.Adapter<SecondRVAdapter.ItemViewHolder>() {

    private lateinit var mItemClickListener: MyItemClickListener

    interface MyItemClickListener {
        fun onRemoveItem(position: Int)
    }

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: ItemSecondActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        private val coverImg: ImageView = binding.itemImage
        private val title: TextView = binding.itemTitleTv
        private val singer: TextView = binding.itemSingerTv
        private val releaseDate: TextView = binding.itemReleaseTv

        fun bind(item: Item) {
            title.text = item.title
            singer.text = item.singer
            releaseDate.text = item.releaseDate
            Glide.with(context).load(item.imageResId).into(coverImg)

            itemView.setOnClickListener {
                Toast.makeText(context, "클릭", Toast.LENGTH_SHORT).show()
               // mItemClickListener.onRemoveItem(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemSecondActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
