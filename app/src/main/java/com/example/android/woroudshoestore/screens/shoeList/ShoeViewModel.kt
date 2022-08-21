package com.example.android.woroudshoestore.screens.shoeList

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel:ViewModel() {
    private val shoesList=MutableLiveData<MutableList<Shoe>>(mutableListOf())
    var shoe=Shoe()


    fun getShoesList(): LiveData<MutableList<Shoe>> = shoesList
    fun addShoe(){
        shoesList.value?.add(shoe)
         shoe=Shoe()
    }

}