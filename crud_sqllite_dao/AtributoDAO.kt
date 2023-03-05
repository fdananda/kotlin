package com.fdananda.kotlincrudsqlitedao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AtributoDAO(context: Context?) : IAtributoDAO {
    private val writeDB: SQLiteDatabase
    private val readDB: SQLiteDatabase
    override fun create(atributo: Atributo?): Boolean {
        val cv = ContentValues()
        cv.put("atributo1", atributo!!.getAtributo1())
        cv.put("atributo2", atributo.getAtributo2())
        cv.put("atributo3", atributo.getAtributo3())
        try {
            writeDB.insert(BancoDadosManipulacao.NOME_TABELA, null, cv)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun update(atributo: Atributo?): Boolean {
        val cv = ContentValues()
        cv.put("atributo1", atributo!!.getAtributo1().toString())
        cv.put("atributo2", atributo.getAtributo2().toString())
        cv.put("atributo3", atributo.getAtributo3().toString())
        try {
            val clauseWhere = "id=?"
            val whereArgs = arrayOf<String>(java.lang.String.valueOf(atributo.getId()))
            writeDB.update(BancoDadosManipulacao.NOME_TABELA, cv, clauseWhere, whereArgs)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun delete(atributo: Atributo?): Boolean {
        try {
            val clauseWhere = "id=?"
            val whereArgs = arrayOf<String>(java.lang.String.valueOf(atributo!!.getId()))
            writeDB.delete(BancoDadosManipulacao.NOME_TABELA, clauseWhere, whereArgs)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun read(): List<Atributo?>? {
        val atributos: MutableList<Atributo?> = ArrayList()
        val consultaListar = "SELECT * from " + BancoDadosManipulacao.NOME_TABELA + ""
        val cursor: Cursor = readDB.rawQuery(consultaListar, null)
        while (cursor.moveToNext()) {
            val indiceId: Int = cursor.getColumnIndex("id")
            val indiceAtributo1: Int = cursor.getColumnIndex("atributo1")
            val indiceAtributo2: Int = cursor.getColumnIndex("atributo2")
            val indiceAtributo3: Int = cursor.getColumnIndex("atributo3")
            val id: Int = cursor.getInt(indiceId)
            val atributo1: String = cursor.getString(indiceAtributo1)
            val atributo2: String = cursor.getString(indiceAtributo2)
            val atributo3: String = cursor.getString(indiceAtributo3)
            val atributoIndividual = Atributo()
            atributoIndividual.setId(id)
            atributoIndividual.setAtributo1(atributo1)
            atributoIndividual.setAtributo2(atributo2)
            atributoIndividual.setAtributo3(atributo3)
            atributos.add(atributoIndividual)
        }
        return atributos
    }

    init {
        val bd = BancoDadosManipulacao(context)
        writeDB = bd.writableDatabase
        readDB = bd.readableDatabase
    }
}
