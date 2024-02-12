package com.bogdash.fragments_2.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.fragments_2.R
import com.bogdash.fragments_2.RecyclerViewAdapter
import com.bogdash.fragments_2.UserService

class ListOfUsersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = RecyclerViewAdapter(UserService.getUsers())

        setFragmentResultListener(getString(R.string.updateRequestKey)) { _, bundle ->
            val imageUriString = bundle.getString("imageKey")
            val imageUri = imageUriString?.let { Uri.parse(it) }

            imageUri?.let{
                (recyclerView.adapter as RecyclerViewAdapter).updateUserImage(it)
                (recyclerView.adapter as RecyclerViewAdapter).updateUser()
            }
        }
    }

    companion object {
        const val LIST_OF_USERS_FRAGMENT_TAG = "LIST_OF_USERS_FRAGMENT_TAG"
    }
}
