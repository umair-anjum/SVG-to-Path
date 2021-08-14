package com.example.svgpathsetting.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {
    @SerializedName("vector")
    @Expose
    var vector: Vector? = null
}