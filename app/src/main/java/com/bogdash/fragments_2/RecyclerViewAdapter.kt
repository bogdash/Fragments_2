package com.bogdash.fragments_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.fragments_2.fragments.ListOfUsersFragment

class RecyclerViewAdapter(private val userList: ArrayList<UserData>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val currentItem = userList[position]
        with(holder) {
            photo.setImageResource(currentItem.photo)
            firstName.text = currentItem.firstName
            lastName.text = currentItem.lastName
            phone.text = currentItem.phone

            val bundle = Bundle().apply {
                putString(ListOfUsersFragment.FIRST_NAME_KEY, currentItem.firstName)
                putString(ListOfUsersFragment.LAST_NAME_KEY, currentItem.lastName)
                putString(ListOfUsersFragment.PHONE_KEY, currentItem.phone)
                putInt(ListOfUsersFragment.PHOTO_KEY, currentItem.photo)
            }
            itemView.setOnClickListener {
                (itemView.context as? MainActivity)?.showDetailFragment(bundle)
            }
        }
    }



    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.iv_photo)
        val firstName: TextView = itemView.findViewById(R.id.tv_firstname)
        val lastName: TextView = itemView.findViewById(R.id.tv_lastname)
        val phone: TextView = itemView.findViewById(R.id.tv_phone)
    }
}