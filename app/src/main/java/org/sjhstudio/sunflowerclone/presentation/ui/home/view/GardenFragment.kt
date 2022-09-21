package org.sjhstudio.sunflowerclone.presentation.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentGardenBinding
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.GardenPlantingAdapter
import org.sjhstudio.sunflowerclone.presentation.ui.home.viewmodel.GardenPlantingListViewModel

@AndroidEntryPoint
class GardenFragment : BaseFragment<FragmentGardenBinding>(R.layout.fragment_garden) {

    private val viewModel: GardenPlantingListViewModel by viewModels()
    private val adapter: GardenPlantingAdapter by lazy { GardenPlantingAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        with(binding) {
            rvGardenList.adapter = adapter
        }
    }

    private fun observeData() {

    }
}