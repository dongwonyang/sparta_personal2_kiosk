package com.example.sparta_persoanl2_kiosk_improvment

class Drink : Menu {
    override var lonNameLength = 0
    override val type: String = "Drink"

    constructor(){
        MenuDetailInfo.drinksList.forEach{
            if(it.length > lonNameLength) lonNameLength = it.length
        }
    }

    override fun displayInfo() {
    }
}