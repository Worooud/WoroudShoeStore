package com.example.android.woroudshoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.woroudshoestore.R
import com.example.android.woroudshoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

   private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)


        binding.loginBtn.setOnClickListener {
            goToWelcomeScreen(it)
        }

        binding.registerBtn.setOnClickListener {
            goToWelcomeScreen(it)
        }

        return binding.root
    }

 private  fun goToWelcomeScreen(view: View){
       view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }



}