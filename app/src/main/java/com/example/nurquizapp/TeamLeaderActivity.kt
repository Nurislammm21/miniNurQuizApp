package com.example.nurquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nurquizapp.databinding.ActivityTeamLeaderBinding

class TeamLeaderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamLeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}