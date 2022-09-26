package org.sjhstudio.sunflowerclone.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.sunflowerclone.databinding.ItemPlantBinding
import org.sjhstudio.sunflowerclone.domain.model.Plant
import org.sjhstudio.sunflowerclone.presentation.ui.home.view.HomeViewPagerFragmentDirections

class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    class PlantViewHolder(private val binding: ItemPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {
                setClickListener {
                    plant?.let { plant ->
                        navigateToPlant(plant)
                    }
                }
            }
        }

        fun bind(plant: Plant) {
            with(binding) {
                this.plant = plant
            }
        }

        private fun navigateToPlant(plant: Plant) {
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.plantId)
            itemView.findNavController().navigate(direction)
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}