package com.melatech.data.source.remote

import android.util.Log
import com.melatech.data.source.people.IPeopleDatasource
import com.melatech.data.source.remote.api.DirectoryApi
import com.melatech.data.source.remote.model.people.PeopleAPIResponse
import com.melatech.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemotePeopleDatasource @Inject constructor(
    private val directoryApi: DirectoryApi,
    @IODispatcher
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ): IPeopleDatasource {
    override suspend fun getPeopleDirectory(): Response<PeopleAPIResponse> {
        Log.d("jason", "inside datasource")
        return withContext(ioDispatcher){
            directoryApi.getPeopleServerList()
        }
    }
}