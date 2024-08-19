package com.example.projecthilt.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseAPIDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    @SerializedName("users")
    val usuarioDTOS: List<usuarioDTO>
)