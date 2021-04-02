package ruzanna.game.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_food_info.*

class FoodInfoFragment(val food: Food): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_info, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text = food.name
        restaurant_name.text = food.restaurant
        photo.setImageResource(food.photo)
        rating.text = food.rating.toString()
        food_description.text = """
            There are many fast foods and delivery services 
            in the city, but "Tumanyan Shaurma" fast food 
            chain offers you fully new opportunities (chances).
            Order right now: 011-81-88-88, 81-88
        """
    }
}