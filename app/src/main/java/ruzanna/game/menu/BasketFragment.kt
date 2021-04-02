package ruzanna.game.menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BasketFragment: Fragment() {
    private val adapter = BasketAdapter()
    lateinit var basketList: MutableList<FoodInBasket>
    lateinit var listener: BasketFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basket_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuRecyclerView = view.findViewById<RecyclerView>(R.id.content_recyclerView)
        adapter.basketList = basketList
        menuRecyclerView.adapter = adapter
        menuRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
        adapter.listener = object : BasketAdapter.BasketAdapterItemClickListener{
            override fun onBasketAdapterItemClickListener(foodInBasket: FoodInBasket)  {
                listener.onBasketFragmentItemClickListener(foodInBasket)
            }
        }
    }

    fun notifyDataChanged() {
        adapter.notifyDataSetChanged()
    }

    interface BasketFragmentListener{
        fun onBasketFragmentItemClickListener(foodInBasket: FoodInBasket)
    }
}