package com.example.svgpathsetting.dataModel

data class VectorJson(
        val androidwidth: String? = null,
        val androidheight: String? = null,
        val androidviewportWidth: String? = null,
        val androidviewportHeight: String? = null,
        val path: List<Path>? = null
)

data class Path1(
        val androidname: String? = null,
        val androidfillColor: String? = null,
        val androidpathData: String? = null,
        val androidfillAlpha: String? = null,
        val androidstrokeAlpha: String? = null
)
