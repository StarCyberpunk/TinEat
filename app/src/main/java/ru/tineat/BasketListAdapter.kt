package ru.tineat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.tineat.databinding.ProductItemBinding

class BasketListAdapter: RecyclerView.Adapter<BasketListAdapter.productHolder>() {
    var productList= ArrayList<Product>()
    class productHolder(item: View) : RecyclerView.ViewHolder(item){

        val binging=ProductItemBinding.bind(item)
        fun bind(product: Product)=with(binging){
            textViewTovarName.text=product.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return productHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: productHolder, position: Int) {
        holder.bind(productList[position])
    }
    fun addList(product: Product){
        productList.add(product)
        notifyDataSetChanged()
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