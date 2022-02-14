package com.example.recyclerviewrowclickeventwithdatabinding.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewrowclickeventwithdatabinding.data.repository.OrderRepository
import com.example.recyclerviewrowclickeventwithdatabinding.model.Order

class BasketFragmentViewModel:ViewModel() {
    val repository: OrderRepository = OrderRepository()
    private val _orders: MutableLiveData<List<Order>> = MutableLiveData()
    val orders: LiveData<List<Order>>
        get() = _orders



    fun getFakeData() {
        _orders.value=repository.getFakeData()
    }
    fun increaseQuantity(choseOrder:Order){
            repository.increaseQuantity(choseOrder)
            _orders.value = repository.getFakeData()

    }
    fun decreaseQuantity(choseOrder:Order){
        repository.decreaseQuantity(choseOrder)
        _orders.value = repository.getFakeData()
    }
}