package com.example.myapplication



@Entity(tableName = "livro_tb")
class Livro {
    @ColumnInfo(name = "titulo")
    var titulo: String = "",

    @ColumnInfo(name = "descricao")
    var descricao: String = "",

    @ColumnInfo(name = "preco")
    var preco: Int = "",

}: Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}