package com.melatech.data.source.remote.api

import com.melatech.data.source.remote.model.people.PeopleAPIResponse
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DirectoryApi {

    @GET("people")
    suspend fun getPeopleServerList(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
    ): Response<PeopleAPIResponse>

    @GET("rooms")
    suspend fun getRoomsServerList(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        ): Response<RoomsAPIResponse>
}