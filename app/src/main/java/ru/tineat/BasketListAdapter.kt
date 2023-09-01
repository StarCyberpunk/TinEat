package ru.tineat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.tineat.databinding.FragmentNotificationsBinding

class BasketListAdapter: RecyclerView.Adapter<BasketListAdapter.ProductHolder>() {
    var data: List<Product> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }
    class ProductHolder(item: View) : RecyclerView.ViewHolder(item){
        fun bind(product: Product){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        TODO("Not yet implemented")
    }

    /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
         val inflater = LayoutInflater.from(parent.context)
         val binding = FragmentNotificationsBinding.inflate(inflater, parent, false)

         return ProductViewHolder(binding)
     }

     override fun getItemCount(): Int {
        return data.size
     }

     override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
         val person = data[position] // Получение человека из списка данных по позиции
         val context = holder.itemView.context


     }*/
}