package ru.tineat

import android.location.Address

class User {
    constructor(Name: String, Address: String,Phone:String) {
        this.Name = Name
        this.Address = Address
        this.Basket= Basket()
        this.Phone=Phone
    }

    var Name:String
    var Address:String
    var Basket:Basket
    var Phone:String
}