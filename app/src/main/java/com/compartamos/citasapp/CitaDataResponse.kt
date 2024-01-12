package com.compartamos.citasapp

import com.google.gson.annotations.SerializedName

data class CitaDataResponse(
    @SerializedName("") val cita: List<CitaItemResponse>
)

data class CitaItemResponse(
    @SerializedName("id") val Id: String,
    @SerializedName("documento") val name: String,
    @SerializedName("nombre") val nombreUsuario: CitaUsuarioResponse
)

data class CitaUsuarioResponse(@SerializedName("nombre") val nombre:String)