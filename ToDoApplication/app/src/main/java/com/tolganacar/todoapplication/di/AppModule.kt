package com.tolganacar.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.tolganacar.todoapplication.data.datasource.ToDosDataSource
import com.tolganacar.todoapplication.data.repo.ToDosRepository
import com.tolganacar.todoapplication.room.ToDoDatabase
import com.tolganacar.todoapplication.room.ToDosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDosRepository(dataSource: ToDosDataSource): ToDosRepository {
        return ToDosRepository(dataSource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(dao: ToDosDao): ToDosDataSource {
        return ToDosDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context): ToDosDao {
        val database = Room.databaseBuilder(context, ToDoDatabase::class.java, "toDos.sqlite")
            .createFromAsset("toDos.sqlite").build()
        return database.getToDosDao()
    }
}