package org.sjhstudio.sunflowerclone.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.data.remote.api.UnsplashService
import org.sjhstudio.sunflowerclone.data.remote.source.UnsplashPagingSource
import org.sjhstudio.sunflowerclone.domain.model.UnsplashPhoto
import org.sjhstudio.sunflowerclone.domain.repository.UnsplashRepository
import javax.inject.Inject

const val NETWORK_PAGE_SIZE = 25

internal class UnsplashRepositoryImpl @Inject constructor(
    private val service: UnsplashService
) : UnsplashRepository {

    override fun getSearchResultStream(query: String): Flow<PagingData<UnsplashPhoto>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            )
        ) {
            UnsplashPagingSource(service, query)
        }.flow
    }
}