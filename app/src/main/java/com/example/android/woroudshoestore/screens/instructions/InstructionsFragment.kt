package com.example.android.woroudshoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.woroudshoestore.R
import com.example.android.woroudshoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

   private lateinit var binding:FragmentInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instructions,container,false)


        binding.nextBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }


        return binding.root
    }


}