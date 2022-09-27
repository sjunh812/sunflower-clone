package org.sjhstudio.sunflowerclone.presentation.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentGardenBinding
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.GardenPlantingAdapter
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.PLANT_LIST_PAGE_INDEX
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
            btnAddPlant.setOnClickListener {
                navigateToPlantListPage()
            }
        }
    }

    private fun observeData() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                plantAndGardenPlantings.collectLatest { result ->
                    Log.e("debug", "xxx result: $result")
                    binding.hasPlantings = result.isNotEmpty()
                    adapter.submitList(result) {
                        // At this point, the content should be drawn
                        activity?.reportFullyDrawn()
                    }
                }
            }
        }
    }

    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            PLANT_LIST_PAGE_INDEX
    }
}