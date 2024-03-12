package com.tolganacar.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.tolganacar.todoapplication.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoCreateViewModel @Inject constructor(var repo: ToDosRepository) : ViewModel()  {

    fun create(name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            repo.create(name)
        }
    }
}