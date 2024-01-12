package com.compartamos.citasapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/agenda/{codigoUsuario}")
    suspend fun getCitas(@Path("name") citaName:String):Response<CitaDataResponse>

    @GET("/api/agenda/{documento}")
    suspend fun getCitasDetail(@Path("id") citaDocumento:String):Response<CitaDetailResponse>

}