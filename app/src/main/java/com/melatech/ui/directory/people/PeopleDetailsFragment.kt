package com.melatech.ui.directory.people

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.melatech.R
import com.melatech.data.source.remote.model.people.PeopleAPIResponseItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleDetailsFragment : Fragment(R.layout.fragment_people_details) {

    private lateinit var userPic: ImageView
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var email: TextView
    private lateinit var jobTitle: TextView
    private lateinit var favColor: TextView

    private val viewModel by activityViewModels<PeopleViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userPic = view.findViewById(R.id.iv_user_pic)
        firstName = view.findViewById(R.id.tv_first_name_value)
        lastName = view.findViewById(R.id.tv_last_name_value)
        email = view.findViewById(R.id.tv_job_email_value)
        jobTitle = view.findViewById(R.id.tv_job_title_value)
        favColor = view.findViewById(R.id.tv_favorite_color_title_value)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.selectedItemUiState.collect{ people ->

                        with(view) {
                            Glide.with(context)
                                .load(people.avatar)
                                .placeholder(com.melatech.R.drawable.ic_launcher_foreground)
                                .centerCrop()
                                .into(userPic)
                        }

                       firstName.text = people.firstName
                       lastName.text = people.lastName
                       email.text = people.email
                       jobTitle.text = people.jobTitle
                       favColor.text = people.favouriteColor
                    }
                }
            }
        }
    }
}