package com.thiago.mvinotes.core.data.mapper

import com.thiago.mvinotes.core.data.remote.dto.ImageListDto
import com.thiago.mvinotes.core.domain.model.Images


fun ImageListDto.toImages(): Images {
    return Images(
        images = hits?.map { imageDto ->
            imageDto.previewURL ?: ""
        } ?: emptyList()
    )
}