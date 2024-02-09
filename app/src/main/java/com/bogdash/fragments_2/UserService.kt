package com.bogdash.fragments_2

class UserService {
    companion object {
        fun getUsers(): ArrayList<UserData> {
            return arrayListOf(
                UserData(0, R.drawable.photo_1, "Ivan", "Ivanov", "8 965 786 54 56"),
                UserData(0, R.drawable.photo_2, "Petya", "Petrov", "8 865 566 54 56"),
                UserData(0, R.drawable.photo_3, "Aleksey", "Alekseev", "8 965 456 54 32"),
                UserData(0, R.drawable.photo_4, "Mark", "Markov", "8 123 786 54 32")
            )
        }
    }
}
