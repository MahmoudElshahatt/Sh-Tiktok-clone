package com.shahott.sh_tiktok_clone.models

data class Video(
    val id:Int = 0,
    val username : String = "",
    val userImage : Int =0,
    val caption : String = " ",
    val audio : String = " ",
    val likes : Int = 0,
    val comments:Int = 0,
    val shares : Int = 0,
    val isVideo : Boolean = false,
    val video : Int? = null,
    val image : Int? = null,
    val videoLengthInMilli : Long? = 150000 ,

)