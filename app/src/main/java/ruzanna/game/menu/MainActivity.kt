package ruzanna.game.menu

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MenuFragment.MenuFragmentListener,
    CreateFoodFragment.CreateFoodFragmentListener, BasketFragment.BasketFragmentListener,
    BasketItemDeleteFragment.BasketItemDeleteListener {
    private val menuFragment = MenuFragment()
    private val createFoodFragment = CreateFoodFragment()
    private val basketList = mutableMapOf<Food, Int>()
    lateinit var basketItemsList: MutableList<FoodInBasket>
    lateinit var basketItemDeleteFragment: BasketItemDeleteFragment
    lateinit var basketFragment: BasketFragment
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menuFragment.listener = this
        supportFragmentManager.beginTransaction().add(R.id.container, menuFragment).commit()
    }

    override fun onMenuFragmentAddClicked() {
        createFoodFragment.listener = this
        createFoodFragment.show(supportFragmentManager, "CreateFoodFragment")
    }

    override fun onMenuFragmentBasketClicked() {
        basketFragment = BasketFragment()
        basketItemsList = basketList.toListFoodInBasket()
        basketFragment.basketList =  basketItemsList
        basketFragment.listener = this
        supportFragmentManager.beginTransaction().addToBackStack("MenuFragment")
            .replace(R.id.container, basketFragment).commit()
    }

    override fun onItemFoodAddToBasketClicked(food: Food) {
        if(basketList.contains(food)) {
            basketList[food] = basketList[food]!! + 1
        }else basketList[food] = 1
    }

    override fun onItemFoodForInfoClicked(food: Food) {
        supportFragmentManager.beginTransaction().addToBackStack("MenuFragment")
            .replace(R.id.container, FoodInfoFragment(food)).commit()
    }

    override fun onCreateFoodFragmentAdd(food: Food) {
        createFoodFragment.dismiss()
        menuFragment.updateListView(food)
    }

    override fun onBasketFragmentItemClickListener(foodInBasket: FoodInBasket) {
        basketItemDeleteFragment = BasketItemDeleteFragment()
        basketItemDeleteFragment.listener = this
        basketItemDeleteFragment.foodInBasket = foodInBasket
        basketItemDeleteFragment.show(supportFragmentManager, "BasketItemDeleteFragment")
    }

    override fun onDeleteListener(b: Boolean, foodInBasket: FoodInBasket) {
        basketItemDeleteFragment.dismiss()
        if (b){
            basketItemsList.remove(foodInBasket)
        }
        basketFragment.notifyDataChanged()
    }
}

private fun MutableMap<Food, Int>.toListFoodInBasket(): MutableList<FoodInBasket> {
    val basketList: MutableList<FoodInBasket> = mutableListOf()
    for (i in this.entries) {
        basketList.add(FoodInBasket(i.value, i.key))
    }
    return basketList
}
