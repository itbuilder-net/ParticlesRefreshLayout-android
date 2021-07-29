package com.tenclouds.particlesrefreshlayoutsample.adapter.view_holder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.tenclouds.particlesrefreshlayoutsample.R
import com.tenclouds.particlesrefreshlayoutsample.adapter.item.Plant
import com.tenclouds.particlesrefreshlayoutsample.databinding.VhPlantBinding

class  PlantViewHolder(val binding: VhPlantBinding):
        RecyclerView.ViewHolder(binding.root) {

    fun bind(plant: Plant) {
        binding.apply {
            name.text = plant.name
            description.text = plant.description
            price.text = price.context.getString(R.string.price).format(plant.price)
            photo.setImageDrawable(ContextCompat.getDrawable(photo.context, plant.imageRes))
        }
    }
}