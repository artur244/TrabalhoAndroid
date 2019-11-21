package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class ListarLivroAdapter
internal constructor(context: Context) :
    RecyclerView.Adapter<ListarLivroAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)



    private var itens = emptyList<Livro>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(
            R.layout.item_lista,
            parent,
            false
        )
        return ViewHolder(view)

    }


    override fun getItemCount(): Int = itens.count()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.itemTitulo.text = item.titulo
        holder.itemPreco.text = item.preco
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val itemTitulo: TextView = itemView.itemTitulo
        val itemPreco: TextView = itemView.itemPreco
    }

    fun setLivroLista(livros: List<Livro>) {
        this.itens = livros
        notifyDataSetChanged()
    }

}
