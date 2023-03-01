package com.melatech.data.source.remote.model.rooms

data class RoomsAPIResponseItem(
    val createdAt: String,
    val id: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int
)