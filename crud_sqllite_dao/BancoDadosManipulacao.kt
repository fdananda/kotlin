package com.fdananda.kotlincrudsqlitedao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.jetbrains.annotations.Nullable

class BancoDadosManipulacao(@Nullable context: Context?) :
    SQLiteOpenHelper(context, NOME_DO_BD, null, VERSION) {
    //Para a criação da primeira versão do BD
    override fun onCreate(db: SQLiteDatabase) {
        val comandoCriarTabelaSQL =
            "CREATE TABLE IF NOT EXISTS " + NOME_TABELA + " (id INTEGER PRIMARY KEY AUTOINCREMENT, atributo1 VARCHAR, atributo2 VARCHAR, atributo3 VARCHAR)"
        try {
            db.execSQL(comandoCriarTabelaSQL)
        } catch (e: Exception) {
        }
    }

    //Para a atualização da estrutura do BD
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    companion object {
        var VERSION = 1
        var NOME_DO_BD = "bd_CRUD_SQLite"
        var NOME_TABELA = "atributos"
    }
}
