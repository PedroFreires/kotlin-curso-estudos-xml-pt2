package com.example.aswitch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatus()
        
        binding.switchMaterial.setOnCheckedChangeListener { _, check ->
            setStatus()
        }
        
    }

    private fun setStatus() {
        binding.textStatus.text = if (binding.switchMaterial.isChecked) {
            "Ativo"
        } else {
            "Inativo"
        }
    }
}