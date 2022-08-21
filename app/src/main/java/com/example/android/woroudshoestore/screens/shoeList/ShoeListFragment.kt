package com.example.android.woroudshoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.woroudshoestore.R
import com.example.android.woroudshoestore.databinding.FragmentShoeListBinding
import com.example.android.woroudshoestore.databinding.ShoeItemListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()

    private lateinit var binding:FragmentShoeListBinding
    private lateinit var showItemBinding:ShoeItemListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)


        viewModel.getShoesList().observe(viewLifecycleOwner) { shoesList ->
               for (item in shoesList) {
                   createItem(item)
               }
        }



        binding.addBtn.setOnClickListener(){
            it.findNavController().navigate(R.id.action_shoeListFragment_to_detailsFragment)
        }



        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

      this.findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return true
    }


   private fun createItem(shoe: Shoe) {
         showItemBinding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.shoe_item_list, binding.linearLayout,false)

        showItemBinding.apply {

            nameTV.text = shoe.name
            companyTV.text = shoe.company
            sizeTV.text = shoe.size.toString()
            descriptionTV.text = shoe.description
        }

        binding.linearLayout.addView(showItemBinding.root)
    }
}