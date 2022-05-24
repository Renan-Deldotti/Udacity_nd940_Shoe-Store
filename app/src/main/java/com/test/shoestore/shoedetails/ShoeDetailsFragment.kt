package com.test.shoestore.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentShoeDetailsBinding
import com.test.shoestore.shoelist.ShoeListViewModel
import kotlin.random.Random

class ShoeDetailsFragment : Fragment() {

    private lateinit var shoeDetailsFragmentBinding: FragmentShoeDetailsBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeDetailsFragmentBinding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        shoeDetailsFragmentBinding.lifecycleOwner = this
        shoeDetailsFragmentBinding.shoeListViewModel = shoeListViewModel

        shoeDetailsFragmentBinding.shoeDeleteBt.setOnClickListener {
            it.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        shoeDetailsFragmentBinding.shoeSaveBt.setOnClickListener {
            saveShoe()
        }

        return shoeDetailsFragmentBinding.root
    }

    private fun saveShoe() {
        shoeListViewModel.insertNewShoe()
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }
}