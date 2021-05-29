package com.github.angads25.data

import com.github.angads25.domain.models.PexelImageResponse
import com.github.angads25.data.network.PexelService
import com.github.angads25.domain.NetworkImageRepository
import javax.inject.Inject

class NetworkImageRepositoryImpl @Inject constructor (val pexelService: PexelService): NetworkImageRepository {

    override suspend fun fetchImagesFromNetwork(query: String, page: String): PexelImageResponse {
        return pexelService.getImagesForQuery(query, page)
    }
}