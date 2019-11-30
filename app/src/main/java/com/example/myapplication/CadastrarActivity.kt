package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastrar.*

class CadastrarActivity : AppCompatActivity() {

    lateinit var livro: Livro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)


    }

    fun save(view: View){
        if(etTitulo.text.isNullOrEmpty())
            Toast.makeText(
                this,
                "O titulo do livro não pode ser vazio",
                Toast.LENGTH_LONG
            ).show()
        else if(etDesc.text.isNullOrEmpty())
            Toast.makeText(
                this,
                "A descrição do livro não pode ser vazia",
                Toast.LENGTH_LONG
            ).show()
        else if(etPreco.text.isNullOrEmpty())
            Toast.makeText(
                this,
                "O preço do livro não pode ser vazio",
                Toast.LENGTH_LONG
            ).show()
        else{
            livro = Livro()
            popObj()

            var intent = Intent()

            intent.putExtra(EXTRA_REPLY, livro)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }


    private fun popObj(){
        livro.titulo = etTitulo.text.toString()
        livro.descricao = etDesc.text.toString()
        livro.preco = etPreco.text.toString()
    }


    companion object {
        const val EXTRA_REPLY = "com.example.myapplication.REPLY"
    }
}
