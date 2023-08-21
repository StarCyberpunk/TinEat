package ru.tineat


data class User(val name: String, val address: String, val phone: String){

    private val basket: Basket = Basket()

    fun addProduct(product: Product){
        basket.products.add(product)
    }
}