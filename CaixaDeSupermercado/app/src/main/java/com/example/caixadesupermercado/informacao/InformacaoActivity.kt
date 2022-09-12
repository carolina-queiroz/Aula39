package com.example.caixadesupermercado.informacao

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.caixadesupermercado.R
import br.com.zup.caixadesupermercado.databinding.ActivityInformacaoBinding
import com.example.caixadesupermercado.CARRINHO
import com.example.caixadesupermercado.home.HomeActivity
import com.example.caixadesupermercado.model.Carrinho

class InformacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.detalhe_compra)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recuperarExibirDados()

        binding.buttonRefazerCompras.setOnClickListener{
            val secondIntent = Intent(this, HomeActivity ::class.java)
            startActivity(secondIntent)
        }
    }

    private fun recuperarExibirDados() {
        val carrinho = intent.getParcelableExtra<Carrinho>(CARRINHO)

        if (carrinho != null){
            val valorTotal = calcularValorTotal(
                carrinho.getQuantidade(),
                carrinho.valorDoProduto()
            )
            exibirValorTotal(valorTotal)
        }
    }

    private fun calcularValorTotal(
        quantidade :Int,
        valorUnitario : Double
    ): Double{
        val valorTotal = quantidade * valorUnitario
        return valorTotal
    }
    private fun exibirValorTotal(valorTotal: Double){
        binding.textTotalValue.text = valorTotal.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}