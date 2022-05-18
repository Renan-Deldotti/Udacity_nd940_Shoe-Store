package com.test.shoestore.shoelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentShoeListBinding
import com.test.shoestore.databinding.SingleShoeItemBinding
import com.test.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    companion object {
        private const val TAG = "ShoeListFragment"
    }

    private lateinit var shoeListFragmentBinding: FragmentShoeListBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        shoeListViewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->
            Log.e(TAG, "onCreateView: ${shoesList.size}")
        }

        val testShoe = Shoe("Air max", 42.0, "Nike", "Blue shoe with air technology, good for running", mutableListOf(""))



        // The random shoe images were downloaded from pexels.com
        shoeListFragmentBinding.createNewShoe.setOnClickListener { fab ->
            shoeListViewModel.insertNewShoe(testShoe)
        }

        return shoeListFragmentBinding.root
    }
}