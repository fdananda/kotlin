package com.fdananda.kotlinlistviewcustomizado

class Objeto {
    private var atributo1: String? = null
    private var atributo2: String? = null

    constructor() {}
    constructor(atributo1: String?, atributo2: String?) {
        this.atributo1 = atributo1
        this.atributo2 = atributo2
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
}
