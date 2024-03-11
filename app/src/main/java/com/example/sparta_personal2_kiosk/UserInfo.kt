package com.example.sparta_personal2_kiosk

import kotlin.concurrent.thread

class UserInfo {
    var money = 0
    val selectedMenu = mutableListOf<String>()
    var burgersPrice = 0
    var drinksPrice = 0
    var frozenCustardPrice = 0
    var chickenPrice = 0
    var totalPrice = 0

    fun reset(){
        money = 0
        selectedMenu.clear()
        burgersPrice = 0
        drinksPrice = 0
        frozenCustardPrice = 0
        chickenPrice = 0
        totalPrice = 0
    }

    fun addMoney(money: Int) {
        this.money += money
    }

    fun printSelectedMenu() {
        val selectedBurgers = selectedMenu.filter { it -> Burgers.burgersList.contains(it) }
        val selectedDrinks = selectedMenu.filter { it -> Drinks.drinksList.contains(it) }
        val selectedFrozenCustard =
            selectedMenu.filter { it -> FrozenCustard.frozenCustardList.contains(it) }
        val selectedChicken = selectedMenu.filter { it -> Chicken.chickenList.contains(it) }

        burgersPrice = 0
        drinksPrice = 0
        frozenCustardPrice = 0
        chickenPrice = 0

        if(selectedBurgers.isNotEmpty()) {
            println("[선택한 버거]")
            selectedBurgers.forEach {
                println("$it: ${Burgers.burgersPrice[it]}")
                Burgers.burgersPrice[it]?.let { it ->
                    burgersPrice += (it * 1000).toInt()
                } ?: throw java.lang.Exception("가격 접근 오류")
            }
            println("버거 가격: $burgersPrice\n")
        }
        if(selectedDrinks.isNotEmpty()) {
            println("[선택한 음료]")
            selectedDrinks.forEach {
                println("$it: ${Drinks.drinksPrice[it]}")
                Drinks.drinksPrice[it]?.let { it ->
                    drinksPrice += (it * 1000).toInt()
                } ?: throw java.lang.Exception("가격 접근 오류")
            }
            println("음료 가격: $drinksPrice\n")
        }
        if(selectedFrozenCustard.isNotEmpty()) {
            println("[선택한 아이스크림]")
            selectedFrozenCustard.forEach {
                println("$it: ${FrozenCustard.frozenCustardPrice[it]}")
                FrozenCustard.frozenCustardPrice[it]?.let { it ->
                    frozenCustardPrice += (it * 1000).toInt()
                } ?: throw java.lang.Exception("가격 접근 오류")
            }
            println("아이스크림 가격: ${frozenCustardPrice}\n")
        }
        if(selectedChicken.isNotEmpty()) {
            println("[선택한 치킨]")
            selectedChicken.forEach {
                println("$it: ${Chicken.chickenPrice[it]}")
                Chicken.chickenPrice[it]?.let { it ->
                    chickenPrice += (it * 1000).toInt()
                } ?: throw java.lang.Exception("가격 접근 오류")
            }
            println("치킨 가격: ${chickenPrice}\n")
        }

        totalPrice = burgersPrice + drinksPrice + frozenCustardPrice + chickenPrice
        println("가격 총합: ${totalPrice}")
        println("사용 가능 금액: ${money}")
    }


}