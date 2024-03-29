package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGerenciar.setOnClickListener {
            val gerenciar = Intent(this,GerenciarActivity::class.java)
            startActivity(gerenciar)
        }

        btnListar.setOnClickListener {
            val listar = Intent(this,ListarActivity::class.java)
            startActivity(listar)
        }

    }
}
