package com.fdananda.kotlincardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val listaCardview: MutableList<Cardview> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.fdananda.kotlincardview.R.layout.activity_main)

        var recyclerView: RecyclerView? = null
        recyclerView = findViewById(com.fdananda.kotlincardview.R.id.recyclerView)

        //Passo 1 - Criação de um arquivo xml com o layout personalizado a ser utilizado.
        //          No nosso exemplo, arquivo com o nome adapter.xml dentro do package layout
        //          O componente Cardview é incluído dentro desse layout que é criado

        //Passo 2 -  Criação um model com a Class que será utilizada.
        //          No nosso exemplo, arquivo com o nome Cardview.java

        //Passo 3 - Criar a listagem de cardview

        //Passo 1 - Criação de um arquivo xml com o layout personalizado a ser utilizado.
        //          No nosso exemplo, arquivo com o nome adapter.xml dentro do package layout
        //          O componente Cardview é incluído dentro desse layout que é criado

        //Passo 2 -  Criação um model com a Class que será utilizada.
        //          No nosso exemplo, arquivo com o nome Cardview.java

        //Passo 3 - Criar a listagem de cardview
        criarCardview()

        //Passo 4 - Definição do adapter
        // - Cria uma class adapter, instancia e em seguida define

        //Passo 4 - Definição do adapter
        // - Cria uma class adapter, instancia e em seguida define
        val adapter = Adapter(listaCardview)


        //Passo 5 - Configuração do layout
        //Primeiro modelo com RecyclerView.LayoutManager e orientação vertical
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //Segundo modelo com LinearLayoutManager e orientação horizontal
        //LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        //layoutManager2.setOrientation(LinearLayout.HORIZONTAL);

        //Terceiro modelo com RecyclerView.LayoutManager do tipo Grid e com 2 colunas


        //Passo 5 - Configuração do layout
        //Primeiro modelo com RecyclerView.LayoutManager e orientação vertical
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //Segundo modelo com LinearLayoutManager e orientação horizontal
        //LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        //layoutManager2.setOrientation(LinearLayout.HORIZONTAL);

        //Terceiro modelo com RecyclerView.LayoutManager do tipo Grid e com 2 colunas
        val layoutManager3: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView.setLayoutManager(layoutManager3)
        recyclerView.setHasFixedSize(true)

        recyclerView.setAdapter(adapter)
    }

    fun criarCardview() {
        var cardview = Cardview("Título 1", "Descrição 1", "Autor 1", com.fdananda.kotlincardview.R.drawable.foto1)
        listaCardview.add(cardview)
        cardview = Cardview("Título 2", "Descrição 2", "Autor 2", com.fdananda.kotlincardview.R.drawable.foto2)
        listaCardview.add(cardview)
        cardview = Cardview("Título 3", "Descrição 3", "Autor 3", com.fdananda.kotlincardview.R.drawable.foto3)
        listaCardview.add(cardview)
        cardview = Cardview("Título 4", "Descrição 4", "Autor 4", com.fdananda.kotlincardview.R.drawable.foto4)
        listaCardview.add(cardview)
        cardview = Cardview("Título 5", "Descrição 5", "Autor 5", com.fdananda.kotlincardview.R.drawable.foto5)
        listaCardview.add(cardview)
        cardview = Cardview("Título 6", "Descrição 6", "Autor 6", com.fdananda.kotlincardview.R.drawable.foto6)
        listaCardview.add(cardview)
    }
}
