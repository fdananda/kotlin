package com.fdananda.kotlincrudsqlite

class Atributo {

    private var atributo1: String? = null
    private var atributo2: String? = null
    private var atributo3: String? = null
    private var id = 0

    constructor(){}

    constructor(atributo1: String, atributo2: String, atributo3: String, id: Int)  {
        this.atributo1 = atributo1
        this.atributo2 = atributo2
        this.atributo3 = atributo3
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getAtributo1(): String? {
        return atributo1
    }

    fun setAtributo1(atributo1: String?) {
        this.atributo1 = atributo1
    }

    fun getAtributo2(): String? {
        return atributo2
    }

    fun setAtributo2(atributo2: String?) {
        this.atributo2 = atributo2
    }

    fun getAtributo3(): String? {
        return atributo3
    }

    fun setAtributo3(atributo3: String?) {
        this.atributo3 = atributo3
    }

}
