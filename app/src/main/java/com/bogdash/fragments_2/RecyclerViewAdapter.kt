package com.bogdash.fragments_2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val users: ArrayList<UserData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val user = users[position]
        with(holder) {
            photo.setImageResource(user.photo)
            firstName.text = user.firstName
            lastName.text = user.lastName
            phone.text = user.phone

            itemView.setOnClickListener {
                (itemView.context as? MainActivity)?.showDetailFragmentFor(user)
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUser() {
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.iv_photo)
        val firstName: TextView = itemView.findViewById(R.id.tv_firstname)
        val lastName: TextView = itemView.findViewById(R.id.tv_lastname)
        val phone: TextView = itemView.findViewById(R.id.tv_phone)
    }
}