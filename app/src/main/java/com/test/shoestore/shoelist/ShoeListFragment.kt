package com.test.shoestore.shoelist

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
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
            Log.i(TAG, "onCreateView - shoesList size: ${shoesList.size}")
            shoeListFragmentBinding.shoesList.removeAllViews()
            shoesList.forEach {
                val shoeItem: SingleShoeItemBinding = DataBindingUtil.inflate(inflater, R.layout.single_shoe_item, container, false)
                shoeItem.shoe = it
                // If the images list has more than one image
                // we set a random image to be the top,
                // otherwise we set the default to the only photo on the list
                val shoeImage = when (if (it.images.size > 1) Random.nextInt(1, it.images.size) else it.images[0].toInt()) {
                    2 -> R.drawable.shoe_2
                    3 -> R.drawable.shoe_3
                    4 -> R.drawable.shoe_4
                    5 -> R.drawable.shoe_5
                    6 -> R.drawable.shoe_6
                    else -> R.drawable.shoe_1
                }
                Log.i(TAG, "onCreateView - shoeImage $shoeImage")

                shoeItem.ssiShoeImage.setImageResource(shoeImage)
                shoeListFragmentBinding.shoesList.addView(shoeItem.root)
            }
        }

        val testShoe = Shoe("Air max", 42.0, "Nike", "Blue shoe with air technology, good for running", mutableListOf("1","3","5"))



        // The random shoe images were downloaded from pexels.com
        shoeListFragmentBinding.createNewShoe.setOnClickListener { fab ->
            shoeListViewModel.insertNewShoe(testShoe)
        }

        return shoeListFragmentBinding.root
    }
}