package com.example.myapplication

import com.example.myapplication.Livro
import com.example.myapplication.LivroDAO

import androidx.lifecycle.LiveData

class LivroRepository(private val livroDAO: LivroDAO) {
    fun insert(livro: Livro){
        livroDAO.insert(livro)
    }

    fun update(livro: Livro){
        livroDAO.update(livro)
    }

    fun delete(livro: Livro) =
        livroDAO.delete(livro)

    fun deleteAll() = livroDAO.deleteAll()

    val livros: LiveData<List<Livro>> = livroDAO.getAll()
}