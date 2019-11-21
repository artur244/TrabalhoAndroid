package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "livro_tb")
class Livro (
    @ColumnInfo(name = "titulo")
    var titulo: String = "",

    @ColumnInfo(name = "descricao")
    var descricao: String = "",

    @ColumnInfo(name = "preco")
    var preco: String = ""

): Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}