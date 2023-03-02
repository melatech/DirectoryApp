package com.melatech.ui.directory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melatech.R
import com.melatech.ui.directory.people.PeopleFragment
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "people_fragment"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,
                    PeopleFragment.newInstance(),
                    TAG)
                .commit()
        }
    }
}