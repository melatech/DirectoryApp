package com.melatech.ui.directory.people

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.melatech.R
import com.melatech.data.source.remote.model.people.PeopleAPIResponseItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private val viewModel by activityViewModels<PeopleViewModel>()
    lateinit var peopleAdapter: PeopleAdapter
    lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getPeopleDirectory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        peopleAdapter = PeopleAdapter { people -> navigateToDetailsScreen(people, view) }
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = peopleAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    private fun navigateToDetailsScreen(people: PeopleAPIResponseItem, view: View) {
        viewModel.emitSelectedPeople(people)
        Navigation.findNavController(view).navigate(R.id.navigateToPeopleDetailsFragment)
    }

    private fun getPeopleDirectory() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.peopleUiState.collect { people ->
                    peopleAdapter.submitList(people)
                }
            }
        }
    }
}