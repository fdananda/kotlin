package com.fdananda.kotlincardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(cardviews: List<Cardview>) :
    RecyclerView.Adapter<Adapter.MinhaViewHolder>() {
    private val listCardview: List<Cardview>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinhaViewHolder {

        //Criação da visualização
        val itemCardview: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter, parent, false)
        return MinhaViewHolder(itemCardview)
    }

    override fun onBindViewHolder(holder: MinhaViewHolder, position: Int) {
        val cardview: Cardview = listCardview[position]
        holder.textTitulo.setText(cardview.getTitulo())
        holder.textAutor.setText(cardview.getAutor())
        holder.textDescricao.setText(cardview.getDescricao())
        holder.imagem.setImageResource(cardview.getImagem())
    }

    override fun getItemCount(): Int {
        return listCardview.size
    }

    inner class MinhaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitulo: TextView
        val textDescricao: TextView
        val textAutor: TextView
        val imagem: ImageView

        init {
            textTitulo = itemView.findViewById(R.id.textViewTitulo)
            textDescricao = itemView.findViewById(R.id.textViewDescricao)
            textAutor = itemView.findViewById(R.id.textViewAutor)
            imagem = itemView.findViewById(R.id.imageViewImagem)
        }
    }

    init {
        listCardview = cardviews
    }
}
