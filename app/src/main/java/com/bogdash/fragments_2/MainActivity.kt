package com.bogdash.fragments_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.bogdash.fragments_2.databinding.ActivityMainBinding
import com.bogdash.fragments_2.fragments.DetailFragment
import com.bogdash.fragments_2.fragments.ListOfUsersFragment

class MainActivity : AppCompatActivity(), Router {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(ListOfUsersFragment.LIST_OF_USERS_FRAGMENT_TAG) == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.fragment_container_view,
                    ListOfUsersFragment(),
                    ListOfUsersFragment.LIST_OF_USERS_FRAGMENT_TAG
                )
                addToBackStack(ListOfUsersFragment.LIST_OF_USERS_FRAGMENT_TAG)
            }
        }
    }

    override fun showDetailFragmentFor(user: UserData) {
        val detailFragment = DetailFragment(user)
        supportFragmentManager.commit {
            add(R.id.fragment_container_view, detailFragment, DetailFragment.DETAIL_FRAGMENT_TAG)
            addToBackStack(DetailFragment.DETAIL_FRAGMENT_TAG)
        }
    }
}