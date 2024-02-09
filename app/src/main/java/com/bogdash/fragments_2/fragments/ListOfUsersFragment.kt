package com.bogdash.fragments_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.fragments_2.R
import com.bogdash.fragments_2.RecyclerViewAdapter
import com.bogdash.fragments_2.UserData
import com.bogdash.fragments_2.UserService

class ListOfUsersFragment : Fragment() {

    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserData>
    private lateinit var userService: UserService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerViewAdapter(userArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        userService = UserService(requireContext())
        userArrayList = userService.getUser()
    }

    companion object {
        const val LIST_OF_USERS_FRAGMENT_TAG = "LIST_OF_USERS_FRAGMENT_TAG"
        const val FIRST_NAME_KEY = "MESSAGE_KEY"
        const val LAST_NAME_KEY = "LAST_NAME_KEY"
        const val PHONE_KEY = "PHONE_KEY"
        const val PHOTO_KEY = "PHOTO_KEY"

        fun newInstance() = ListOfUsersFragment()
    }
}