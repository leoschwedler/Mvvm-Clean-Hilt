package com.example.projecthilt.data.dto

data class ResponseAPIDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val usuarioDTOS: List<usuarioDTO>
)