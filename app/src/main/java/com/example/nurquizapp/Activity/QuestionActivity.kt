package com.example.nurquizapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.nurquizapp.Adapters.QuestionAdapter
import com.example.nurquizapp.Domain.QuestionModel
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), QuestionAdapter.Score {
    private lateinit var binding : ActivityQuestionBinding
    var position: Int = 0
    var receiverList : MutableList<QuestionModel> = mutableListOf()
    var allScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@QuestionActivity.window
        window.statusBarColor = ContextCompat.getColor(this@QuestionActivity, R.color.gray)


        receiverList = intent.getParcelableArrayListExtra<QuestionModel>("list")!!.toMutableList()

        binding.apply {
            backBtn.setOnClickListener{
                finish()
            }

            progressBar.progress = 1
            questionLineTxt.text = receiverList[position].question
            val drawableResourceId: Int = binding.root.resources.getIdentifier(
                receiverList[position].picPath,
                "drawable",binding.root.context.packageName
            )

            Glide.with(this@QuestionActivity).load(drawableResourceId).centerCrop().
            apply(RequestOptions.bitmapTransform(RoundedCorners(60))).into(pictureUsa)

            loadAnswers()

            rightArrow.setOnClickListener {
                if(progressBar.progress == 10){
                    val intent = Intent(this@QuestionActivity,ScoreActivity::class.java)
                    intent.putExtra("Score",allScore)
                    startActivity(intent)
                    finish()
                    return@setOnClickListener
                }
                position++
                progressBar.progress = progressBar.progress + 1
                questionNumberTxt.text = "Question "+ progressBar.progress + "/10"
                questionLineTxt.text = receiverList[position].question

                val drawableResourceId: Int = binding.root.resources.getIdentifier(
                    receiverList[position].picPath,
                    "drawable",binding.root.context.packageName
                )

                Glide.with(this@QuestionActivity).load(drawableResourceId).centerCrop().
                apply(RequestOptions.bitmapTransform(RoundedCorners(60))).into(pictureUsa)


                loadAnswers()

            }

            leftArrow.setOnClickListener {
                if(progressBar.progress == 1){

                    return@setOnClickListener
                }
                position--
                progressBar.progress = progressBar.progress - 1
                questionNumberTxt.text = "Question "+ progressBar.progress + "/10"
                questionLineTxt.text = receiverList[position].question

                val drawableResourceId: Int = binding.root.resources.getIdentifier(
                    receiverList[position].picPath,
                    "drawable",binding.root.context.packageName
                )

                Glide.with(this@QuestionActivity).load(drawableResourceId).centerCrop().
                apply(RequestOptions.bitmapTransform(RoundedCorners(60))).into(pictureUsa)


                loadAnswers()
            }
        }
    }

    private fun loadAnswers(){
        val users: MutableList<String> = mutableListOf()
        users.add(receiverList[position].answer1.toString())
        users.add(receiverList[position].answer2.toString())
        users.add(receiverList[position].answer3.toString())
        users.add(receiverList[position].answer4.toString())

        if(receiverList[position].clickedAnswer != null) users.add(receiverList[position].clickedAnswer.toString())

        val questionAdapter by lazy {
            QuestionAdapter(
                receiverList[position].correctAnswer.toString(), users,this
            )
        }
        questionAdapter.difference.submitList(users)
        binding.questionRcView.apply {
            layoutManager = LinearLayoutManager(this@QuestionActivity)
            adapter = questionAdapter
        }
    }

    override fun amount(number: Int, clickedAnswer: String) {
        allScore+= number
        receiverList[position].clickedAnswer = clickedAnswer
    }
}