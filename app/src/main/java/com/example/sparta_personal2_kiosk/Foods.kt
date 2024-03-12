package com.example.sparta_personal2_kiosk

interface Foods {
    var longNameLength : Int
    var foodsNumberOfTypes : Int
    val menuList : List<String>
    val type : String
    fun print(){}
}