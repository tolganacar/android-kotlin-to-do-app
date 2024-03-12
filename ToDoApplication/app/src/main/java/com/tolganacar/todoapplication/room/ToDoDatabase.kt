package com.tolganacar.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tolganacar.todoapplication.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun getToDosDao(): ToDosDao
}