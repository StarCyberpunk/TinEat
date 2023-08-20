package ru.tineat.ui.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.tineat.Product
import ru.tineat.User
import ru.tineat.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var User1: User = User("Имя","Адрес","88")
    var Next:Boolean=false
    var Indexx:Int=0
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var ListOfProducts= mutableListOf<Product>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Create list of Product'
        var pr: Product = Product("Яблоки","apple.jpg","100р/кг")
        var pr2: Product = Product("Яблоки2","apple.jpg","500р/кг")
        var pr3: Product = Product("Яблоки3","apple.jpg","1000р/кг")
        ListOfProducts.add(pr)
        ListOfProducts.add(pr2)
        ListOfProducts.add(pr3)
        binding.NoMainBut.setOnClickListener{SwapeNo_func()}
        binding.YesMainBut.setOnClickListener { SwapeYes_func() }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun SwapeNo_func() {
        ShowNext()
    }

    fun  ShowNext(){
        if(Indexx>=ListOfProducts.count()) Indexx=0
        binding.textViewProduct.text= ListOfProducts[Indexx].Name
        Indexx+=1
        /*binding.imageOfProduct.setImageDrawable(Drawable.createFromPath("../../../../res/drawable/"+ListOfProducts[Indexx].Img));*/
            //хз как добавить id фотки пока что binding.imageOfProduct.setImageResource()
    }

    fun SwapeYes_func() {
        //User1.BasketFragment.Products.add(ListOfProducts[Indexx])
        ShowNext()
    }
}
