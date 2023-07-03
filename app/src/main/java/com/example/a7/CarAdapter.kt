package com.example.a7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.a7.databinding.ItemCarsBinding

class CarAdapter(private var carList: ArrayList<Car>,val onItemClick:(position:Int)->Unit):
    RecyclerView.Adapter<CarAdapter.CarHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        return CarHolder(ItemCarsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount() =carList.size


    inner class CarHolder(private val binding: ItemCarsBinding):ViewHolder(binding.root) {
            fun bind(car:Car){
                binding.apply {
                    tvName.text=car.name
                    tvYear.text=car.year.toString()
                    Glide.with(imgCar).load(car.image).into(imgCar)
                }
                itemView.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }
    }
}