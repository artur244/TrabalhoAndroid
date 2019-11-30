package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_gerenciar.*

class GerenciarActivity : AppCompatActivity() {

    private lateinit var livroViewModel: LivroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar)

        btnExcluir.setOnClickListener {
            livroViewModel.deleteAll()
        }

        btnEditar.setOnClickListener {
            val editar = Intent (this, EditarActivity::class.java)
            startActivity(editar)
        }
    }


}
