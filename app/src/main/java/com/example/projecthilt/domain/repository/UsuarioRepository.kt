package com.example.projecthilt.domain.repository

import com.example.projecthilt.domain.model.Usuario

interface UsuarioRepository {
    suspend fun getUsers() : List<Usuario>
}