package com.example.sparta_personal2_kiosk

class Burgers : Foods {
    override val menuList = listOf<String>(
        "ShackBurger",
        "SmokeShack",
        "Shroom Burger",
        "Cheeseburger",
        "Hamburger"
    )
    companion object {
        val burgersList = listOf<String>(
            "ShackBurger",
            "SmokeShack",
            "Shroom Burger",
            "Cheeseburger",
            "Hamburger"
        )
        val burgersPrice = mapOf<String, Double>(
            "ShackBurger" to 6.9,
            "SmokeShack" to 8.9,
            "Shroom Burger" to 9.4,
            "Cheeseburger" to 6.9,
            "Hamburger" to 5.4
        )

        val burgersDescription = mapOf<String, String>(
            "ShackBurger" to "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "SmokeShack" to "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "Shroom Burger" to "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
            "Cheeseburger" to "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "Hamburger" to "비프패티를 기반으로 야채가 들어간 기본버거"
        )
    }
    override var longNameLength = 0
    override var foodsNumberOfTypes = 0

    init {
        foodsNumberOfTypes = menuList.size
        menuList.forEach { it ->
            if (longNameLength < it.length) longNameLength = it.length
        }
    }
    override fun print() {
        println("[ Burgers MENU ]")
        menuList.forEachIndexed { index, burger ->
            var printBurger = "${index + 1}. $burger"

            while(printBurger.length <= longNameLength+3) printBurger += " "
            println("${printBurger}| W ${burgersPrice[burger]} | ${burgersDescription[burger]}")
        }
        println("0. 뒤로가기      | 뒤로가기")
    }

}
