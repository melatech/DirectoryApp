package com.melatech.ui.directory.people

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
import com.melatech.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private val viewModel by viewModels<PeopleViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("jason inside onAttach")
        getPeopleDirectory()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("jason inside onViewCreated")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("jason inside onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    private fun getPeopleDirectory(){
        println("jason inside getPeopleDirectory")
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.peopleUiState.collect{ people ->
                    println("jason inside collect -> $people")
                }
            }
        }
    }

    companion object {
        fun newInstance() = PeopleFragment()
    }
}