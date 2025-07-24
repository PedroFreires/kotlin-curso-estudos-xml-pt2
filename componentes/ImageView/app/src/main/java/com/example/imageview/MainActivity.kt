package com.example.imageview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isImageOne = true // flag para controlar qual imagem mostrar

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Antigo (altera img uma vez só)
        /* binding.btnAltera.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ic_baseline)
        }*/

        binding.btnAltera.setOnClickListener {
            if (isImageOne) {
                binding.imageView.setImageResource(R.drawable.ic_baseline) // imagem 1
            } else {
                binding.imageView.setImageResource(R.drawable.ic_android) // imagem 2
            }
            isImageOne = !isImageOne // inverte a flag
        }
    }
}