package com.melatech.data.source.remote.model.people

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleAPIResponseItem(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("data")
    val `data`: DataModel,
    @SerializedName("email")
    val email: String,
    @SerializedName("favouriteColor")
    val favouriteColor: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("fromName")
    val fromName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("jobtitle")
    val jobTitle: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("to")
    val to: String,
    @SerializedName("type")
    val type: String
): Serializable