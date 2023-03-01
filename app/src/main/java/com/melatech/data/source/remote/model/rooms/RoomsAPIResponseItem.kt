package com.melatech.data.source.remote.model.rooms

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RoomsAPIResponseItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("isOccupied")
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
): Serializable