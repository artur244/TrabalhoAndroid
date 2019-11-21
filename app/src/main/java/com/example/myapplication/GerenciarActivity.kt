package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_gerenciar.*

class GerenciarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar)

        btnCadastrar.setOnClickListener {
            val cadastrar = Intent(this, CadastrarActivity::class.java)
            startActivity(cadastrar)
        }

        btnEditar.setOnClickListener {
            val editar = Intent (this, EditarActivity::class.java)
            startActivity(editar)
        }
    }


}
