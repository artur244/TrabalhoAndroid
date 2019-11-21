package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LivroDAO {

    @Insert
    fun insert(livro: Livro)

    @Update
    fun update(livro: Livro)

    @Delete
    fun delete(livro: Livro)

    @Query("SELECT * FROM livro_tb ORDER BY titulo ASC")
    fun getAll(): LiveData<List<Livro>>

}