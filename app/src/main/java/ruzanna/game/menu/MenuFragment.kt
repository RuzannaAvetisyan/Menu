package ruzanna.game.menu

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_menu_list.*

class MenuFragment: Fragment() {
    private val adapter = MenuAdapter()
    private val foodList = getFoodList()
    lateinit var listener: MenuFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuRecyclerView = view.findViewById<RecyclerView>(R.id.content_recyclerView)
        adapter.foodList = foodList
        menuRecyclerView.adapter = adapter
        menuRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
        adapter.listener = object : MenuAdapter.MenuAdapterListener{
            override fun onItemClicked(food: Food) {
                listener.onItemFoodForInfoClicked(food)
            }

            override fun onItemAddToBasketClicked(food: Food) {
                listener.onItemFoodAddToBasketClicked(food)
            }

        }
        add.setOnClickListener{
            listener.onMenuFragmentAddClicked()
        }
        basket.setOnClickListener {
            listener.onMenuFragmentBasketClicked()
        }
    }

    fun updateListView(food: Food){
        foodList.add(food)
        adapter.notifyDataSetChanged()
    }

    fun updateListViewPhoto(bitmap: Bitmap){
        foodList[foodList.size - 1].photo2 = bitmap
        adapter.notifyDataSetChanged()
    }

    interface MenuFragmentListener {
        fun onMenuFragmentAddClicked()
        fun onMenuFragmentBasketClicked()
        fun onItemFoodAddToBasketClicked(food: Food)
        fun onItemFoodForInfoClicked(food: Food)
    }

}