package com.example.projecthilt.data.dto

import com.example.projecthilt.domain.model.Usuario

data class usuarioDTO(
    val address: Address,
    val age: Int,
    val bank: Bank,
    val birthDate: String,
    val bloodGroup: String,
    val company: Company,
    val crypto: Crypto,
    val ein: String,
    val email: String,
    val eyeColor: String,
    val firstName: String,
    val gender: String,
    val hair: Hair,
    val height: Double,
    val id: Int,
    val image: String,
    val ip: String,
    val lastName: String,
    val macAddress: String,
    val maidenName: String,
    val password: String,
    val phone: String,
    val role: String,
    val ssn: String,
    val university: String,
    val userAgent: String,
    val username: String,
    val weight: Double
)

fun usuarioDTO.toUsuario(): Usuario {
    return Usuario(
        firstName = this.firstName,
        lastName = this.lastName,
        address = this.address,
        age = this.age,
        email = this.email,
        password = this.password,
        phone = this.phone,
        image = this.image
    )
}