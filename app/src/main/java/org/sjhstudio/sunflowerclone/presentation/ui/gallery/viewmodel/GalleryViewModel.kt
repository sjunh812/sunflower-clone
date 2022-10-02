package org.sjhstudio.sunflowerclone.presentation.ui.gallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.domain.model.UnsplashPhoto
import org.sjhstudio.sunflowerclone.domain.repository.UnsplashRepository
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {

    fun searchPictures(queryString: String): Flow<PagingData<UnsplashPhoto>> =
        repository.getSearchResultStream(queryString)
}