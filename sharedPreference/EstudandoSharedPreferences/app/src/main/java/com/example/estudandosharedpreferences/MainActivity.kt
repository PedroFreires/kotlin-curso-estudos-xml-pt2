package com.example.estudandosharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudandosharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE)

        binding.button.setOnClickListener { saveData() } // 1° salva
        binding.button.setOnClickListener { getData() } // 2° recupera
    }

    private fun saveData() {
        val name = binding.editName.text.toString()
        val lastName = binding.editLastName.text.toString()

        with (sharedPref.edit()) {
            putString("name", name)
            putString("lastName", lastName)
            apply()
        }
    }

    private fun getData() {
        val name = sharedPref.getString("name", "")
        val lastName = sharedPref.getString("lastName", "")

        binding.editName.setText(name)
        binding.editLastName.setText(lastName)
    }
}