package com.padcmyanmar.padc9.myphotokotlinapplication.data.vos

import com.google.gson.annotations.SerializedName

data class PhotoUrlVO(

    @SerializedName("raw")
    var raw: String,

    @SerializedName("full")
    var full: String,

    @SerializedName("regular")
    var regular: String,

    @SerializedName("small")
    var small: String,

    @SerializedName("thumb")
    var thumb: String
)