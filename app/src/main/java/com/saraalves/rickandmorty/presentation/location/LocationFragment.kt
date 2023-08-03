package com.saraalves.rickandmorty.presentation.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentLocationBinding
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : Fragment(R.layout.fragment_location) {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() =_binding

    private lateinit var adapter: AllLocationAdapter
    private var allLocation = mutableListOf<AllLocation>()
    private val viewModel: LocationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}