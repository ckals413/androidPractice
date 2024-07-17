package com.example.retrofit2practice01


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2practice01.databinding.ActivityMainItemBinding

class Adapter(val items: MutableList<MovieData.BoxOfficeResult.DailyBoxOffice?>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = ActivityMainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class ViewHolder(val binding: ActivityMainItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MovieData.BoxOfficeResult.DailyBoxOffice?){

            binding.tvMovieNm.text = "영화이름:${item?.movieNm}🎬"
            binding.tvOpenDt.text = "개봉일:${item?.openDt}일🍿"
            binding.tvSalesAmt.text = "매출액:${item?.salesAmt}원⭐"
            binding.tvAudiChange.text = "전일대비:${item?.audiChange}%"
            binding.tvSalesAcc.text = "누적매출:${item?.salesAcc}원⭐"
            binding.tvAudiAcc.text = "누적관객수:${item?.audiAcc}명👏"

        }
    }
}