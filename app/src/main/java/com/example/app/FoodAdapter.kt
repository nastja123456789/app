package com.example.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.IemFoodBinding
import com.example.app.models.Food

class FoodAdapter(): ListAdapter<Food, FoodAdapter.FoodItemHolder>(DiffCallback) {

    class FoodItemHolder(private var binding: IemFoodBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.foodItem.text = food.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemHolder {
        val viewHolder = FoodItemHolder(
            IemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: FoodItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }
        }
    }
}