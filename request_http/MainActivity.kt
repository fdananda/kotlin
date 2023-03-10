package com.fdananda.kotlinrequesthttp

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResponse: TextView
    private lateinit var textoFormatado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResponse = findViewById(R.id.textViewResponse)
        textoFormatado = ""
    }

    fun requestHTTP(view: View?) {
        val url = "https://www.soccerincanada.ca/wp-json/wp/v2/posts/1822"
        val myAsyncTask = MyAsyncTask(textoFormatado, textViewResponse)
        myAsyncTask.execute(url)
    }

    //<Parâmetro de entrada, Progresso, Retorno>
    class MyAsyncTask (textoformatado: String, textViewResponse: TextView): AsyncTask<String?, Void?, String>() {

        private var textoFormatado = textoformatado
        private var textViewResponse = textViewResponse


        override fun doInBackground(vararg strings: String?): String {
            val urlRecebida = strings[0]
            val inputStream: InputStream?
            val inputStreamReader: InputStreamReader?
            val bufferedReader: BufferedReader?
            var stringBuffer: StringBuffer? = null
            try {
                val urlApi = URL(urlRecebida)

                //Conectar
                val httpURLConnection: HttpURLConnection =
                    urlApi.openConnection() as HttpURLConnection
                Log.i(
                    "RESPONSE",
                    "Código Retorno da conexão: " + httpURLConnection.getResponseCode()
                )

                //Retorno em bytes
                inputStream = httpURLConnection.getInputStream()

                //Conversão de bytes para caracteres
                inputStreamReader = InputStreamReader(inputStream)

                //Conversão de caracteres para String
                bufferedReader = BufferedReader(inputStreamReader)

                //Leitura linha a linha
                var linhaBuffered: String? = ""
                stringBuffer = StringBuffer()
                while (bufferedReader.readLine().also { linhaBuffered = it } != null) {
                    stringBuffer.append(linhaBuffered)
                }
            } catch (e: MalformedURLException) {
                e.printStackTrace()
                textoFormatado = "Erro: " + e.message
            } catch (e: IOException) {
                e.printStackTrace()
                textoFormatado = "Erro: " + e.message
            }
            return stringBuffer?.toString() ?: textoFormatado
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            val id: Int
            val objetoTitulo: String
            val titulo: String
            val data: String
            val link: String
            val objetoTexto: String
            val texto: String
            try {
                val jsonObject = JSONObject(s)
                textoFormatado = s
                id = jsonObject.getInt("id")
                data = jsonObject.getString("date")
                link = jsonObject.getString("link")
                objetoTitulo = jsonObject.getString("title")
                val jsonObjectTitulo = JSONObject(objetoTitulo)
                titulo = jsonObjectTitulo.getString("rendered")
                objetoTexto = jsonObject.getString("content")
                val jsonObjectTexto = JSONObject(objetoTexto)
                texto = jsonObjectTexto.getString("rendered")
                    .replace("<p>|<strong>|</p>|</strong>".toRegex(), "")
                textoFormatado = """
                ID: $id
                
                Título: $titulo
                
                Data: $data
                
                Link: $link
                
                Texto: $texto
                """.trimIndent()
            } catch (e: JSONException) {
                e.printStackTrace()
                textoFormatado = "Erro: " + e.message
            }
            textViewResponse.setText(textoFormatado)
        }
    }
}
