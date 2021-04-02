package ruzanna.game.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MenuAdapter: RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    var foodList: MutableList<Food> = mutableListOf()
    lateinit var listener : MenuAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_menu, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.food = foodList[position]
        holder.itemView.setOnClickListener {
            listener.onItemClicked(foodList[position])
        }
        holder.itemView.findViewById<ImageView>(R.id.like).setOnClickListener{
            foodList[position].favored = !holder.food.favored
            if(holder.food.favored)
                holder.itemView.findViewById<ImageView>(R.id.like).setImageResource(R.drawable.baseline_favorite_black_24dp)
            else
                holder.itemView.findViewById<ImageView>(R.id.like).setImageResource(R.drawable.baseline_favorite_border_black_24dp)
        }
        holder.itemView.findViewById<ImageView>(R.id.add_to_basket).setOnClickListener{
            listener.onItemAddToBasketClicked(foodList[position])
            Toast.makeText(holder.itemView.context,"${holder.food.name} added to Basket",
                Toast.LENGTH_LONG).show()
        }
        holder.init()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var food: Food

        fun init() {
            itemView.apply {
                findViewById<TextView>(R.id.name).text = food.name
                findViewById<TextView>(R.id.restaurant_name).text = food.restaurant
                findViewById<TextView>(R.id.rating).text = food.rating.toString()
                findViewById<ImageView>(R.id.photo).setImageResource(food.photo)
                if(food.favored)
                    findViewById<ImageView>(R.id.like).setImageResource(R.drawable.baseline_favorite_black_24dp)
                else
                    findViewById<ImageView>(R.id.like).setImageResource(R.drawable.baseline_favorite_border_black_24dp)
            }
            itemView.invalidate()
        }
    }
    interface MenuAdapterListener{
        fun onItemClicked(food:Food)
        fun onItemAddToBasketClicked(food:Food)
    }
}
