package ru.tineat.ui.Baskets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tineat.Basket
import ru.tineat.BasketListAdapter
import ru.tineat.Product
import ru.tineat.User
import ru.tineat.databinding.FragmentNotificationsBinding

class BasketFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    lateinit var listOfProduct: Basket
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter=BasketListAdapter()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
                ViewModelProvider(this).get(BasketViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Получение данных
        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getSerializable("bundleKey") as User
           // listOfProduct= result.getBasket()
            init(result.getBasket().products)
        }

        return root
    }
    private fun init(list:MutableList<Product>){
        binding.apply {
            ListProduct.layoutManager=GridLayoutManager(this@BasketFragment.context,1)
            ListProduct.adapter=adapter
            for(prod:Product in list){
                adapter.addList(prod)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}