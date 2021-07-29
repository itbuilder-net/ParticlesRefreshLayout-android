package com.tenclouds.particlesrefreshlayoutsample.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tenclouds.particlesrefreshlayoutsample.R
import com.tenclouds.particlesrefreshlayoutsample.adapter.item.Plant
import com.tenclouds.particlesrefreshlayoutsample.adapter.view_holder.PlantViewHolder
import com.tenclouds.particlesrefreshlayoutsample.databinding.VhPlantBinding

class PlantsAdapter :
        RecyclerView.Adapter<PlantViewHolder>() {

    init {
        setHasStableIds(true)
    }

    var plantsList: List<Plant>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlantViewHolder(VhPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) =
        if (plantsList != null && position < plantsList?.size ?: 0) holder.bind(plantsList!![position])
        else Unit

    override fun getItemCount() = plantsList?.size ?: 0
}

