package com.melatech.data.source.rooms

import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import retrofit2.Response

class RoomsRepository(): IRoomsRepository {
    override suspend fun getRoomDirectory(): Response<RoomsAPIResponse> {
        TODO("Not yet implemented")
    }
}