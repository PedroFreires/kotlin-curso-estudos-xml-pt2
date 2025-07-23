package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activity.databinding.ActivityMainABinding

class MainActivityA : AppCompatActivity() {

    private lateinit var binding: ActivityMainABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainABinding.inflate(layoutInflater)
        setContentView(binding.root)


        initListener()
    }
    private fun initListener() {
        binding.btnNext.setOnClickListener {
            // Enviando informação de uma activity para outra
            val intent = Intent(this, MainActivityB::class.java)
            intent.putExtra("user", User("Pedro", 20))
            startActivity(intent)
        }
    }
}