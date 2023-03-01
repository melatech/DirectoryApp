package com.melatech.data.source.people

import com.melatech.data.source.remote.model.people.PeopleAPIResponse
import retrofit2.Response

interface IPeopleRepository {

    suspend fun getPeopleDirectory(): Response<PeopleAPIResponse>
}