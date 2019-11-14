package com.example.myapplication

@Dao
interface LivroDAO {

    @Insert
    fun insert(livro: Livro)

    @Update
    fun update(livro: Livro)

    @Delete
    fun delete(livro: Livro)

}