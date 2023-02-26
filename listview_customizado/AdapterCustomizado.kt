package com.fdananda.kotlinlistviewcustomizado

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class AdapterCustomizado(context: Context, objetos: ArrayList<Objeto>) :
    ArrayAdapter<Objeto?>(context, com.fdananda.kotlinlistviewcustomizado.R.layout.adapter,
        objetos as List<Objeto?>
    ) {
    private val objetos: ArrayList<Objeto>

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewPersonalizada: View = inflater.inflate(com.fdananda.kotlinlistviewcustomizado.R.layout.adapter, parent, false)
        val atributo1 = viewPersonalizada.findViewById<View>(com.fdananda.kotlinlistviewcustomizado.R.id.TextViewAtributo1) as TextView
        val atributo2 = viewPersonalizada.findViewById<View>(com.fdananda.kotlinlistviewcustomizado.R.id.TextViewDescricao) as TextView
        atributo1.text = objetos[position].getAtributo1()
        atributo2.text = objetos[position].getAtributo2()
        return viewPersonalizada
    }

    init {
        this.objetos = objetos
    }
}
