package com.example.android.woroudshoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.android.woroudshoestore.R
import com.example.android.woroudshoestore.databinding.FragmentDetailsBinding
import com.example.android.woroudshoestore.screens.shoeList.ShoeViewModel
import com.udacity.shoestore.models.Shoe


class DetailsFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private  lateinit var binding:FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.viewModel=viewModel

        binding.saveBtn.setOnClickListener {
            viewModel.addShoe()
            it.findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }

        binding.cancelBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }


        return binding.root
    }


}