package com.example.svgpathsetting.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Vector {
    @SerializedName("path")
    @Expose
    var path: List<Path>? = null

    @SerializedName("_xmlns:android")
    @Expose
    var xmlnsAndroid: String? = null

    @SerializedName("_android:width")
    @Expose
    var androidWidth: String? = null

    @SerializedName("_android:height")
    @Expose
    var androidHeight: String? = null

    @SerializedName("_android:viewportWidth")
    @Expose
    var androidViewportWidth: String? = null

    @SerializedName("_android:viewportHeight")
    @Expose
    var androidViewportHeight: String? = null
}