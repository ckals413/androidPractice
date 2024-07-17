package com.example.retrofit2practice01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2practice01.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//*****************************************************
//참고 블로그
//https://velog.io/@yoneeo/AndroidKotlin-Retrofit2-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-RecyclerView%EC%97%90-Rest-API-%ED%98%B8%EC%B6%9C%ED%95%98%EA%B8%B0
//*****************************************************

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
            "ea62ddd3dbda048a1eb10658afbae977", // 여기서 APikey는 실제 본인의 APi key값으로 대체합니다.
            inputDate,
            "10",
            "N",
            "K",
            ""
        )

        if (dataList.isNotEmpty()) {
            dataList.clear()
        }
        movieCall.enqueue(object : Callback<MovieData> {
            override fun onResponse(call: retrofit2.Call<MovieData>, response: Response<MovieData>) {
                Log.d("API Response", response.body().toString())

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

            override fun onFailure(call: retrofit2.Call<MovieData>, t: Throwable) {
                Log.e("API Failure", t.message ?: "Unknown error")
                call.cancel()
            }
        })

    }
}
