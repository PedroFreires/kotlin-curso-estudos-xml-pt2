package com.example.radiobutton

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { _, Id ->
            when(Id) {
                R.id.rb_Opc1 -> {
                    Log.i("INFOTESTE", "Opção 1: ")
                }
                R.id.rb_Opc2 -> {
                    Log.i("INFOTESTE", "Opção 2: ")

                }
                else -> {
                    Log.i("INFOTESTE", "Opção 3: ")
                }
            }
        }

    }
}