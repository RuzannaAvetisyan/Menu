package ruzanna.game.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_food_creat.*



class CreateFoodFragment: DialogFragment() {
    lateinit var listener: CreateFoodFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_creat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add.setOnClickListener {
            val food = Food(
                food_name.text.toString(),
                restaurant_name.text.toString(),
                rating.text.toString().toFloat(),
                false, R.drawable.b7e99d7c5059770698aa9218bb82297b
            )
            listener.onCreateFoodFragmentAdd(food)
        }
    }

    interface CreateFoodFragmentListener{
        fun onCreateFoodFragmentAdd(food:Food)
    }
}
