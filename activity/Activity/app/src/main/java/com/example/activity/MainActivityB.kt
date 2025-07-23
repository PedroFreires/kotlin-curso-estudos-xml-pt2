package com.example.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activity.databinding.ActivityMainBBinding

class MainActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityMainBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //add suporte ao toolbar B
        setSupportActionBar(binding.toolbarB)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getExtra()
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun getExtra() {
        val user = intent.getSerializableExtra("user") as User

        Log.i("INFOTESTE", "getExtra: ${user.name}")
        Log.i("INFOTESTE", "getExtra: ${user.age}")
    }
}