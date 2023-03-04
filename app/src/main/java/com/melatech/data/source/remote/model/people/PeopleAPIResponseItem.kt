package com.melatech.data.source.remote.model.people

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleAPIResponseItem(
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("data")
    val `data`: DataModel? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("favouriteColor")
    val favouriteColor: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("fromName")
    val fromName: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("jobtitle")
    val jobTitle: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("to")
    val to: String? = null,
    @SerializedName("type")
    val type: String? = null
): Serializable