package org.sjhstudio.sunflowerclone.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.sunflowerclone.databinding.ItemGardenPlantingBinding
import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings
import org.sjhstudio.sunflowerclone.presentation.ui.home.view.HomeViewPagerFragmentDirections
import org.sjhstudio.sunflowerclone.presentation.ui.home.viewmodel.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter :
    ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
        GardenPlantingDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGardenPlantingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemGardenPlantingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {
                setClickListener {
                    viewModel?.plantId?.let { plantId ->
                        navigateToPlant(plantId)
                    }
                }
            }
        }

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }

        private fun navigateToPlant(plantId: String) {
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plantId)
            itemView.findNavController().navigate(direction)
        }
    }
}

private class GardenPlantingDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

    override fun areItemsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant == newItem.plant
    }
}