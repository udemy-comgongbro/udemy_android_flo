package com.example.flo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SongService() {
    private lateinit var lookView: LookView

    fun setLookView(lookView: LookView) {
        this.lookView = lookView
    }

    fun getSongs() {
        val songService = getRetrofit().create(SongRetrofitInterfaces::class.java)

        lookView.onGetSongLoading()

        songService.getSongs().enqueue(object : Callback<SongResponse> {
            override fun onResponse(call: Call<SongResponse>, response: Response<SongResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val songResponse: SongResponse = response.body()!!

                    Log.d("SONG-RESPONSE", songResponse.toString())

                    when (val code = songResponse.code) {
                        1000 -> {
                            lookView.onGetSongSuccess(code, songResponse.result!!)
                        }

                        else -> lookView.onGetSongFailure(code, songResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<SongResponse>, t: Throwable) {
                lookView.onGetSongFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }
}