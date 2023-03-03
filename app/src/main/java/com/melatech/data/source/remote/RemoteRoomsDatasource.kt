package com.melatech.data.source.remote

import android.util.Log
import com.melatech.data.source.remote.api.DirectoryApi
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import com.melatech.data.source.rooms.IRoomsDatasource
import com.melatech.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteRoomsDatasource @Inject constructor(
    private val directoryApi: DirectoryApi,
    @IODispatcher
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): IRoomsDatasource{
    override suspend fun getRoomDirectory(): Response<RoomsAPIResponse> {
        Log.d("jason", "inside rooms datasource")
        return withContext(ioDispatcher){
            directoryApi.getRoomsServerList()
        }
    }
}