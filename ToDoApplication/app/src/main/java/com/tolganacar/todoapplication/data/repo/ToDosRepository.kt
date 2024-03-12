package com.tolganacar.todoapplication.data.repo

import com.tolganacar.todoapplication.data.datasource.ToDosDataSource
import com.tolganacar.todoapplication.data.entity.ToDos

class ToDosRepository(var dataSource: ToDosDataSource) {

    suspend fun create(name: String) = dataSource.create(name)

    suspend fun update(id: Int, name:String) = dataSource.update(id, name)

    suspend fun delete(id: Int) = dataSource.delete(id)

    suspend fun toDosLoad(): List<ToDos> = dataSource.toDosLoad()

    suspend fun search(search: String) : List<ToDos> = dataSource.search(search)

}