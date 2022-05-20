package com.test.shoestore.shoelist

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.test.shoestore.R
import com.test.shoestore.databinding.FragmentShoeListBinding
import com.test.shoestore.databinding.SingleShoeItemBinding
import com.test.shoestore.models.Shoe
import kotlin.random.Random


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
            shoeListFragmentBinding.shoesList.removeAllViews()
            shoesList.forEach {
                val shoeItem: SingleShoeItemBinding = DataBindingUtil.inflate(inflater, R.layout.single_shoe_item, container, false)
                shoeItem.shoe = it
                val shoeImage = when (it.images[0].toInt()) {
                    2 -> R.drawable.shoe_2
                    3 -> R.drawable.shoe_3
                    4 -> R.drawable.shoe_4
                    5 -> R.drawable.shoe_5
                    6 -> R.drawable.shoe_6
                    else -> R.drawable.shoe_1
                }

                shoeItem.ssiShoeImage.setImageResource(shoeImage)
                shoeListFragmentBinding.shoesList.addView(shoeItem.root)
            }
        }

        shoeListFragmentBinding.createNewShoe.setOnClickListener { fab ->
            fab.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        setHasOptionsMenu(true)

        return shoeListFragmentBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.listview_optionsmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logoutMenuButton) {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}