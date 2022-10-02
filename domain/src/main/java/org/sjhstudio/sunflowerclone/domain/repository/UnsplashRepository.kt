package org.sjhstudio.sunflowerclone.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.domain.model.UnsplashPhoto

interface UnsplashRepository {

    fun getSearchResultStream(query: String): Flow<PagingData<UnsplashPhoto>>
}