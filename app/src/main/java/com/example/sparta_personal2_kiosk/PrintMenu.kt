package com.example.sparta_personal2_kiosk

import java.nio.file.WatchKey

class PrintMenu {
    init {}

    fun printMain(){
        println("[ SHAKESHACK MENU ]")
        println("1. Burgers         | 앵거스 비프 통살을 다져 만든 버거")
        println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림")
        println("3. Drinks          | 매장에서 직접 만드는 음료")
        println("4. Chicken         | 쉐이크쉑만의 특별한 소스로 완성된 프리미엄 치킨 버거")
        println("5. Selected Menu   | 선택한 메뉴 결제")
        println("0. 종료            | 프로그램 종료")
    }

    fun printSelectedMenu(){
        println("[ SELECTED MENU ]")
        println("1. 돈 추가하기")
        println("2. 결제하기")
        println("0. 뒤로가기      | 뒤로가기")    }

    fun printBurgers(){
        Burgers().print()
    }

    fun printDrinks(){
        Drinks().print()
    }

    fun printFrozenCustard(){
        FrozenCustard().print()
    }

    fun printChicken(){
        Chicken().print()
    }


}