package org.sjhstudio.sunflowerclone.presentation.ui.home.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentPlantListBinding
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.PlantAdapter
import org.sjhstudio.sunflowerclone.presentation.ui.home.viewmodel.PlanListViewModel

@AndroidEntryPoint
class PlantListFragment : BaseFragment<FragmentPlantListBinding>(R.layout.fragment_plant_list) {

    private val viewModel: PlanListViewModel by viewModels()
    private val adapter: PlantAdapter by lazy { PlantAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
        setHasOptionsMenu(true)
    }

    private fun initView() {
        with(binding) {
            rvPlantList.adapter = adapter
        }
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.plants.collectLatest { plants ->
                adapter.submitList(plants)
                println("xxx $plants")
            }
        }
    }

    private fun updateData() {
        with(viewModel) {
            if (isFiltered()) clearGrowZoneNumber()
            else setGrowZoneNumber(9)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                updateData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}