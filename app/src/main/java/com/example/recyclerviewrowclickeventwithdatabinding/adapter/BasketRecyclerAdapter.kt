package com.example.recyclerviewrowclickeventwithdatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewrowclickeventwithdatabinding.R
import com.example.recyclerviewrowclickeventwithdatabinding.databinding.RecyclerRowBinding
import com.example.recyclerviewrowclickeventwithdatabinding.model.Order

class BasketRecyclerAdapter(
    private val basketList: ArrayList<Order>,
    private val orderListener: OrderClickListener
): RecyclerView.Adapter<BasketRecyclerAdapter.OrderVH>() {

    class OrderVH(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentOrder: Order, listener : OrderClickListener){
            binding.order  = currentOrder
            binding.orderListener = listener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderVH {

        val inflater= LayoutInflater.from(parent.context)
        val view= DataBindingUtil.inflate<RecyclerRowBinding>(inflater, R.layout.recycler_row,parent,false)
        return OrderVH(view)
    }

    override fun onBindViewHolder(holder: OrderVH, position: Int) {
        holder.bind(basketList.get(position),orderListener)
    }

    override fun getItemCount(): Int {
        return basketList.size
    }
    fun basketProductsUpdate(newBasketProducts:ArrayList<Order>){
        basketList.clear()
        basketList.addAll(newBasketProducts)
        notifyDataSetChanged()
    }
}



