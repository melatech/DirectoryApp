package com.melatech.data.source.rooms

import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import retrofit2.Response

interface IRoomsRepository {
    suspend fun getRoomDirectory(): Response<RoomsAPIResponse>

}