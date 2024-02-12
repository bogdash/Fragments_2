package com.bogdash.fragments_2.fragments

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
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

            ivPhotoUser.setOnClickListener{
                Toast.makeText(requireContext(), "hi", Toast.LENGTH_SHORT).show()
                val pickImageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                pickImage.launch(pickImageIntent)
            }

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

    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val selectedImageUri = data?.data
            binding.ivPhotoUser.setImageURI(selectedImageUri)
        }
    }

    companion object {
        const val DETAIL_FRAGMENT_TAG = "DETAIL_FRAGMENT_TAG"
    }
}
