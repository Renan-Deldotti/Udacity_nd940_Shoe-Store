package com.test.shoestore.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    val shoe = MutableLiveData(Shoe("", 0.00, "", "", mutableListOf()))

    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = arrayListOf()
    }

    fun insertNewShoe() {
        _shoesList.value = _shoesList.value?.plus(shoe.value!!)
        shoe.value = Shoe("", 0.00, "", "", mutableListOf())
    }
}