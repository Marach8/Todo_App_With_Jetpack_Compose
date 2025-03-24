package com.example.todoapp

const val DETAIL_PARAM = "id"
const val NUMBER_PARAM = "number"

sealed class ScreenNav(val route: String) {
    object Home: ScreenNav(route = "home_nav")
    object Detail: ScreenNav(route = "detail_nav/{$DETAIL_PARAM}/{$NUMBER_PARAM}"){
        //fun passId(id: String): String = "detail_nav/$id"
//        fun passId(id: String): String = this.route.replace(
//            oldValue = "{$DETAIL_PARAM}",
//            newValue = id
//        )
        fun passIdAndNo(id: String, number: Int): String = "detail_nav/$id/$number"
    }
}