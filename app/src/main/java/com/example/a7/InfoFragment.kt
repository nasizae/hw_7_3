package com.example.a7

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.a7.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var dataFromCarFragment: Car
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataFromCarFragment=arguments?.getSerializable("key") as Car
        binding.apply {
            tvName.text=dataFromCarFragment.name
            Glide.with(imgCar).load(dataFromCarFragment.image).into(imgCar)
            tvYear.text=dataFromCarFragment.year.toString()
        }
    }
}