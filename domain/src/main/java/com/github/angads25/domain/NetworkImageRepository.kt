package com.github.angads25.domain

import com.github.angads25.domain.models.PexelImageResponse

interface NetworkImageRepository {

    suspend fun fetchImagesFromNetwork(query: String, page: String): PexelImageResponse
}