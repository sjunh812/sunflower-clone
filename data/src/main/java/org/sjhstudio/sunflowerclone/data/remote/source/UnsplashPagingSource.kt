package org.sjhstudio.sunflowerclone.data.remote.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.sjhstudio.sunflowerclone.data.mapperToUnsplashPhotos
import org.sjhstudio.sunflowerclone.data.remote.api.UnsplashService
import org.sjhstudio.sunflowerclone.data.repository.NETWORK_PAGE_SIZE
import org.sjhstudio.sunflowerclone.domain.model.UnsplashPhoto

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

internal class UnsplashPagingSource(
    private val service: UnsplashService,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = service.searchPhotos(query, page, NETWORK_PAGE_SIZE)
            val photos = mapperToUnsplashPhotos(response.results)
            LoadResult.Page(
                data = photos,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.totalPages) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
        //        return state.anchorPosition?.let { anchorPosition ->
//            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
//        }
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}