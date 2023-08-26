package ru.tineat

import java.io.Serializable


data class User(val name: String, val address: String, val phone: String) : Serializable{

    private val basket: Basket = Basket()

    fun addProduct(product: Product){
        basket.products.add(product)
    }
    fun getBasket():Basket{
        return basket
    }
}
