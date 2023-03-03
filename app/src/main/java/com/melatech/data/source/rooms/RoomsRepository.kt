package com.melatech.data.source.rooms

import android.util.Log
import com.melatech.data.source.remote.RemoteRoomsDatasource
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import retrofit2.Response
import javax.inject.Inject

class RoomsRepository @Inject constructor(
    private val roomDatasource: RemoteRoomsDatasource
): IRoomsRepository {
    override suspend fun getRoomDirectory(): Response<RoomsAPIResponse> {
        Log.d("jason", "inside rooms repo")
        return roomDatasource.getRoomDirectory()
    }
}