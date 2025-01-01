package com.thiago.mvinotes.core.domain.repository

import com.thiago.mvinotes.core.domain.model.Images

interface ImagesRepository {

    suspend fun searchImages(query: String): Images?

}