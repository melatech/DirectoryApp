package com.melatech.ui.directory.rooms

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.melatech.R
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponseItem

class RoomsAdapter(): ListAdapter<RoomsAPIResponseItem, RoomsAdapter.RoomsViewHolder>(RoomsDiffCallback) {
    class RoomsViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        private val roomsSquareImage: View = itemView.findViewById(R.id.color_square)
        private val roomsRoomNumber: TextView = itemView.findViewById(R.id.tv_room_number_id)
        private val roomsCreatedAt: TextView = itemView.findViewById(R.id.tv_createdAt)
        private val roomsOccupancy: TextView = itemView.findViewById(R.id.tv_maximum_occupancy)

        fun bind(rooms: RoomsAPIResponseItem){
            val occupancy = rooms.isOccupied
            if (occupancy){
                roomsSquareImage.setBackgroundResource(R.color.green)
            }else{
                roomsSquareImage.setBackgroundResource(R.color.red)
            }

            roomsRoomNumber.text = rooms.id
            roomsCreatedAt.text = rooms.createdAt
            roomsOccupancy.text = rooms.maxOccupancy.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rooms_item_layout, parent, false)
        return RoomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        val rooms = getItem(position)
        holder.bind(rooms)
    }
}

object RoomsDiffCallback: DiffUtil.ItemCallback<RoomsAPIResponseItem>() {
    override fun areItemsTheSame(oldItem: RoomsAPIResponseItem, newItem: RoomsAPIResponseItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RoomsAPIResponseItem, newItem: RoomsAPIResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

}


