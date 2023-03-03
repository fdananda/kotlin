package com.fdananda.crudsharedpreferences

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editTextAtributo1: EditText? = null
    private var editTextAtributo2:EditText? = null
    private var editTextAtributo3:EditText? = null
    private var textViewAtributo1: TextView? = null
    private var textViewAtributo2:TextView? = null
    private var textViewAtributo3:TextView? = null
    private var buttonGravarEdicao: Button? = null
    private val NOMEDOARQUIVO = "Arquivo_CRUD_SharedPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAtributo1 = findViewById(R.id.editTextAtributo1)
        editTextAtributo2 = findViewById(R.id.editTextAtributo2)
        editTextAtributo3 = findViewById(R.id.editTextAtributo3)

        textViewAtributo1 = findViewById(R.id.textViewAtributo1)
        textViewAtributo2 = findViewById(R.id.textViewAtributo2)
        textViewAtributo3 = findViewById(R.id.textViewAtributo3)

        buttonGravarEdicao      = findViewById(R.id.buttonEditar)
    }

    fun salvar(view: View?) {
        val sharedPreferences = getSharedPreferences(NOMEDOARQUIVO, 0)
        val editor = sharedPreferences.edit()
        val atributo1: String  = editTextAtributo1!!.text.toString()
        val atributo2: String = editTextAtributo2!!.text.toString()
        val atributo3: String = editTextAtributo3!!.text.toString()
        if (atributo1.isEmpty() || atributo1 === "") {
            Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
        } else {
            if (atributo2.isEmpty() || atributo1 === "") {
                Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
            } else {
                if (atributo3.isEmpty() || atributo1 === "") {
                    Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
                } else {
                    editor.putString("atributo1", atributo1)
                    editor.putString("atributo2", atributo2)
                    editor.putString("atributo3", atributo3)
                    editor.apply()
                    editTextAtributo1!!.setText("")
                    editTextAtributo2!!.setText("")
                    editTextAtributo3!!.setText("")
                    Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show()
                    buttonGravarEdicao!!.visibility = View.GONE
                    listar(view)
                }
            }
        }
    }

    fun listar(view: View?) {
        val sharedPreferences = getSharedPreferences(NOMEDOARQUIVO, 0)
        val atributo1: String? = sharedPreferences.getString("atributo1", "")
        val atributo2: String? = sharedPreferences.getString("atributo2", "")
        val atributo3: String? = sharedPreferences.getString("atributo3", "")
        textViewAtributo1!!.text = atributo1
        textViewAtributo2!!.text = atributo2
        textViewAtributo3!!.text = atributo3
        buttonGravarEdicao!!.visibility = View.GONE
    }

    fun editar(view: View?) {
        val sharedPreferences = getSharedPreferences(NOMEDOARQUIVO, 0)
        val atributo1: String? = sharedPreferences.getString("atributo1", "")
        val atributo2: String? = sharedPreferences.getString("atributo2", "")
        val atributo3: String? = sharedPreferences.getString("atributo3", "")
        editTextAtributo1!!.setText(atributo1)
        editTextAtributo2!!.setText(atributo2)
        editTextAtributo3!!.setText(atributo3)
        buttonGravarEdicao!!.visibility = View.VISIBLE
    }

    fun gravarEdicao(view: View?) {
        val sharedPreferences = getSharedPreferences(NOMEDOARQUIVO, 0)
        val editor = sharedPreferences.edit()
        val atributoalterado1: String = editTextAtributo1!!.text.toString()
        val atributoalterado2: String = editTextAtributo2!!.text.toString()
        val atributoalterado3: String = editTextAtributo3!!.text.toString()

        if (atributoalterado1.isEmpty() || atributoalterado1 === "") {
            Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
        } else {
            if (atributoalterado2.isEmpty() || atributoalterado2 === "") {
                Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
            } else {
                if (atributoalterado3.isEmpty() || atributoalterado3 === "") {
                    Toast.makeText(this, "Preencha um Texto válido!", Toast.LENGTH_SHORT).show()
                } else {
                    editor.putString("atributo1", atributoalterado1)
                    editor.putString("atributo2", atributoalterado2)
                    editor.putString("atributo3", atributoalterado3)
                    editor.apply()
                    editTextAtributo1!!.setText("")
                    editTextAtributo2!!.setText("")
                    editTextAtributo3!!.setText("")
                    Toast.makeText(this, "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show()
                    buttonGravarEdicao!!.visibility = View.GONE
                    listar(view)
                }
            }
        }
    }

    fun excluir(view: View?) {
        val sharedPreferences = getSharedPreferences(NOMEDOARQUIVO, 0)
        val editor = sharedPreferences.edit()
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setCancelable(true)
        alertDialog.setIcon(android.R.drawable.ic_menu_delete)
        alertDialog.setTitle("Excluir dados")
        alertDialog.setMessage("Ao confirmar todos os atributos serão excluídos. Deseja continuar?")
        alertDialog.setPositiveButton("SIM",
            DialogInterface.OnClickListener { _, _ ->
                editor.putString("atributo1", "")
                editor.putString("atributo2", "")
                editor.putString("atributo3", "")
                editor.apply()
                editTextAtributo1!!.setText("")
                editTextAtributo2!!.setText("")
                editTextAtributo3!!.setText("")
                Toast.makeText(
                    applicationContext,
                    "Dados excluídos com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                listar(view)
            })
        alertDialog.setNegativeButton("NÃO",
            DialogInterface.OnClickListener { _, _ -> })
        alertDialog.create()
        alertDialog.show()
    }
}
