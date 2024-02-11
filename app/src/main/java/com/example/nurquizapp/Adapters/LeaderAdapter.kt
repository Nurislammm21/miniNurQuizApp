package com.example.nurquizapp.Adapters

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.nurquizapp.Domain.UserModel
import com.example.nurquizapp.databinding.ViewholderItemLeadersBinding

class LeaderAdapter() : RecyclerView.Adapter<LeaderAdapter.ViewHolder>() {




    private lateinit var binding: ViewholderItemLeadersBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderAdapter.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderItemLeadersBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }
    override fun getItemCount(): Int = difference.currentList.size

    override fun onBindViewHolder(holder: LeaderAdapter.ViewHolder, position: Int) {
        val binding = ViewholderItemLeadersBinding.bind(holder.itemView)
        binding.titleTxt.text = difference.currentList[position].name

        val drawableResourceId: Int = binding.root.resources.getIdentifier(
            difference.currentList[position].picture,
            "drawable", binding.root.context.packageName
        )

        Glide.with(binding.root.context).load(drawableResourceId).into(binding.picture)
        binding.rowTxt.text = (position+4).toString()
        binding.scoreTxt.text = difference.currentList[position].score.toString()


    }





        inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<UserModel>(){
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }


    }

    val difference = AsyncListDiffer(this, differCallback)

}