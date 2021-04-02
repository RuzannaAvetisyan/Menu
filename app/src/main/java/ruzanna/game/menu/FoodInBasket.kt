package ruzanna.game.menu

import android.os.Parcel
import android.os.Parcelable

data class FoodInBasket(
    var quantity: Int,
    val food:Food?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readParcelable(Food::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(quantity)
        parcel.writeParcelable(food, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodInBasket> {
        override fun createFromParcel(parcel: Parcel): FoodInBasket {
            return FoodInBasket(parcel)
        }

        override fun newArray(size: Int): Array<FoodInBasket?> {
            return arrayOfNulls(size)
        }
    }

}