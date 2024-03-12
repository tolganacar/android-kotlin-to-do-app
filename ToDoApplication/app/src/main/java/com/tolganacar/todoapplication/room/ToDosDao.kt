package com.tolganacar.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tolganacar.todoapplication.data.entity.ToDos

@Dao
interface ToDosDao {
    @Query("SELECT * FROM toDos")
    suspend fun toDosLoad() : List<ToDos>

    @Insert
    suspend fun create(toDos: ToDos)

    @Update
    suspend fun update(toDos: ToDos)

    @Delete
    suspend fun delete(toDos: ToDos)

    @Query("SELECT * FROM toDos WHERE name like '%' || :search || '%'")
    suspend fun search(search: String) : List<ToDos>
}