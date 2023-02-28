package com.fdananda.kotlincardview

class Cardview {
    private var titulo: String? = null
    private var descricao: String? = null
    private var autor: String? = null
    private var imagem = 0

    constructor() {}
    constructor(titulo: String?, descricao: String?, autor: String?, imagem: Int) {
        this.titulo = titulo
        this.descricao = descricao
        this.autor = autor
        this.imagem = imagem
    }

    fun getTitulo(): String? {
        return titulo
    }

    fun setTitulo(titulo: String?) {
        this.titulo = titulo
    }

    fun getDescricao(): String? {
        return descricao
    }

    fun setDescricao(descricao: String?) {
        this.descricao = descricao
    }

    fun getAutor(): String? {
        return autor
    }

    fun setAutor(autor: String?) {
        this.autor = autor
    }

    fun getImagem(): Int {
        return imagem
    }

    fun setImagem(imagem: Int) {
        this.imagem = imagem
    }
}
