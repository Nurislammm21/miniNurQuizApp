package com.example.nurquizapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nurquizapp.R
import com.example.nurquizapp.databinding.ViewholderQuestionItemBinding

class QuestionAdapter(
    val correctAnswer: String,
    val users: MutableList<String> = mutableListOf(),
    val returnScore: Score


): RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    interface Score{
        fun amount(number: Int, clickedAnswer: String)
    }


private lateinit var binding: ViewholderQuestionItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderQuestionItemBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ViewholderQuestionItemBinding.bind(holder.itemView)
        binding.answerTxt.text = difference.currentList[position]
        var currentPosition = 0
        when(correctAnswer){
            "a"->{
                currentPosition = 0
            }

            "b"->{
                currentPosition = 1
            }

            "c"->{
                currentPosition = 2
            }

            "d"->{
                currentPosition = 3
            }
        }

        if(difference.currentList.size == 5 && currentPosition == position){
            binding.answerTxt.setBackgroundResource(R.drawable.green_background)
            binding.answerTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))

            val drawable = ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
            binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
        }

        if(difference.currentList.size == 5){
            var clickedPosition = 0
            when(difference.currentList[4]){
                "a"->{
                    clickedPosition = 0
                }

                "b"->{
                    clickedPosition = 1
                }

                "c"->{
                    clickedPosition = 2
                }

                "d"->{
                    clickedPosition = 3
                }

            }

                if(clickedPosition == position && clickedPosition != currentPosition){
                    binding.answerTxt.setBackgroundResource(R.drawable.red_background)
                    binding.answerTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))

                    val drawable = ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                    binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                }
        }
        if(position == 4){
            binding.root.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            var str = ""
            when(position){

                0->{
                    str = "a"
                }

                1->{
                    str = "b"
                }

                2->{
                    str = "c"
                }

                3->{
                    str = "d"
                }

            }


            users.add(4,str)
            notifyDataSetChanged()

            if(currentPosition == position){
                binding.answerTxt.setBackgroundResource(R.drawable.green_background)
                binding.answerTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))

                val drawable = ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(5,str)

            }else{
                binding.answerTxt.setBackgroundResource(R.drawable.red_background)
                binding.answerTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))

                val drawable = ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(0,str)
            }


        }

        if(difference.currentList.size == 5) holder.itemView.setOnClickListener(null)


    }

    override fun getItemCount(): Int = difference.currentList.size


    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }


    }

    val difference = AsyncListDiffer(this, differCallback)


}