package com.enoca.tmdb.navigation

import kotlinx.serialization.Serializable

// Define a home destination that doesn't take any arguments
@Serializable
data object Home

// Define a profile destination that takes an ID
@Serializable
data class Profile(val id: String, val name: String)

@Serializable
object Login

@Serializable
object Register

@Serializable
object Products

@Serializable
object UserGivenOffers


@Serializable
data class ResetPassword(val email: String)

@Serializable
object ForgetPassword

@Serializable
object CreateProduct

@Serializable
object MyReceivedOffers

@Serializable
object MyProducts {
    var userId: String = ""
}

@Serializable
data class SearchProduct(val query: String)

@Serializable
data class ProductDetails(val product: String)

@Serializable
object UserLastOffers

@Serializable
object ProductImageUpload {
    var productId: String = ""
    var isFromEdit: Boolean = false
}

@Serializable
object EditProduct {
    var productId: String = ""
}

@Serializable
data object Step1

@Serializable
data object Step2 {
    var draftProductId:Int?=null
}

@Serializable
data object Step3

@Serializable
data object Settings

@Serializable
data object EditProductStep1

@Serializable
data object EditProductStep2

@Serializable
data object EditProductStep3

@Serializable
data object FilterProducts
/*
val UsersProductsType = object : NavType<UsersProducts>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): UsersProducts? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, UsersProducts::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): UsersProducts {
        return Json.decodeFromString<UsersProducts>(value)
    }

    override fun serializeAsValue(value: UsersProducts): String {
        return Json.encodeToString(value)
    }

    override fun put(bundle: Bundle, key: String, value: UsersProducts) {
        bundle.putParcelable(key, value)
    }
}*/
