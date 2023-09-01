package ru.tineat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.request.CachePolicy
import coil.request.ImageRequest
import ru.tineat.Product
import ru.tineat.R
import ru.tineat.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    // This property is only valid between onCreateView and
    // onDestroyView.

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.NoMainBut.setOnClickListener { viewModel.onNoClicked() }
        binding.YesMainBut.setOnClickListener { viewModel.onYesClicked() }

        viewModel.onStart()

        viewModel.apply {
            currentProductLiveData.observe(viewLifecycleOwner, ::handleProduct)
        }

        return binding.root
    }

    private fun handleProduct(product: Product?) {
        binding.textViewProduct.text = product?.name
        binding.imageOfProduct.loadImage(product?.img ?: "")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        val User = viewModel.userLiveData.value
        // Здесь мы можем использовать Kotlin экстеншен функцию из fragment-ktx
        setFragmentResult("requestKey", bundleOf("bundleKey" to User))
    }
    
}

fun ImageView.loadImage(
    data: Any,
    isUsePlaceholder: Boolean = true,
    @DrawableRes
    placeholder: Int? = null,
    builder: ((ImageRequest.Builder) -> Unit)? = null
) {
    if (data is Int) {
        setImageResource(data)
    } else {
        load(data) {
            if (isUsePlaceholder) placeholder(placeholder ?: R.drawable.apple)
            error(R.drawable.ic_cart)
            scaleType = ImageView.ScaleType.FIT_XY
            crossfade(true)
            memoryCachePolicy(CachePolicy.ENABLED)
            diskCachePolicy(CachePolicy.ENABLED)
            builder?.invoke(this)
        }
    }
}
