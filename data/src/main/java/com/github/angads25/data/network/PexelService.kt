package com.github.angads25.data.network

import com.github.angads25.domain.models.PexelImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PexelService {

    @GET("/v1/search")
    suspend fun getImagesForQuery(@Query("query") query: String, @Query("page") page: String): PexelImageResponse
}