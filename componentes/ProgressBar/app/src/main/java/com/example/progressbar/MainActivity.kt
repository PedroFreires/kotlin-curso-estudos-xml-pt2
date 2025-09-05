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
    }
}