package com.patika.week3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.patika.week3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var counterView: TextView
    private var count = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counterView = binding.countNumber
        binding.increaseButton.setOnClickListener { increaseCount() }
        binding.decreaseButton.setOnClickListener { decreaseCount() }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.let {
            count = savedInstanceState.getInt(Key.COUNT_KEY,0)
        }
        showCount()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(Key.COUNT_KEY,count)
    }

    fun increaseCount(){
        count += 1
        showCount()
    }

    fun decreaseCount(){
        count -= 1
        showCount()
    }

    fun showCount(){
        counterView.text = count.toString()
    }




}