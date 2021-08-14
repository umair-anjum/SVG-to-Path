package com.example.svgpathsetting.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Path {
    @SerializedName("_android:name")
    @Expose
    var androidName: String? = null

    @SerializedName("_android:fillColor")
    @Expose
    var androidFillColor: String? = null

    @SerializedName("_android:pathData")
    @Expose
    var androidPathData: String? = null
}