package com.example.datastore

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userManager = UserManager(this)

        initListeners()
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {

//            Comentei esse trecho após salvar as informações

//            val name = binding.edtName.text.toString()
//            val age = binding.edtAge.text.toString().toInt()
//            val authenticated = binding.cbAuthenticated.isChecked

//            lifecycleScope.launch {
//
//                userManager.saveUserData(name, age, authenticated)
//            }

            lifecycleScope.launch {
                val user = userManager.getUserData()

                Log.i("INFOTESTE", "name: ${user.name}")
                Log.i("INFOTESTE", "age: ${user.age}")
                Log.i("INFOTESTE", "authenticated: ${user.authenticated}")
            }
        }
    }
}