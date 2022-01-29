package com.example.flo


//제목, 가수, 사진,재생시간,현재 재생시간, isplaying(재생 되고 있는지)

data class Song(
        val title : String = "",
        val singer : String = "",
        var second: Int = 0,
        var playTime: Int = 0,
        var isPlaying: Boolean = false,
        var music : String = ""
)
