package com.fdananda.kotlinalertdialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirAlertDialog(view: View?) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setCancelable(true)
        alertDialog.setIcon(android.R.drawable.btn_star_big_on)
        alertDialog.setTitle("Título do Alert Dialog")
        alertDialog.setMessage("Mensagem do Alert Dialog")
        alertDialog.setPositiveButton("SIM",
            DialogInterface.OnClickListener { dialog, which ->
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.toast_sim, null)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.duration = Toast.LENGTH_LONG
                toast.setView(layout)
                toast.show()
            })
        alertDialog.setNegativeButton("NÃO",
            DialogInterface.OnClickListener { dialog, which ->
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.toast_nao, null)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.duration = Toast.LENGTH_LONG
                toast.setView(layout)
                toast.show()
            })
        alertDialog.create()
        alertDialog.show()
    }

    fun abrirAlertDialogPersonalizado(view: View?) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        alertDialog.setView(inflater.inflate(R.layout.alert_dialog_personalizado, null))
        alertDialog.setPositiveButton("SIM",
            DialogInterface.OnClickListener { dialog, which ->
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.toast_sim, null)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.duration = Toast.LENGTH_LONG
                toast.setView(layout)
                toast.show()
            })
        alertDialog.setNegativeButton("NÃO",
            DialogInterface.OnClickListener { dialog, which ->
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.toast_nao, null)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.duration = Toast.LENGTH_LONG
                toast.setView(layout)
                toast.show()
            })
        alertDialog.create()
        alertDialog.show()
    }

    fun openGenericDialog(view: View?) {
        val dialogGeneric: DialogGeneric?
        dialogGeneric = DialogGeneric()
        dialogGeneric.openDialog(
            this, resources.getDrawable(R.drawable.ic_generic),
            "Título do Alerta",
            "Texto que irá aparecer como mensagem do alerta. Pode ser multilinhas. " +
                    "O ideal é que não seja muito grande. Entendeu?!",
            "Claro :-)",
            MainActivity::class.java,
            "Xii... :-(",
            MainActivity::class.java,
            "Talvez",
            resources.getColor(android.R.color.black)
        )
    }
}
