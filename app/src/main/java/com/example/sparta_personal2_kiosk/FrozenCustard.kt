package com.example.sparta_personal2_kiosk

class FrozenCustard : Foods {
    override val menuList = listOf<String>(
        "Classic Hand-Spun Shakes",
        "Float",
        "Cup & Cones Single",
        "Cup & Cones Double"
    )
    companion object {
        val frozenCustardList = listOf<String>(
            "Classic Hand-Spun Shakes",
            "Float",
            "Cup & Cones Single",
            "Cup & Cones Double"
            )
        val frozenCustardPrice = mapOf<String, Double>(
            "Classic Hand-Spun Shakes" to 6.5,
            "Float" to 6.5,
            "Cup & Cones Single" to 5.4,
            "Cup & Cones Double" to 6.5
        )

        val frozenCustardDescription = mapOf<String, String>(
            "Classic Hand-Spun Shakes" to "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크(바닐라/초콜릿/스트로베리/블랙 & 화이트/솔티드 카라멜/피넛 버터/커피)",
            "Float" to "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료(루트 비어/퍼플 카우/크림시클)",
            "Cup & Cones Single" to "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림 (바닐라/초콜릿)",
            "Cup & Cones Double" to "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림 (바닐라/초콜릿)"
        )
    }

    override var longNameLength = 0
    override var foodsNumberOfTypes = 0
    override val type = "FrozenCustard"

    init {
        foodsNumberOfTypes = menuList.size
        menuList.forEach { it ->
            if (longNameLength < it.length) longNameLength = it.length
        }
    }
    override fun print() {
        println("[ Frozen Custard MENU ]")
        menuList.forEachIndexed { index, burger ->
            var printfrozenCustard = "${index + 1}. $burger"

            while(printfrozenCustard.length <= longNameLength+3) printfrozenCustard += " "
            println("${printfrozenCustard}| W ${frozenCustardPrice[burger]} | ${frozenCustardDescription[burger]}")
        }
        println("0. 뒤로가기      | 뒤로가기")
    }
}