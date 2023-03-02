package com.melatech.di

import com.melatech.data.source.people.IPeopleDatasource
import com.melatech.data.source.people.IPeopleRepository
import com.melatech.data.source.people.PeopleRepository
import com.melatech.data.source.remote.RemotePeopleDatasource
import com.melatech.data.source.remote.RemoteRoomsDatasource
import com.melatech.data.source.rooms.IRoomsDatasource
import com.melatech.data.source.rooms.IRoomsRepository
import com.melatech.data.source.rooms.RoomsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindPeopleDatasource(
        peopleDatasource: RemotePeopleDatasource
    ): IPeopleDatasource

    @Binds
    fun bindPeopleRepository(
        peopleRepository: PeopleRepository
    ): IPeopleRepository

//    @Binds
//    fun bindRoomsDatasource(
//        roomsDatasource: RemoteRoomsDatasource
//    ): IRoomsDatasource
//
//    @Binds
//    fun bindRoomsRepository(
//        roomsRepository: RoomsRepository
//    ): IRoomsRepository
}