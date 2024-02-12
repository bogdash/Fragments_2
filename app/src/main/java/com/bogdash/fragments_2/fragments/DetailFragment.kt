package com.bogdash.fragments_2.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.setFragmentResult
import com.bogdash.fragments_2.R
import com.bogdash.fragments_2.UserData
import com.bogdash.fragments_2.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DetailFragment(
    private val user: UserData
) : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var selectedImageUri: Uri? = null
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
            Glide.with(requireContext())
                .load(user.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivPhotoUser)

            ivPhotoUser.setOnClickListener {
                val pickImageIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                pickImage.launch(pickImageIntent)
            }

            btnEdit.setOnClickListener {
                user.firstName = tiedFirstname.text.toString()
                user.lastName = tiedLastname.text.toString()
                user.phone = edPhone.text.toString()

                val bundle = Bundle()
                selectedImageUri?.let { uri ->
                    bundle.putString(IMAGE_KEY, uri.toString())
                }
                setFragmentResult(getString(R.string.updateRequestKey), bundle)

                requireActivity().supportFragmentManager.popBackStack()
            }

            btnCancel.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                selectedImageUri = data?.data
                Glide.with(requireContext())
                    .load(selectedImageUri)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivPhotoUser)
            }
        }

    companion object {
        const val DETAIL_FRAGMENT_TAG = "DETAIL_FRAGMENT_TAG"
        const val IMAGE_KEY = "IMAGE_KEY"
    }
}
