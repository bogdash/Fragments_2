package com.bogdash.fragments_2

import android.content.Context

class UserService(private val _context: Context) {
    private val context: Context = _context

    fun getUser(): ArrayList<UserData> {
        val userArrayList = arrayListOf<UserData>()

        val photoId = arrayOf(
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4
        )

        val firstNameId = arrayOf("Ivan", "Petya", "Aleksey", "Mark")
        val lastNameId = arrayOf("Ivanov", "Petrov", "Alekseev", "Markov")
        val phoneId = arrayOf("8 965 786 54 56","8 865 566 54 56", "8 965 456 54 32", "8 123 786 54 32")

        for (i in photoId.indices) {
            val user = UserData(photoId[i], firstNameId[i], lastNameId[i], phoneId[i])
            userArrayList.add(user)
        }

        return userArrayList
    }
}