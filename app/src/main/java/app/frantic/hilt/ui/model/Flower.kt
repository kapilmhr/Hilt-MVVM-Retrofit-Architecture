package app.frantic.hilt.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Flower(
    var category: String? = "",

    var price: Double? = null,

    var instructions: String? = "",

    var photo: String? = null,

    var name: String? = null,

    var productId: Int? = null
) : Parcelable