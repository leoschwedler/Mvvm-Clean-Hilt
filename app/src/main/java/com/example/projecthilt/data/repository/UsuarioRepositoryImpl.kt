package com.example.projecthilt.data.repository

import com.example.projecthilt.data.dto.toUsuario
import com.example.projecthilt.data.remote.DummyAPI
import com.example.projecthilt.domain.model.Usuario
import com.example.projecthilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(val dummyAPI: DummyAPI) : UsuarioRepository {
    override suspend fun getUsers(): List<Usuario> {
        try {
            val response =  dummyAPI.getUsers()
            if (response.isSuccessful && response != null){
                val responseAPIDTO = response.body()
                val listaUsers = responseAPIDTO?.usuarioDTOS
                if (listaUsers != null){
                   return listaUsers.map {
                       it.toUsuario()
                   }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
        return emptyList()
    }
}