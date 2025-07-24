package com.example.checkbox

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContent()

        binding.materialCheckBox.setOnCheckedChangeListener { _, _ ->
            setContent()
        }

    }

    private fun setContent() {
        binding.textStatus.text = if (binding.materialCheckBox.isChecked) {
            "Ativo"
        } else {
            "Inativo"
        }
    }
}