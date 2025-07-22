package com.example.progressbar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.progressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        setStatus()
        
        binding.toggleButton.setOnCheckedChangeListener { _, _ ->
            setStatus()
        }
        
    }
    private fun setStatus() {
        binding.textStatus.text = if (binding.toggleButton.isChecked) {
            binding.progressBar.isVisible = true
            "Ligado"
        } else {
            binding.progressBar.isVisible = false
            "Desligado"
        }
        /*
        Uma activity é um módulo único e independente que normalmente está relacionado diretamente com uma tela de interface de usuário e suas
        funcionalidades correspondentes.

        Um aplicativo, por exemplo, tem uma Activity (tela/interface) que lista todas as tarefas daquele dia.
        O aplicativo também pode utilizar uma segunda Activity para que o usuário possa inserir novas tarefas.

         Existem várias coisas que precisamos entender sobre as Activities para usá-las de forma correta, como seu ciclo de vida, gerenciamento na memória,
         seus métodos e etc. Tudo isso influencia em como seu aplicativo vai ser desenvolvido e na qualidade dele também.

         OBS: Nosso aplicativo precisa ter pelo menos uma activity

         OBS: O ponto de entrada do nosso aplicativo sempre será uma activity
         */
    }
}