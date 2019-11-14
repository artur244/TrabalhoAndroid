package com.example.myapplication

import androidx.lifecycle.LiveData

class LivroRepository(private val livroDAO: LivroDAO) {
    fun insert(livro: Livro){
        LivroDAO.insert(livro)
    }

    fun update(livro: Livro){
        LivroDAO.update(livro)
    }

    fun delete(livro: Livro) =
        LivroDAO.delete(livro)


    val livros: LiveData<List<Livro>> = LivroDAO.getAll()
}