package com.fdananda.kotlincrudsharedpreferencescomobjeto

import android.content.Context
import android.content.SharedPreferences

class CrudPreferencias() {

    private var context: Context? = null
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private val NOMEDOARQUIVO = "Arquivo_CRUD_SharedPreferences"
    private val ATRIBUTO1 = "atributo1"
    private val ATRIBUTO2 = "atributo2"
    private val ATRIBUTO3 = "atributo3"
    private var atributo: Atributo? = null


    constructor(context: Context) : this() {
        this.context = context
        sharedPreferences = context.getSharedPreferences(NOMEDOARQUIVO, 0)
        editor = sharedPreferences!!.edit()
    }

    fun create(atributo1: String?, atributo2: String?, atributo3: String?) {
        editor!!.putString(ATRIBUTO1, atributo1)
        editor!!.putString(ATRIBUTO2, atributo2)
        editor!!.putString(ATRIBUTO3, atributo3)
        editor!!.commit()
    }

    fun read(): Atributo? {
        atributo = Atributo()
        val atributo1: String? = sharedPreferences!!.getString(ATRIBUTO1, "")
        val atributo2: String? = sharedPreferences!!.getString(ATRIBUTO2, "")
        val atributo3: String? = sharedPreferences!!.getString(ATRIBUTO3, "")
        atributo!!.setAtributo1(atributo1)
        atributo!!.setAtributo2(atributo2)
        atributo!!.setAtributo3(atributo3)
        return atributo
    }

    fun update(atributo1: String?, atributo2: String?, atributo3: String?) {
        editor!!.putString(ATRIBUTO1, atributo1)
        editor!!.putString(ATRIBUTO2, atributo2)
        editor!!.putString(ATRIBUTO3, atributo3)
        editor!!.commit()
    }

    fun delete() {
        editor!!.putString(ATRIBUTO1, "")
        editor!!.putString(ATRIBUTO2, "")
        editor!!.putString(ATRIBUTO3, "")
        editor!!.commit()
    }
}
