package com.fdananda.kotlinnavegao

import java.io.Serializable

class Objeto(private var atributoObjetoTexto: String, private var atributoObjetoNumero: Int) : Serializable{

    private var atributoObjetoTexto2: String? = atributoObjetoTexto
    private var atributoObjetoNumero2 = atributoObjetoNumero

    fun getAtributoObjetoTexto(): String {
        return atributoObjetoTexto
    }

    fun setAtributoObjetoTexto(atributoObjetoTexto: String) {
        this.atributoObjetoTexto2 = atributoObjetoTexto
    }

    fun getAtributoObjetoNumero(): Int {
        return atributoObjetoNumero
    }

    fun setAtributoObjetoNumero(atributoObjetoNumero: Int) {
        this.atributoObjetoNumero2 = atributoObjetoNumero
    }
}
