package com.fdananda.kotlinintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editTextTelefone: EditText? = null
    private var editTextEmail: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTelefone = findViewById(R.id.editTextTelefone)
        editTextEmail = findViewById(R.id.editTextEmail)
    }

    fun enviarEmail(view: View?) {
        val email = editTextEmail!!.text.toString()
        if (email.isEmpty() || email === "" || !email.contains("@")) {
            Toast.makeText(this, "Preencha um e-mail válido!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Título do e-mail")
            intent.putExtra(Intent.EXTRA_TEXT, "Corpo do e-mail.")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Enviar e-mail"))
        }
    }

    fun fazerLigacao(view: View?) {
        val numeroTelefone = editTextTelefone!!.text.toString()
        if (numeroTelefone.isEmpty() || numeroTelefone === "") {
            Toast.makeText(this, "Preencha um telefone válido!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numeroTelefone"))
            startActivity(intent)
        }
    }

    fun abrirImagem(view: View?) {
        val imagem =
            "https://2.bp.blogspot.com/-jdPrk5R6adk/W5VMs0mXsyI/AAAAAAABuOo/EAumZucrKew5ahNBwUFX8CCqWCzz3MvdACLcBGAs/s640/20180410_scooby005.jpg"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imagem))
        startActivity(intent)
    }

    fun abrirGoogleMaps(view: View?) {
        val endereco = "https://goo.gl/maps/GpB5mQa42LGNBTBt6"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(endereco))
        startActivity(intent)
    }

    fun abrirSite(view: View?) {
        val endereco = "https://github.com/fdananda"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(endereco))
        startActivity(intent)
    }
}
