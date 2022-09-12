package com.example.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tabuada.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var numeroDigitado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        "Tabuada".also { supportActionBar?.title = it }

        binding.botaoCalcularTabuada.setOnContextClickListener {
            enviarNumeroDigitado()
        }
    }

    private fun limparCampos(){
        binding.editText.text.clear()
    }

    private fun verificarCampos(): Boolean{
        when{
            this.numeroDigitado.isEmpty() -> {
                binding.editText.error = "É obrigatório digitar um número para calcular"
                return true
            }
        }
        return true
    }

    private fun recuperarNumeroDigitado(): String{
        this.numeroDigitado = binding.editText.text.toString()
        return numeroDigitado
    }

    private fun enviarNumeroDigitado(){
        recuperarNumeroDigitado()
        if (!verificarCampos()){
            val intent = Intent(this)
        }

    }
}