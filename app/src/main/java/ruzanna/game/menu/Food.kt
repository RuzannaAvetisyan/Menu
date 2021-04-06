package ruzanna.game.menu

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable


data class Food(
    val name: String?,
    val restaurant: String?,
    val rating: Float,
    var favored: Boolean,
    val photo:Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(restaurant)
        parcel.writeFloat(rating)
        parcel.writeByte(if (favored) 1 else 0)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
    public var photo2: Bitmap? = null

}

fun getFoodList(): MutableList<Food>{
    val foodList = mutableListOf<Food>()
    foodList.add(Food("Shaurma", "Tumanyan Shaurma", 4.9f, false, R.drawable.dc41e25f838cb8cae24b253edb254e36))
    foodList.add(Food("Salad", "Tumanyan Shaurma", 4.5f, false, R.drawable.d97b364941c8c5a122f48ddcc6e1c7caf))
    foodList.add(Food("Xorovats", "Tumanyan Shaurma", 4.5f, false, R.drawable.d5425821e6ca518aff228215985386af6))
    foodList.add(Food("Burger", "Tumanyan Shaurma", 4.5f, false, R.drawable.d1d3e06b6133b70207f8140453ddc0179))
    foodList.add(Food("Qyabab", "Tumanyan Shaurma", 4.5f, false, R.drawable.b7e99d7c5059770698aa9218bb82297b))
    foodList.add(Food("Shaurma", "Tumanyan Shaurma", 4.9f, false, R.drawable.dc41e25f838cb8cae24b253edb254e36))
    foodList.add(Food("Salad", "Tumanyan Shaurma", 4.5f, false, R.drawable.d97b364941c8c5a122f48ddcc6e1c7caf))
    foodList.add(Food("Xorovats", "Tumanyan Shaurma", 4.5f, false, R.drawable.d5425821e6ca518aff228215985386af6))
    foodList.add(Food("Burger", "Tumanyan Shaurma", 4.5f, false, R.drawable.d1d3e06b6133b70207f8140453ddc0179))
    foodList.add(Food("Qyabab", "Tumanyan Shaurma", 4.5f, false, R.drawable.b7e99d7c5059770698aa9218bb82297b))
    return foodList
}
