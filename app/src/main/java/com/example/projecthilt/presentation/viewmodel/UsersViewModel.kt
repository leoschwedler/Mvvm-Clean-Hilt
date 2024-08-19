package com.example.projecthilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecthilt.domain.model.Usuario
import com.example.projecthilt.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase) :
    ViewModel() {

    private val _users = MutableLiveData<List<Usuario>>()

    val users: LiveData<List<Usuario>>
        get() = _users

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            val listUsers = getUsersUseCase.invoke()
            _users.postValue(listUsers)
        }
    }


}