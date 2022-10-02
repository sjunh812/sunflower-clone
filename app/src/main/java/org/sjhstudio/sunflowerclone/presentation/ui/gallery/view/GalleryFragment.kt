package org.sjhstudio.sunflowerclone.presentation.ui.gallery.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentGalleryBinding
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.gallery.adapter.GalleryAdapter
import org.sjhstudio.sunflowerclone.presentation.ui.gallery.viewmodel.GalleryViewModel

@AndroidEntryPoint
class GalleryFragment : BaseFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {

    private val args: GalleryFragmentArgs by navArgs()
    private val viewModel: GalleryViewModel by viewModels()
    private val adapter: GalleryAdapter by lazy { GalleryAdapter() }
    private var searchJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        search(args.plantName)
    }

    private fun initView() {
        with(binding) {
            rvPhotoList.adapter = adapter
            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }
        }
    }

    private fun search(query: String) {
        with(viewModel) {
            // Make sure we cancel the previous job before creating a new one
            searchJob?.cancel()
            searchJob = lifecycleScope.launchWhenStarted {
                searchPictures(query).collectLatest { pageData ->
                    adapter.submitData(pageData)
                }
            }
        }
    }
}