package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class LivroViewModel(application: Application): AndroidViewModel(application) {

    private val repository: LivroRepository

    val livros: LiveData<List<Livro>>

    private val parentJob = Job()
    private val corountineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(corountineContext)

    init {
        val LivroDAO = HelperDatabase.getDatabase(application).livrodao()
        repository = LivroRepository(LivroDAO)

        livros = repository.livros
    }

    fun insert(livro: Livro) = scope.launch(Dispatchers.IO){
        repository.insert(livro)
    }

    fun update(livro: Livro) = scope.launch(Dispatchers.IO){
        repository.update(livro)
    }

    fun delete(livro: Livro) = scope.launch(Dispatchers.IO){
        repository.delete(livro)
    }

    fun deleteAll() = scope.launch(Dispatchers.IO){
        repository.deleteAll()
    }
}