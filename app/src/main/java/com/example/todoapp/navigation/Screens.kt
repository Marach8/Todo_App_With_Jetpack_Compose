package com.example.todoapp.navigation

const val DETAIL_PARAM = "id"
const val NUMBER_PARAM = "number"

const val AUTH_ROUTE = "authentication_route"
const val HOME_ROUTE = "home_route"
const val ROOT_ROUTE = "root"


sealed class Screens(val route: String) {
    data object Home: Screens(route = "home_nav")
    data object Detail: Screens(route = "detail_nav/{$DETAIL_PARAM}/{$NUMBER_PARAM}"){
        fun passId(id: String): String = "detail_nav?id=$id"
//        fun passId(id: String): String = this.route.replace(
//            oldValue = "{$DETAIL_PARAM}",
//            newValue = id
//        )
        fun passIdAndNo(id: String, number: Int): String = "detail_nav/$id/$number"
    }
    data object SignIn: Screens(route = "sign_in")
    data object SignUp: Screens(route = "sign_up")
}


//"detail_nav?id={id}"

//data object Detail: Screens(route = "detail_nav/{$DETAIL_PARAM}/{$NUMBER_PARAM}") {
//    fun passIdAndNo(id: String, number: Int): String = "detail_nav/$id/$number"
//}