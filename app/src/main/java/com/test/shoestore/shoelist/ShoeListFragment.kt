package com.test.shoestore.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var shoeListFragmentBinding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        return shoeListFragmentBinding.root
    }
}