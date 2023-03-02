package com.melatech.ui.directory.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melatech.R
import com.melatech.data.source.remote.model.people.PeopleAPIResponseItem

class PeopleAdapter(): ListAdapter<PeopleAPIResponseItem, PeopleAdapter.PeopleViewHolder>(PeopleDiffCallback){
    class PeopleViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        private val peopleSmallImage: ImageView = itemView.findViewById(R.id.iv_user_pic)
        private val peopleFirstName: TextView = itemView.findViewById(R.id.tv_first_name)
        private val peopleLastName: TextView = itemView.findViewById(R.id.tv_last_name)


        fun bind(people: PeopleAPIResponseItem){
            with(itemView) {
                Glide.with(context)
                    .load(people.avatar)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .override(200,200)
                    .into(peopleSmallImage)
            }
            peopleFirstName.text = people.name
            peopleLastName.text = people.lastName

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.people_item_layout, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = getItem(position)
        holder.bind(people)
    }
}

object PeopleDiffCallback: DiffUtil.ItemCallback<PeopleAPIResponseItem>() {
    override fun areItemsTheSame(
        oldItem: PeopleAPIResponseItem,
        newItem: PeopleAPIResponseItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PeopleAPIResponseItem,
        newItem: PeopleAPIResponseItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

}
