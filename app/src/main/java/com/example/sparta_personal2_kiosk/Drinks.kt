package com.example.sparta_personal2_kiosk

class Drinks : Foods{
    override val menuList = listOf<String>(
        "Lemonade Small",
        "Lemonade Large",
        "Fresh Brewed Iced Tea Small",
        "Fresh Brewed Iced Tea Large",
        "Fifty Small",
        "Fifty Large",
        "Fountain Soda Small",
        "Fountain Soda Large",
        "Abita Root Beer",
        "Hot Tea"
    )
    companion object {
        val drinksList = listOf<String>(
            "Lemonade Small",
            "Lemonade Large",
            "Fresh Brewed Iced Tea Small",
            "Fresh Brewed Iced Tea Large",
            "Fifty Small",
            "Fifty Large",
            "Fountain Soda Small",
            "Fountain Soda Large",
            "Abita Root Beer",
            "Hot Tea"
        )
        val drinksPrice = mapOf<String, Double>(
            "Lemonade Small" to 4.3,
            "Lemonade Large" to 5.0,
            "Fresh Brewed Iced Tea Small" to 3.5,
            "Fresh Brewed Iced Tea Large" to 4.2,
            "Fifty Small" to 3.8,
            "Fifty Large" to 4.5,
            "Fountain Soda Small" to 2.9,
            "Fountain Soda Large" to 3.6,
            "Abita Root Beer" to 4.8,
            "Hot Tea" to 3.4
        )

        val drinksDescription = mapOf<String, String>(
            "Lemonade Small" to "매장에서 직접 만드는 상큼한 레몬에이드",
            "Lemonade Large" to "매장에서 직접 만드는 상큼한 레몬에이드",
            "Fresh Brewed Iced Tea Small" to "직접 유기농 홍차를 우려낸 아이스 티",
            "Fresh Brewed Iced Tea Large" to "직접 유기농 홍차를 우려낸 아이스 티",
            "Fifty Small" to "레몬에이드와 유기농 홍차를 우려낸 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료",
            "Fifty Large" to "레몬에이드와 유기농 홍차를 우려낸 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료",
            "Fountain Soda Small" to "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플",
            "Fountain Soda Large" to "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플",
            "Abita Root Beer" to "청량감 있는 독특한 미국식 무알콜 탄산음료",
            "Hot Tea" to "보성 유기농 찻잎을 우려낸 녹차, 홍차, 페퍼민트 & 레몬그라스"
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
        println("[ Drinks MENU ]")
        menuList.forEachIndexed { index, burger ->
            var printdrinks = "${index + 1}. $burger"

            while(printdrinks.length <= longNameLength+3) printdrinks += " "
            println("${printdrinks}| W ${drinksPrice[burger]} | ${drinksDescription[burger]}")
        }
        println("0. 뒤로가기      | 뒤로가기")
    }
}