package ru.tineat.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tineat.Product
import ru.tineat.User

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ""

    }
    val text: LiveData<String> = _text
    var user1: User = User("Имя","Адрес","88")
    var indexx:Int=0
    private var ListOfProducts= mutableListOf<Product>()
}