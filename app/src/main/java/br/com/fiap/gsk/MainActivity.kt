package br.com.fiap.gsk

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import br.com.fiap.gsk.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.btEntrar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                email.isEmpty() -> {
                    binding.editEmail.error = "Insira o e-mail"
                }
                senha.isEmpty() -> {
                    binding.editSenha.error = "Insira a senha"
                }
                email.contains("@hotmail.com") -> {
                    val snackbar = Snackbar.make(it, "E-mail inválido",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                senha.length <=5 -> {
                    val snackbar = Snackbar.make(it, "Senha precisa ter no mínimo 6 caracteres",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                else -> {
                 login(it)

                }
            }

        }

    }
    private fun login(view: View){
        val progressbar = binding.progressBar
        progressbar.visibility = View.VISIBLE

        binding.btEntrar.isEnabled = false
        binding.btEntrar.setTextColor(Color.parseColor("FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()
            val snackbar = Snackbar.make(view, "Login efetuado com sucesso!",Snackbar.LENGTH_SHORT)
            snackbar.show()
        }, 3000)
    }

    private fun navegarTelaPrincipal(){
    val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}