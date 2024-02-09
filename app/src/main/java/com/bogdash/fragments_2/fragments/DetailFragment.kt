package com.bogdash.fragments_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.bogdash.fragments_2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = arguments?.getString(FIRST_NAME_KEY)
        val lastName = arguments?.getString(LAST_NAME_KEY)
        val phone = arguments?.getString(PHONE_KEY)
        val photo = arguments?.getInt(PHOTO_KEY)

        with(binding) {
            tilFirstname.editText?.setText(firstName)
            tilLastname.editText?.setText(lastName)
            edPhone.setText(phone)
            ivPhotoUser.setImageResource(photo!!)

            btnEdit.setOnClickListener {

            }
        }
    }


    companion object {
        const val FIRST_NAME_KEY = "MESSAGE_KEY"
        const val DETAIL_FRAGMENT_TAG = "DETAIL_FRAGMENT_TAG"
        const val LAST_NAME_KEY = "LAST_NAME_KEY"
        const val PHONE_KEY = "PHONE_KEY"
        const val PHOTO_KEY = "PHOTO_KEY"

        fun newInstance(bundle: Bundle) = DetailFragment().apply { arguments = bundle }
    }
}