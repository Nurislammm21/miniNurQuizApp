package com.example.nurquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.nurquizapp.Domain.QuestionModel
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityMainBinding
import java.util.ArrayList

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
            singleBtn.setOnClickListener {
               val intent = Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)

            }
        }

    }

    private fun questionList(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(1,
            "What is the university that established near the Kaskelen?",
            "KBTU",
            "KIMEP",
            "NU",
            "SDU",
            "d",5,"q_1",null
            )
        )

        question.add(QuestionModel(2,
            "What is the best anime in the world?",
            "Death Note",
            "One piece",
            "Naruto",
            "Attack on Titans",
            "d",5,"q_2",null
            ))

        question.add(QuestionModel(3,
            "Who is the GGG ?",
            "Singer",
            "Businessman",
            "Boxer",
            "Cooker",
            "c",5,"q_3",null
        ))

        question.add(QuestionModel(4,
            "Which programming language that looks like a java",
            "Kotlin",
            "C#",
            "Python",
            "C++",
            "a",5,"q_4",null
        ))

        question.add(QuestionModel(5,
            "In which platform you can make app for ios & android?",
            "Android Studio",
            "Flutter",
            "Swift",
            "Visual Studio",
            "b",5,"q_5",null
        ))

        question.add(QuestionModel(6,
            "Who is the champion in light-weight in UFC?",
            "Jon Jones",
            "Gervonta Davis",
            "Islam Makhachev",
            "Conor McGregor",
            "c",5,"q_6",null
        ))

        question.add(QuestionModel(7,
            "The most important organ in human body?",
            "heart",
            "brain",
            "lungs",
            "liver",
            "a",5,"q_7",null
        ))

        question.add(QuestionModel(8,
            "When Narzhanov Nurislam was born?",
            "13.05.2005",
            "07.09.2004",
            "21.07.2003",
            "30.02.2002",
            "c",5,"q_8",null
        ))

        question.add(QuestionModel(9,
            "What does the field of epistemology explore?",
            "Human life",
            "Human bones",
            "Knowledge",
            "Money",
            "с",5,"q_9",null
        ))

        question.add(QuestionModel(10,
            " Which is the highest paid profession in IT",
            "Cyber-Security",
            "App Developer",
            "Back-End Developer",
            "QA-engineer",
            "a",5,"q_10",null
        ))
        return question
    }
}