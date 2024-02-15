package com.example.nurquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    var score: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra("Score",0)
        binding.apply {
            resultScoreTxt.text = score.toString()
            resultBackBtn.setOnClickListener {
                startActivity(Intent(this@ScoreActivity,MainActivity::class.java))
                finish()
            }
        }
    }
}