package com.example.recyclerviewrowclickeventwithdatabinding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewrowclickeventwithdatabinding.R
import com.example.recyclerviewrowclickeventwithdatabinding.adapter.BasketRecyclerAdapter
import com.example.recyclerviewrowclickeventwithdatabinding.adapter.OrderClickListener
import com.example.recyclerviewrowclickeventwithdatabinding.databinding.FragmentMainBinding
import com.example.recyclerviewrowclickeventwithdatabinding.model.Order
import com.example.recyclerviewrowclickeventwithdatabinding.viewModel.BasketFragmentViewModel

class BasketFragment : Fragment(),OrderClickListener {
    override fun onPlusItemClicked(order: Order) {
        viewModel.increaseQuantity(order)

    }

    override fun onMinusItemClicked(order: Order) {
        viewModel.decreaseQuantity(order)
    }

    private  val basketRecyclerAdapter=BasketRecyclerAdapter(arrayListOf(),this)
    private val viewModel by viewModels<BasketFragmentViewModel>()
    private lateinit var dataBinding:FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        dataBinding.lifecycleOwner=this
       // dataBinding.quantity=viewModel.quantity
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFakeData()

        dataBinding.basketRecyclerView.layoutManager= LinearLayoutManager(context)
        dataBinding.basketRecyclerView.adapter=basketRecyclerAdapter

        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.orders.observe(viewLifecycleOwner, Observer {
            it?.let { orders ->
                basketRecyclerAdapter.basketProductsUpdate(ArrayList<Order>(orders))
            }
        })
    }



}