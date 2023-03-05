package com.melatech.ui.directory.rooms

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.melatech.R
import com.melatech.ui.directory.people.PeopleAdapter
import com.melatech.ui.directory.people.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class RoomsFragment : Fragment() {
    private val viewModel by viewModels<RoomsViewModel>()
    lateinit var roomsAdapter: RoomsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getRoomsDirectory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        roomsAdapter = RoomsAdapter()
        recyclerView = view.findViewById(R.id.rooms_recycler_view)
        recyclerView.adapter = roomsAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rooms, container, false)
    }

    private fun getRoomsDirectory(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.roomsUiState.collect{ rooms ->
                    roomsAdapter.submitList(rooms)
                }
            }
        }
    }

    companion object {
        fun newInstance() = RoomsFragment()
    }
}