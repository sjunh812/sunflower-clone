package org.sjhstudio.sunflowerclone.presentation.ui.detail.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentPlantDetailBinding
import org.sjhstudio.sunflowerclone.domain.model.Plant
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.detail.viewmodel.PlantDetailViewModel

@AndroidEntryPoint
class PlantDetailFragment :
    BaseFragment<FragmentPlantDetailBinding>(R.layout.fragment_plant_detail) {

    //    private val args: PlantDetailFragmentArgs by navArgs()
    private val plantDetailViewModel: PlantDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        initView()
    }

    private fun bind() {
        with(binding) {
            viewModel = plantDetailViewModel
            callback = object : Callback {
                override fun add(plant: Plant?) {
                    plant?.let {
                        hideAppBarFab(fab)
                        plantDetailViewModel.addPlantToGarden()
                        Snackbar.make(
                            root,
                            getString(R.string.label_added_plant_to_garden),
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    private fun initView() {
        with(binding) {
            var isToolbarShown = false
            scrollviewPlantDetail.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                val shouldShowToolbar = scrollY > toolbar.height

                if (isToolbarShown != shouldShowToolbar) {
                    isToolbarShown = shouldShowToolbar
                    // Use shadow animator to add elevation if toolbar is shown
                    layoutAppBar.isActivated = shouldShowToolbar
                    // Show the plant name if toolbar is shown
                    layoutToolbar.isTitleEnabled = shouldShowToolbar
                }
            }

            toolbar.apply {
                setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }

                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.action_share -> {
                            createShareIntent()
                            true
                        }
                        else -> false
                    }
                }
            }
        }
    }

    private fun createShareIntent() {
        val shareText =
            plantDetailViewModel.plant.value.takeIf { plant -> plant != Plant.EMPTY }?.let { plant ->
                getString(R.string.label_share_text_plant, plant.name)
            } ?: ""
        val shareIntent = ShareCompat.IntentBuilder(requireActivity())
            .setText(shareText)
            .setType("text/plain")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }

    fun navigateToGallery() {
        plantDetailViewModel.plant.value.takeIf { plant -> plant != Plant.EMPTY }?.let { plant ->
            val direction =
                PlantDetailFragmentDirections.actionPlantDetailFragmentToGalleryFragment(plant.name)
            findNavController().navigate(direction)
        }
    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    interface Callback {
        fun add(plant: Plant?)
    }
}