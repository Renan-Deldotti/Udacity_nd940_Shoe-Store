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
import com.test.shoestore.models.Shoe
import com.test.shoestore.shoelist.ShoeListViewModel
import kotlin.random.Random

class ShoeDetailsFragment : Fragment() {

    private lateinit var shoeDetailsFragmentBinding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        shoeDetailsFragmentBinding.shoeDeleteBt.setOnClickListener {
            it.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        shoeDetailsFragmentBinding.shoeSaveBt.setOnClickListener {
            saveShoe()
        }

        return shoeDetailsFragmentBinding.root
    }

    private fun saveShoe() {
        // Add some shoe images to look better
        // obs: random shoe images are from pexels.com
        val shoeName = shoeDetailsFragmentBinding.shoeNameEt.text.toString().ifEmpty { "Unnamed" }
        val shoeSize = if (shoeDetailsFragmentBinding.shoeSizeEt.text.toString().isEmpty()) 0.00 else shoeDetailsFragmentBinding.shoeSizeEt.text.toString().toDouble()
        val shoeCompany = shoeDetailsFragmentBinding.shoeCompanyEt.text.toString().ifEmpty { "Unspecified" }
        val shoeDescription = shoeDetailsFragmentBinding.shoeDescriptionEt.text.toString().ifEmpty { "No description" }
        val shoePhoto = mutableListOf(Random.nextInt(1,6).toString())

        val newShoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription, shoePhoto)

        val shoeListViewModel: ShoeListViewModel by activityViewModels()
        shoeListViewModel.insertNewShoe(newShoe)
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }
}