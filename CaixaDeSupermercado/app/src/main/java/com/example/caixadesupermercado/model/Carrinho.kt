package com.example.caixadesupermercado.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Carrinho(
    private var nomeProduto: String,
    private var quantidade: Int,
    private var valorDoProduto: Double
) : Parcelable {
    fun getNome()= this.nomeProduto
    fun getQuantidade()= this.quantidade
    fun valorDoProduto()= this.valorDoProduto
}