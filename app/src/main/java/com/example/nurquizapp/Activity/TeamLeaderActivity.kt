package com.example.nurquizapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.nurquizapp.Adapters.LeaderAdapter
import com.example.nurquizapp.Domain.UserModel
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ActivityTeamLeaderBinding

class TeamLeaderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamLeaderBinding
    private val leaderAdapter by lazy {LeaderAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val window: Window = this@TeamLeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@TeamLeaderActivity, R.color.gray)

        binding.apply {
            scoreTopTxt1.text = loadData()[0].score.toString()
            scoreTopTxt2.text = loadData()[1].score.toString()
            scoreTopTxt3.text = loadData()[2].score.toString()

            titleTop1Txt.text = loadData()[0].name
            titleTop2Txt.text = loadData()[1].name
            titleTop3Txt.text = loadData()[2].name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData()[0].picture,"drawable",binding.root.context.packageName)
            Glide.with(root.context).load(drawableResourceId1).into(picture1)

            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData()[1].picture,"drawable",binding.root.context.packageName)
            Glide.with(root.context).load(drawableResourceId2).into(picture2)

            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData()[2].picture,"drawable",binding.root.context.packageName)
            Glide.with(root.context).load(drawableResourceId3).into(picture3)


            menu.setItemSelected(R.id.board)
            menu.setOnItemSelectedListener {
                if(it == R.id.home){
                    startActivity(Intent(this@TeamLeaderActivity,MainActivity::class.java))

                }
            }

            val itemList: MutableList<UserModel> = loadData()
            itemList.removeAt(0)
            itemList.removeAt(1)
            itemList.removeAt(2)
            leaderAdapter.difference.submitList(itemList)

            leaderRcView.adapter = leaderAdapter
            leaderRcView.layoutManager = LinearLayoutManager(this@TeamLeaderActivity)


        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun loadData(): MutableList<UserModel>{
      val users: MutableList<UserModel> = mutableListOf()

        users.add(UserModel(1,"Tomiris","person1",6500 ))
        users.add(UserModel(2,"Nurislam","person2",6210))
        users.add(UserModel(3,"Anuar","person3",5900))

        users.add(UserModel(4,"Temirlan Orynbaev","person4",5890 ))
        users.add(UserModel(5,"Sayazhan Berikbolova","person5",5320))
        users.add(UserModel(6,"Dima Chibisov","person6",4780))

        users.add(UserModel(7,"Mikasa Akkerman","person7",4390 ))
        users.add(UserModel(8,"Aruzhan Lebaeva","person8",3320))
        users.add(UserModel(9,"Inkar Magnumova","person9",2900))

        users.add(UserModel(10,"Sagynysh Magnumov","person2",2210 ))

        return users
    }
}