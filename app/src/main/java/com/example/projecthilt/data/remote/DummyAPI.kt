package com.example.projecthilt.data.remote

import com.example.projecthilt.data.dto.ResponseAPIDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    @GET("users")
    suspend fun getUsers() : Response<ResponseAPIDTO>
}