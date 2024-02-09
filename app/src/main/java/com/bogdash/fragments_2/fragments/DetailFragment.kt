package com.bogdash.fragments_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.bogdash.fragments_2.R
import com.bogdash.fragments_2.UserData
import com.bogdash.fragments_2.databinding.FragmentDetailBinding

class DetailFragment(
    private val user: UserData
) : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tiedFirstname.setText(user.firstName)
            tiedLastname.setText(user.lastName)
            edPhone.setText(user.phone)
            ivPhotoUser.setImageResource(user.photo)

            btnEdit.setOnClickListener {
                user.firstName = tiedFirstname.text.toString()
                user.lastName = tiedLastname.text.toString()
                user.phone = edPhone.text.toString()

                setFragmentResult(getString(R.string.updateRequestKey), Bundle())

                requireActivity().supportFragmentManager.popBackStack()
            }

            btnCancel.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        const val DETAIL_FRAGMENT_TAG = "DETAIL_FRAGMENT_TAG"
    }
}
