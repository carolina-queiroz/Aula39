package com.example.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tabuada.databinding.ActivityHomeBinding
import com.example.tabuada.resultado.ResultadoActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var numeroDigitado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        "Tabuada".also { supportActionBar?.title = it }

        binding.botaoCalcularTabuada.setOnClickListener {
            enviarNumeroDigitado()
            limparCampos()
        }
    }

    private fun limparCampos(){
        binding.editTextTabuada.text.clear()
    }

    private fun verificarCampos(): Boolean{
        when{
            this.numeroDigitado.isEmpty() -> {
                binding.editTextTabuada.error = "É obrigatório digitar um número para calcular"
                return true
            }
        }
        return true
    }

    private fun recuperarNumeroDigitado(){
        this.numeroDigitado = binding.editTextTabuada.text.toString()
    }

    private fun enviarNumeroDigitado(){
        recuperarNumeroDigitado()
        if (!verificarCampos()){
            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("NUMERO", numeroDigitado)
            }
            startActivity(intent)
        }

    }
}