package com.fdananda.kotlindataatual

import java.text.SimpleDateFormat

open class Data {

    open fun getDataAtual(): String {
        val data = System.currentTimeMillis()
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dataAtual = simpleDateFormat.format(data)
        return dataAtual
    }

    open fun getHoraAtual(): String {
        val data = System.currentTimeMillis()
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val horaAtual = simpleDateFormat.format(data)
        return horaAtual
    }

    open fun getDetalhesDataHora(): String? {
        val arrayData = getDataAtual().split("/").toTypedArray()
        val dia = arrayData[0]
        val mes = arrayData[1]
        val ano = arrayData[2]
        val arrayHora = getHoraAtual().split(":").toTypedArray()
        val hora = arrayHora[0]
        val minutos = arrayHora[1]
        val segundos = arrayHora[2]
        return """Dia: $dia - Mês: $mes - Ano: $ano
                Hora: $hora - Minutos: $minutos - Segundos: $segundos"""
    }
}
