package com.example.recyclerviewrowclickeventwithdatabinding.data.repository

import com.example.recyclerviewrowclickeventwithdatabinding.model.Order

class OrderRepository {
  private  var orderData= listOf<Order>(Order(1,"Woman Perfume",1),Order(2,"Man Perfume",1))
    fun getFakeData(): List<Order> {
        return orderData
    }
    fun increaseQuantity(choseOrder:Order){
        orderData.forEach { order->
            if(order.id == choseOrder.id){
                order.quantity +=1
            }
        }

    }
    fun decreaseQuantity(choseOrder:Order){
        orderData.forEach { order->
            if(order.id == choseOrder.id){
                order.quantity -=1
            }
        }
    }
}