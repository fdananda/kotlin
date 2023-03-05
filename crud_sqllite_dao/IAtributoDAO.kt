package com.fdananda.kotlincrudsqlitedao

interface IAtributoDAO {
    fun create(atributo: Atributo?): Boolean
    fun update(atributo: Atributo?): Boolean
    fun delete(atributo: Atributo?): Boolean
    fun read(): List<Atributo?>?
}
