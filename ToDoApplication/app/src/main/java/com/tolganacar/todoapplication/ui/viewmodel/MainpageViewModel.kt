package com.tolganacar.todoapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tolganacar.todoapplication.data.entity.ToDos
import com.tolganacar.todoapplication.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var repo: ToDosRepository) : ViewModel() {
    var todoList = MutableLiveData<List<ToDos>>()

    init {
        toDosLoad()
    }

    fun delete(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            repo.delete(id)
            toDosLoad()
        }
    }

    fun toDosLoad() {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = repo.toDosLoad()
        }
    }

    fun search(search: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = repo.search(search)
        }
    }

}