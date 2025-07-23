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
            startActivity(Intent(this, MainActivityB::class.java))
        }
    }
}