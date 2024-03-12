package com.example.sparta_personal2_kiosk

class Chicken : Foods {
    override val menuList = listOf<String>(
        "Hot Chicken",
        "Chicken Shack",
        "Chicken's Bites 6-count",
        "Chicken's Bites 10-count"
    )
    companion object {
        val chickenList = listOf<String>(
            "Hot Chicken",
            "Chicken Shack",
            "Chicken's Bites 6-count",
            "Chicken's Bites 10-count"
        )
        val chickenPrice = mapOf<String, Double>(
            "Hot Chicken" to 9.5,
            "Chicken Shack" to 8.0,
            "Chicken's Bites 6-count" to 5.9,
            "Chicken's Bites 10-count" to 8.2
        )

        val chickenDescription = mapOf<String, String>(
            "Hot Chicken" to "바삭하고 두툼한 치킨 통살과 스파이시 슬로, 핫 스파이시 시즈닝이 토핑된 치킨 버거 (닭가슴살/닭다리살 선택 가능)",
            "Chicken Shack" to "바삭하고 두툼한 치킨 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨 버거 (닭가슴살/닭다리살 선택 가능)",
            "Chicken's Bites 6-count" to "한 입에 먹기 좋은 바삭한 치킨 바이트와 허니 머스터드 또는 BBQ 소스를 선택하여 함께 즐기는 메뉴",
            "Chicken's Bites 10-count" to "한 입에 먹기 좋은 바삭한 치킨 바이트와 허니 머스터드 또는 BBQ 소스를 선택하여 함께 즐기는 메뉴"
        )
    }

    override var longNameLength = 0
    override var foodsNumberOfTypes = 0
    override val type = "Chicken"

    init {
        foodsNumberOfTypes = menuList.size
        menuList.forEach { it ->
            if (longNameLength < it.length) longNameLength = it.length
        }
    }
    override fun print() {
        println("[ Chicken MENU ]")
        menuList.forEachIndexed { index, burger ->
            var printchicken = "${index + 1}. $burger"

            while(printchicken.length <= longNameLength+3) printchicken += " "
            println("${printchicken}| W ${chickenPrice[burger]} | ${chickenDescription[burger]}")
        }
        println("0. 뒤로가기      | 뒤로가기")
    }
}