package com.example.caixadesupermercado.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.caixadesupermercado.R
import br.com.zup.caixadesupermercado.databinding.ActivityHomeBinding
import com.example.caixadesupermercado.CARRINHO
import com.example.caixadesupermercado.informacao.InformacaoActivity
import com.example.caixadesupermercado.MENSAGEM_CAMPO_NOME_PRODUTO_OBRIGATORIO
import com.example.caixadesupermercado.MENSAGEM_CAMPO_QUANTIDADE_OBRIGATORIO
import com.example.caixadesupermercado.MENSAGEM_CAMPO_VALOR_PRODUTO_OBRIGATORIO
import com.example.caixadesupermercado.model.Carrinho

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var nomeProduto: String
    private lateinit var quantidade: String
    private lateinit var valorDoProduto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.caixa_supermercado)
        binding.button.setOnClickListener {
            enviarDadosCarrinho()
       }
    }

    private fun enviarDadosCarrinho() {
        recuperarDadosCarrinho()
        if (!verificarCamposEdicao()) {
            val carrinho = Carrinho(
                nomeProduto,
                quantidade.toInt(),
                valorDoProduto.toDouble()
            )

            val intent = Intent(this, InformacaoActivity::class.java).apply {
                putExtra(CARRINHO, carrinho)
            }
            startActivity(intent)
            limparCamposEdicao()
        }
    }

    private fun recuperarDadosCarrinho() {
        this.nomeProduto = binding.editNomeProduto.text.toString()
        this.quantidade = binding.editQuantidade.text.toString()
        this.valorDoProduto = binding.editValorUnitario.text.toString()
    }

    private fun verificarCamposEdicao(): Boolean {
        when {
            this.nomeProduto.isEmpty() -> {
                binding.editNomeProduto.error = MENSAGEM_CAMPO_NOME_PRODUTO_OBRIGATORIO
                return true
            }
            this.quantidade.isEmpty() -> {
                binding.editQuantidade.error = MENSAGEM_CAMPO_QUANTIDADE_OBRIGATORIO
                return true
            }
            this.valorDoProduto.isEmpty() -> {
                binding.editValorUnitario.error = MENSAGEM_CAMPO_VALOR_PRODUTO_OBRIGATORIO
                return true
            }
        }
        return false
    }

    private fun limparCamposEdicao() {
        binding.editNomeProduto.text.clear()
        binding.editValorUnitario.text.clear()
        binding.editQuantidade.text.clear()
    }
}