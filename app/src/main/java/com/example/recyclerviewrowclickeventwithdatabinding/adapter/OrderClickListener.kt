package com.example.recyclerviewrowclickeventwithdatabinding.adapter

import com.example.recyclerviewrowclickeventwithdatabinding.model.Order

interface OrderClickListener {
    fun  onPlusItemClicked(order: Order)
    fun  onMinusItemClicked(order: Order)
}