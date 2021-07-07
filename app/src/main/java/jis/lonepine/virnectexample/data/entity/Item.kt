package jis.lonepine.virnectexample.data.entity

import android.os.Parcel
import android.os.Parcelable
import jis.lonepine.virnectexample.presentation.extension.addComma
import jis.lonepine.virnectexample.presentation.extension.removeHtml

data class Item(
    val brand: String,
    val category1: String,
    val category2: String,
    val category3: String,
    val category4: String,
    val hprice: String,
    val image: String,
    val link: String,
    val lprice: String,
    val maker: String,
    val mallName: String,
    val productId: String,
    val productType: String,
    val title: String
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString()) {
    }

    fun removeTagTitle() = title.removeHtml()
    fun addCommaLprice() = lprice.addComma()
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(category1)
        parcel.writeString(category2)
        parcel.writeString(category3)
        parcel.writeString(category4)
        parcel.writeString(hprice)
        parcel.writeString(image)
        parcel.writeString(link)
        parcel.writeString(lprice)
        parcel.writeString(maker)
        parcel.writeString(mallName)
        parcel.writeString(productId)
        parcel.writeString(productType)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}