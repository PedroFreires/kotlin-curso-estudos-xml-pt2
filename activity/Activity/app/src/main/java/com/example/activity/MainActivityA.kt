package com.example.activity

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
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
            //Inicializando uma nova activity (activity B)
            resultLauncher.launch(Intent(this, MainActivityB::class.java))
        }
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result: androidx.activity.result.ActivityResult ->
        //recebendo a info da activity b
        val resultCode = result.resultCode
        val data = result.data

        if(resultCode == RESULT_OK) {
            if(data != null) {
                if(data.hasExtra("user")) {

                    val user = data.getSerializableExtra("user") as User
                    Log.i("INFOTESTE", "resultLauncher: ${user.name}")
                    Log.i("INFOTESTE", "resultLauncher: ${user.age}")
                }
            }
        }
    }
}