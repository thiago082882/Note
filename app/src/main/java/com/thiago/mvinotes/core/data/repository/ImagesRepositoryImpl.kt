package com.thiago.mvinotes.core.data.repository


import com.thiago.mvinotes.core.data.mapper.toImages
import com.thiago.mvinotes.core.data.remote.api.ImagesApi
import com.thiago.mvinotes.core.domain.model.Images
import com.thiago.mvinotes.core.domain.repository.ImagesRepository
import javax.inject.Inject


class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesRepository {

    override suspend fun searchImages(
        query: String
    ): Images? {
        return imagesApi.searchImages(query)?.toImages()
    }

}