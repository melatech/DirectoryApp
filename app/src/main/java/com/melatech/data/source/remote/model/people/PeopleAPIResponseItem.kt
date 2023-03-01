package com.melatech.data.source.remote.model.people

data class PeopleAPIResponseItem(
    val avatar: String,
    val createdAt: String,
    val `data`: DataModel,
    val email: String,
    val favouriteColor: String,
    val firstName: String,
    val fromName: String,
    val id: String,
    val jobtitle: String,
    val lastName: String,
    val name: String,
    val size: String,
    val to: String,
    val type: String
)