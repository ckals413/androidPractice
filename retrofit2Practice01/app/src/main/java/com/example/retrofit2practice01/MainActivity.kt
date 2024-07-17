package com.example.retrofit2practice01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.project.databinding.ActivityMainBinding
import com.example.retrofit2practice01.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { Adapter(dataList) }
    private val dataList = mutableListOf<MovieData.BoxOfficeResult.DailyBoxOffice?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager = LinearLayoutManager(this)

        binding.btnSearch.setOnClickListener { movieRequest() }
    }

    fun movieRequest() {

        //1.Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://www.kobis.or.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. 서비스 객체 생성
        val apiService: MovieService = retrofit.create(MovieService::class.java)
        //3. Call 객체 생성
        val inputDate = binding.etInput.text.trim().replace(Regex(" "), "")
        val movieCall = apiService.getmovieinfo(
            "ApiKey", // 여기서 APikey는 실제 본인의 APi key값으로 대체합니다.
            inputDate,
            "10",
            "N",
            "K",
            ""
        )

        if (!dataList.isEmpty()) {
            dataList.clear()
        }
        movieCall.enqueue(object : Callback<MovieData> {
            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                val data = response.body()

                val movieinfo = data?.boxOfficeResult?.dailyBoxOfficeList

                if (!movieinfo.isNullOrEmpty()) {
                    movieinfo?.let { info ->
                        info.forEach {
                            dataList.add(it)
                        }
                    }
                    adapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<MovieData>, t: Throwable) {

                call.cancel()
            }
        })

    }
}
ea62ddd3dbda048a1eb10658afbae977
