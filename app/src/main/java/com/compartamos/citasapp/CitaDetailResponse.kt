package com.compartamos.citasapp

import com.google.gson.annotations.SerializedName

data class CitaDetailResponse(
    @SerializedName("nombre") val nombre: String,
    @SerializedName("documento") val documento: CitaNameDetailResponse,
)



data class CitaNameDetailResponse(@SerializedName("nombre") val nombre:String)
