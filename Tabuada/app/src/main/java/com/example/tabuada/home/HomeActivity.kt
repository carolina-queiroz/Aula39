package com.example.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tabuada.R
import com.example.tabuada.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var numeroDigitado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoCalcularTabuada.setOnClickListener {
            enviarNumeroDigitado()
            limparCampos()
        }
    }

    private fun enviarNumeroDigitado(){
        recuperarNumeroDigitado()
        if (!verificarCampos()){
            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("Numero", numeroDigitado)
            }
            startActivity(intent)
        }

    }

    private fun recuperarNumeroDigitado(){
        this.numeroDigitado = binding.editTextTabuada.text.toString()
    }

    private fun limparCampos(){
        binding.editTextTabuada.text.clear()
    }

    private fun verificarCampos(): Boolean{
        return if (numeroDigitado.isEmpty()) {
            Toast.makeText(this, R.string.MSG_PREENCHER_VALORES, Toast.LENGTH_LONG).show()
            true
        } else {
            false
        }
    }
}