package ruzanna.game.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    var basketList: MutableList<FoodInBasket> = mutableListOf()
    lateinit var listener : BasketAdapterItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_basket, parent,false)
        return BasketAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    override fun onBindViewHolder(holder: BasketAdapter.ViewHolder, position: Int) {
        holder.foodInBasket = basketList[position]
        holder.itemView.setOnLongClickListener {
            listener.onBasketAdapterItemClickListener(basketList[position])
            true
        }
        holder.init()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var foodInBasket: FoodInBasket
        fun init() {
            itemView.apply {
                if(foodInBasket.food != null){
                    findViewById<TextView>(R.id.food_name).text = foodInBasket.food!!.name
                    findViewById<TextView>(R.id.restaurant_name).text = foodInBasket.food!!.restaurant
                    findViewById<TextView>(R.id.qty).text = foodInBasket.quantity.toString()}
            }
            itemView.invalidate()
        }
    }

    interface BasketAdapterItemClickListener{
        fun onBasketAdapterItemClickListener(foodInBasket: FoodInBasket)
    }

}