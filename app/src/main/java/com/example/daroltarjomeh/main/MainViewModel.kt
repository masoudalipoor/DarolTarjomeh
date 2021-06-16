package com.example.daroltarjomeh.main

import androidx.lifecycle.*
import com.example.daroltarjomeh.db.entity.UserEntity
import com.example.daroltarjomeh.db.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class MainViewModel(private val repository: UserRepository) : ViewModel() {

    val user: LiveData<UserEntity> = repository.user.asLiveData()

    fun insert(userEntity: UserEntity) = viewModelScope.launch {
        supervisorScope { repository.insert(userEntity) }
    }
}

class MainViewModelFactory(private var repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}