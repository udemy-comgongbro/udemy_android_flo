package com.example.flo

import java.util.*

data class Album(
        var title: String? = "",
        var singer: String? = "",
        var coverImg: Int? = null,
        var songs: ArrayList<Song>? = null
)
