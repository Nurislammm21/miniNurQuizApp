package com.example.nurquizapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}