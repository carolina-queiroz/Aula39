package com.example.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.tabuada.R
import com.example.tabuada.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.resultado_tabuada)

        recuperarNumeroDigitado()

        binding.btnRecalcularTabuada.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    private fun recuperarNumeroDigitado(){
        val numero = intent.getStringExtra("Numero")
        if(numero != null){
            exibirTituloTabuada(numero.toInt())
            exibirCalculoDaTabuada(numero.toInt())
        }
    }

    private fun exibirTituloTabuada(numero: Int){
         binding.tvNumeroDaTabuada.text = "Tabuada do $numero"
    }

    private fun exibirCalculoDaTabuada(numero: Int) {

        binding.tvCalculoTabuada.text = " $numero x 0 = ${numero * 0}" +
                "\n $numero x 1 = ${numero * 1}" +
                "\n $numero x 2 = ${numero * 2}" +
                "\n $numero x 3 = ${numero * 3}" +
                "\n $numero x 4 = ${numero * 4}" +
                "\n $numero x 5 = ${numero * 5}" +
                "\n $numero x 6 = ${numero * 6}" +
                "\n $numero x 7 = ${numero * 7}" +
                "\n $numero x 8 = ${numero * 8}" +
                "\n $numero x 9 = ${numero * 9}" +
                "\n $numero x 10 = ${numero * 10}"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}