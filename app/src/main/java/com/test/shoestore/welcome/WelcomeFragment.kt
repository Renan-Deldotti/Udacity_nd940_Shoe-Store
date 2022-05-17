package com.test.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var args: WelcomeFragmentArgs
    private lateinit var welcomeFragmentBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        args = WelcomeFragmentArgs.fromBundle(requireArguments())
        welcomeFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        // Add a default "Shoer" username if the field is empty
        val userName = if (args.username.isNullOrEmpty()) "Shoer" else args.username

        welcomeFragmentBinding.welcomeMainTV.text =
            getString(R.string.welcome_with_username, userName)

        welcomeFragmentBinding.welcomeAcceptedButton.setOnClickListener {
            it.findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        return welcomeFragmentBinding.root
    }
}