package com.example.nurquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.gray)

        binding.apply {
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if(it == R.id.board){
                    startActivity(Intent(this@MainActivity,TeamLeaderActivity::class.java))
                }
            }
        }
    }
}