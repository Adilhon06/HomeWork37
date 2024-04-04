package com.example.homework37

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework37.databinding.ItemCelebrityBinding

class CelebritiesAdapter(
    private val cinemas: List<CelebritiesModel>
) : RecyclerView.Adapter<CelebritiesAdapter.CinemaViewHolder>() {

    inner class CinemaViewHolder(private val binding: ItemCelebrityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(celebritiesModel: CelebritiesModel) {
            Glide.with(binding.ivCelebrityImage)
                .load(celebritiesModel.image)
                .into(binding.ivCelebrityImage)
            binding.tvCelebritiesName.text = celebritiesModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val binding = ItemCelebrityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CinemaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        val celebritiesModel: CelebritiesModel = cinemas[position]
        holder.bind(celebritiesModel)
    }

    override fun getItemCount(): Int = cinemas.size
}
