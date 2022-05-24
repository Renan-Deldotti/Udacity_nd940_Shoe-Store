package com.test.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var instructionsFragmentBinding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        instructionsFragmentBinding =
            FragmentInstructionsBinding.inflate(inflater, container, false)

        instructionsFragmentBinding.instructionsStartBt.setOnClickListener {
            it.findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
            )
        }

        return instructionsFragmentBinding.root
    }
}