package com.example.projecthilt.domain.model

import com.example.projecthilt.data.dto.Address

data class Usuario(
    val firstName: String,
    val lastName: String,
    val address: Address,
    val age: Int,
    val email: String,
    val password: String,
    val phone: String,
    val image: String,
)
