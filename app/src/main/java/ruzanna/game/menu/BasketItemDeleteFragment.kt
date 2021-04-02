package ruzanna.game.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_basket_item_delete.*

class BasketItemDeleteFragment : DialogFragment(){
    lateinit var listener:BasketItemDeleteListener
    lateinit var foodInBasket: FoodInBasket

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basket_item_delete, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basket_item_text.text = "You want to remove ${foodInBasket.food?.name} ${foodInBasket.food?.restaurant} ${foodInBasket.quantity}"
        yes.setOnClickListener {
            listener.onDeleteListener(true, foodInBasket)
        }
        no.setOnClickListener {
            listener.onDeleteListener(false, foodInBasket)
        }
    }

    interface BasketItemDeleteListener{
        fun onDeleteListener(b: Boolean, foodInBasket: FoodInBasket)
    }

}