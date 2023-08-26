package ru.tineat.ui.Baskets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.tineat.User
import ru.tineat.databinding.FragmentNotificationsBinding

class BasketFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
                ViewModelProvider(this).get(BasketViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var user:User=savedInstanceState?.getSerializable("User") as User
        var listForBuy=user.getBasket().products
        binding.textView.text=listForBuy[0].name
        

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}