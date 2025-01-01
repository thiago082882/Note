package com.thiago.mvinotes.core.data.repository

import com.thiago.mvinotes.core.domain.model.Images
import com.thiago.mvinotes.core.domain.repository.ImagesRepository

class FakeImagesRepository : ImagesRepository {

    private var shouldReturnError = false
    fun setShouldReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun searchImages(
        query: String
    ): Images? {
        return if (shouldReturnError) {
            null
        } else {
            Images(
                listOf("image1", "image2", "image3", "image4")
            )
        }
    }
}