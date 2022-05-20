package com.test.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = arrayListOf()
    }

    fun insertNewShoe(shoe: Shoe) {
        _shoesList.value = _shoesList.value?.plus(shoe)
    }
}