package br.com.fiap.gsk

import android.graphics.Color
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


class TelaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#2196F3")
    }


}