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


//---------------------------------------
//<com.google.android.material.card.MaterialCardView
//xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:layout_height="wrap_content"
//android:layout_width="wrap_content"
//app:strokeColor="#68ABF8"
//app:cardElevation="8dp"
//app:strokeWidth="1dp"
//app:cardCornerRadius="16dp"
//android:layout_marginTop="8dp"
//android:layout_marginStart="8dp"
//android:layout_marginEnd="8dp"
//>
//
//<androidx.constraintlayout.widget.ConstraintLayout
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_margin="8dp">
//
//<TextView
//android:id="@+id/tv_title"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginStart="9dp"
//style="@style/TextAppearance.Material3.TitleLarge"
//app:layout_constraintBottom_toBottomOf="@id/tv_date"
//app:layout_constraintEnd_toStartOf="@id/tv_status"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent"
//app:layout_constraintHorizontal_chainStyle="spread"
//tools:text="TextView" />