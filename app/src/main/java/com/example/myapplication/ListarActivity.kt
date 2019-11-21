package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_listar.*


class ListarActivity : AppCompatActivity() {

    private lateinit var livroViewModel: LivroViewModel
    val REQUEST_CODE = 12

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        recyclerView = recycler_livros

        montaLista(recyclerView)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if(requestCode == REQUEST_CODE &&
            resultCode == Activity.RESULT_OK){
            data?.let { resultado ->
                try{


                    val livro: Livro = resultado.extras?.
                        get(CadastrarActivity.EXTRA_REPLY) as Livro

                    livro.let {
                        livroViewModel.insert(livro)
                    }
                } catch (e: Exception){
                    Log.d("TAG: ", e.message)
                }
            }
        }
    }

    fun montaLista(recyclerView: RecyclerView){

        val adapter = ListarLivroAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        livroViewModel = ViewModelProviders.of(this).
            get(LivroViewModel::class.java)


        livroViewModel.livros.observe(this,
            Observer { livroLista ->
                livroLista?.let { lista ->
                    adapter.setLivroLista(lista)
                }
            })
    }

    override fun onRestart() {
        super.onRestart()

        montaLista(recyclerView)

    }
}
