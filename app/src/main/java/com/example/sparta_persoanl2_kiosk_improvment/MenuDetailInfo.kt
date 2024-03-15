package com.example.sparta_persoanl2_kiosk_improvment

object MenuDetailInfo {
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