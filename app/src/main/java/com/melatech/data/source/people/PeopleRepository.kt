package com.melatech.data.source.people

import com.melatech.data.source.remote.RemotePeopleDatasource
import com.melatech.data.source.remote.model.people.PeopleAPIResponse
import retrofit2.Response
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val peopleDatasource: RemotePeopleDatasource
): IPeopleRepository {
    override suspend fun getPeopleDirectory(): Response<PeopleAPIResponse> {
        return peopleDatasource.getPeopleDirectory()
    }
}