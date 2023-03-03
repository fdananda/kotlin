package com.fdananda.kotlincrudsqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.Nullable
import java.lang.String
import kotlin.Int


class AdapterCustomizado(context: Context, atributos: ArrayList<Atributo>) :

    ArrayAdapter<Atributo?>(context, R.layout.adapter, atributos as List<Atributo?>) {

    private val atributos: ArrayList<Atributo>

    override fun getView(position: Int, @Nullable convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewPersonalizada: View = inflater.inflate(R.layout.adapter, parent, false)
        val id = viewPersonalizada.findViewById(R.id.textViewId) as TextView
        val atributo1 = viewPersonalizada.findViewById(R.id.textViewAtributo1) as TextView
        val atributo2 = viewPersonalizada.findViewById(R.id.textViewAtributo2) as TextView
        val atributo3 = viewPersonalizada.findViewById(R.id.textViewAtributo3) as TextView
        atributo1.text = atributos[position].getAtributo1()
        atributo2.text = atributos[position].getAtributo2()
        atributo3.text = atributos[position].getAtributo3()
        id.text = String.valueOf(atributos[position].getId())
        return viewPersonalizada
    }

    init {
        this.atributos = atributos
    }
}
