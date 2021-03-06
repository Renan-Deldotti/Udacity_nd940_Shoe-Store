package com.test.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginFragmentBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        loginFragmentBinding.loginButton.setOnClickListener { v ->
            v.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(loginFragmentBinding.editTextUserName.text.toString())
            )
        }

        loginFragmentBinding.createAccountButton.setOnClickListener { v ->
            v.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(loginFragmentBinding.editTextUserName.text.toString())
            )
        }

        return loginFragmentBinding.root
    }

}