package com.fdananda.kotlincrudsqlitedao

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null

    var editTextAtributo1: EditText? = null
    var editTextAtributo2:EditText? = null
    var editTextAtributo3:EditText? = null
    var textViewEditar: TextView? = null
    var textViewExcluir:TextView? = null
    var buttonGravarEdicao: Button? = null
    var buttonGravarInclusao:Button? = null
    var imageButtonCreate: ImageButton? = null
    var imageButtonRead:ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAtributo1 = findViewById(R.id.editTextAtributo1)
        editTextAtributo2 = findViewById(R.id.editTextAtributo2)
        editTextAtributo3 = findViewById(R.id.editTextAtributo3)

        imageButtonCreate = findViewById(R.id.imageButtonSalvar)
        imageButtonRead   = findViewById(R.id.imageButtonListar)

        textViewEditar          = findViewById(R.id.textViewEditar)
        textViewExcluir          = findViewById(R.id.textViewExcluir)
        buttonGravarEdicao      = findViewById(R.id.buttonEditar)
        buttonGravarInclusao      = findViewById(R.id.buttonGravar)

        buttonGravarInclusao!!.setVisibility(View.GONE)
        buttonGravarEdicao!!.setVisibility(View.GONE)
        textViewEditar!!.setVisibility(View.GONE)
        textViewExcluir!!.setVisibility(View.GONE)
        editTextAtributo1!!.setVisibility(View.GONE)
        editTextAtributo2!!.setVisibility(View.GONE)
        editTextAtributo3!!.setVisibility(View.GONE)
    }

    private fun listar(): ArrayList<Atributo?>? {

        val atributoDAO = AtributoDAO(applicationContext)
        var listaAtributos: MutableList<Atributo>? = ArrayList()
        listaAtributos!!.clear()
        listaAtributos = atributoDAO.read() as MutableList<Atributo>?
        return listaAtributos as ArrayList<Atributo?>?
    }

    fun create(view: View?) {
        editTextAtributo1!!.setVisibility(View.VISIBLE)
        editTextAtributo2!!.setVisibility(View.VISIBLE)
        editTextAtributo3!!.setVisibility(View.VISIBLE)
        buttonGravarInclusao!!.setVisibility(View.VISIBLE)
        textViewEditar!!.setVisibility(View.GONE)
        textViewExcluir!!.setVisibility(View.GONE)
        buttonGravarEdicao!!.setVisibility(View.GONE)
        listView = findViewById(R.id.listViewAtributos)
        val atributoDAO = AtributoDAO(applicationContext)
        val atributos = listar()
        val adapter: ArrayAdapter<*> = AdapterCustomizado(this, atributos)
        listView!!.setAdapter(adapter)
        editTextAtributo1!!.setText("")
        editTextAtributo2!!.setText("")
        editTextAtributo3!!.setText("")
        try {
            buttonGravarInclusao!!.setOnClickListener {
                val atributo1: String
                val atributo2: String
                val atributo3: String
                atributo1 = editTextAtributo1!!.getText().toString()
                atributo2 = editTextAtributo2!!.getText().toString()
                atributo3 = editTextAtributo3!!.getText().toString()
                if (atributo1.isEmpty() || atributo1 === "") {
                    Toast.makeText(
                        applicationContext,
                        "Preencha um Texto válido!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (atributo2.isEmpty() || atributo1 === "") {
                        Toast.makeText(
                            applicationContext,
                            "Preencha um Texto válido!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (atributo3.isEmpty() || atributo1 === "") {
                            Toast.makeText(
                                applicationContext,
                                "Preencha um Texto válido!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val atributo = Atributo()
                            atributo.setAtributo1(atributo1)
                            atributo.setAtributo2(atributo2)
                            atributo.setAtributo3(atributo3)

                            //Inserir dados
                            atributoDAO.create(atributo)
                            Toast.makeText(
                                applicationContext,
                                "Dados salvos com sucesso!",
                                Toast.LENGTH_SHORT
                            ).show()
                            editTextAtributo1!!.setText("")
                            editTextAtributo2!!.setText("")
                            editTextAtributo3!!.setText("")
                            create(imageButtonCreate)
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
        listView!!.setOnItemClickListener { parent, view, position, id ->
            create(
                imageButtonCreate
            )
        }
    }

    fun read(view: View?) {
        listView = findViewById(R.id.listViewAtributos)
        val atributos = listar()
        val adapter: ArrayAdapter<*> = AdapterCustomizado(this, atributos)
        listView!!.setAdapter(adapter)
        editTextAtributo1!!.setText("")
        editTextAtributo2!!.setText("")
        editTextAtributo3!!.setText("")
        editTextAtributo1!!.setVisibility(View.GONE)
        editTextAtributo2!!.setVisibility(View.GONE)
        editTextAtributo3!!.setVisibility(View.GONE)
        buttonGravarEdicao!!.setVisibility(View.GONE)
        buttonGravarInclusao!!.setVisibility(View.GONE)
        textViewEditar!!.setVisibility(View.GONE)
        textViewExcluir!!.setVisibility(View.GONE)
        listView!!.setOnItemClickListener{ parent, view, position, id ->
            read(
                imageButtonRead
            )
        }
    }

    fun update(view: View?) {
        textViewEditar!!.setVisibility(View.VISIBLE)
        textViewExcluir!!.setVisibility(View.GONE)
        editTextAtributo1!!.setVisibility(View.GONE)
        editTextAtributo2!!.setVisibility(View.GONE)
        editTextAtributo3!!.setVisibility(View.GONE)
        buttonGravarInclusao!!.setVisibility(View.GONE)
        listView = findViewById(R.id.listViewAtributos)
        val atributos = listar()
        val adapter: ArrayAdapter<*> = AdapterCustomizado(this, atributos)
        listView!!.setAdapter(adapter)
        editTextAtributo1!!.setText("")
        editTextAtributo2!!.setText("")
        editTextAtributo3!!.setText("")
        listView!!.setOnItemClickListener { parent, view, position, id ->
            editTextAtributo1!!.setVisibility(View.VISIBLE)
            editTextAtributo2!!.setVisibility(View.VISIBLE)
            editTextAtributo3!!.setVisibility(View.VISIBLE)
            buttonGravarEdicao!!.setVisibility(View.VISIBLE)
            textViewEditar!!.setVisibility(View.GONE)
            editTextAtributo1!!.setText(atributos!![position]!!.getAtributo1())
            editTextAtributo2!!.setText(atributos[position]!!.getAtributo2())
            editTextAtributo3!!.setText(atributos[position]!!.getAtributo3())
            buttonGravarEdicao!!.setOnClickListener {
                try {
                    val atributo1Alterado: String
                    val atributo2Alterado: String
                    val atributo3Alterado: String
                    atributo1Alterado = editTextAtributo1!!.getText().toString()
                    atributo2Alterado = editTextAtributo2!!.getText().toString()
                    atributo3Alterado = editTextAtributo3!!.getText().toString()
                    if (atributo1Alterado.isEmpty() || atributo1Alterado === "") {
                        Toast.makeText(
                            applicationContext,
                            "Preencha um Texto válido!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (atributo2Alterado.isEmpty() || atributo1Alterado === "") {
                            Toast.makeText(
                                applicationContext,
                                "Preencha um Texto válido!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (atributo3Alterado.isEmpty() || atributo1Alterado === "") {
                                Toast.makeText(
                                    applicationContext,
                                    "Preencha um Texto válido!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                val atributo = Atributo()
                                atributo.setId(atributos[position]!!.getId())
                                atributo.setAtributo1(atributo1Alterado)
                                atributo.setAtributo2(atributo2Alterado)
                                atributo.setAtributo3(atributo3Alterado)
                                val atributoDAO = AtributoDAO(applicationContext)
                                atributoDAO.update(atributo)
                                editTextAtributo1!!.setText("")
                                editTextAtributo2!!.setText("")
                                editTextAtributo3!!.setText("")
                                editTextAtributo1!!.setVisibility(View.GONE)
                                editTextAtributo2!!.setVisibility(View.GONE)
                                editTextAtributo3!!.setVisibility(View.GONE)
                                Toast.makeText(
                                    applicationContext,
                                    "Dados alterados com sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                buttonGravarEdicao!!.setVisibility(View.GONE)
                                textViewEditar!!.setVisibility(View.VISIBLE)
                                update(imageButtonRead)
                            }
                        }
                    }
                } catch (e: Exception) {
                }
            }
        }
        editTextAtributo1!!.setText("")
        editTextAtributo2!!.setText("")
        editTextAtributo3!!.setText("")
    }

    fun delete(view: View?) {
        textViewEditar!!.setVisibility(View.GONE)
        editTextAtributo1!!.setVisibility(View.GONE)
        editTextAtributo2!!.setVisibility(View.GONE)
        editTextAtributo3!!.setVisibility(View.GONE)
        textViewExcluir!!.setVisibility(View.VISIBLE)
        buttonGravarEdicao!!.setVisibility(View.GONE)
        buttonGravarInclusao!!.setVisibility(View.GONE)
        listView = findViewById(R.id.listViewAtributos)
        val atributos = listar()
        val adapter: ArrayAdapter<*> = AdapterCustomizado(this, atributos)
        listView!!.setAdapter(adapter)
        listView!!.setOnItemClickListener{ parent, view, position, id ->
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(parent.context)
            alertDialog.setCancelable(true)
            alertDialog.setIcon(android.R.drawable.ic_menu_delete)
            alertDialog.setTitle("Excluir dados")
            alertDialog.setMessage(
                """
                Ao confirmar, os atributos a seguir serão excluídos: 
                ${atributos!![position]!!.getAtributo1()}
                ${atributos[position]!!.getAtributo2()}
                ${atributos[position]!!.getAtributo3()}
                
                Deseja continuar?
                """.trimIndent()
            )
            alertDialog.setPositiveButton("SIM",
                DialogInterface.OnClickListener { dialog, which ->
                    try {
                        val atributo = Atributo()
                        atributo.setId(atributos[position]!!.getId())
                        val atributoDAO = AtributoDAO(applicationContext)
                        atributoDAO.delete(atributo)
                        editTextAtributo1!!.setText("")
                        editTextAtributo2!!.setText("")
                        editTextAtributo3!!.setText("")
                        Toast.makeText(
                            applicationContext,
                            "Dados excluídos com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        delete(imageButtonRead)
                    } catch (e: Exception) {
                    }
                })
            alertDialog.setNegativeButton("NÃO",
                DialogInterface.OnClickListener { dialog, which -> })
            alertDialog.create()
            alertDialog.show()
        }
    }
}
