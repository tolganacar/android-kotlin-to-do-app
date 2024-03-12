package com.tolganacar.todoapplication.data.datasource

import com.tolganacar.todoapplication.data.entity.ToDos
import com.tolganacar.todoapplication.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var dao: ToDosDao) {
    suspend fun create(name: String) {
        val newToDo = ToDos(0, name)
        dao.create(newToDo)
    }

    suspend fun update(id: Int, name: String) {
        val updatedTodo = ToDos(id, name)
        dao.update(updatedTodo)
    }

    suspend fun delete(id: Int) {
        val deletedTodo = ToDos(id, "")
        dao.delete(deletedTodo)
    }

    suspend fun toDosLoad(): List<ToDos> =
        withContext(Dispatchers.IO) {
            return@withContext dao.toDosLoad()
        }

    suspend fun search(search: String) : List<ToDos> =
        withContext(Dispatchers.IO) {
            return@withContext dao.search(search)
        }
}