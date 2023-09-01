package ru.tineat.ui.home

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import ru.tineat.Product
import ru.tineat.User
import java.util.PriorityQueue
import java.util.Queue
import androidx.navigation.findNavController
import ru.tineat.MainActivity
import ru.tineat.R

class HomeViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<User>().apply { value = User("Имя", "Адрес", "88") }
    val userLiveData = _userLiveData as LiveData<User>

    private val _currentProductLiveData = MutableLiveData<Product?>()
    val currentProductLiveData = _currentProductLiveData as LiveData<Product?>

    private val productQueue = PriorityQueue<Product>(compareBy { it.name })

    fun onStart() {
        productQueue.addAll(mockedProductList)
        showNextProduct()
    }

    private fun showNextProduct() {
        _currentProductLiveData.value = productQueue.poll()
    }

    fun onNoClicked() {
        showNextProduct()
    }

    fun onYesClicked() {
        _currentProductLiveData.value?.let { product ->
            _userLiveData.value?.addProduct(product)
        }

        showNextProduct()
    }


    companion object {

        private val mockedProductList = listOf(
            Product(
                "Яблоки",
                "https://images.wallpaperscraft.ru/image/single/iabloko_iabloki_frukty_206767_1920x1080.jpg",
                "100р/кг"
            ),
            Product(
                "Яблоки2",
                "https://avatars.mds.yandex.net/i?id=0572fe08e3428781c3e2823019ad0c8a0322c548-10022398-images-thumbs&n=13",
                "500р/кг"
            ),
            Product(
                "Яблоки3",
                "https://w.forfun.com/fetch/2d/2d4f803bc427da9e94028ae97addedaf.jpeg",
                "1000р/кг"
            )
        )
    }
}