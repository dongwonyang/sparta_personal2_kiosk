package com.example.sparta_persoanl2_kiosk_improvment

class Burger : Menu {
    override var lonNameLength = 0
    override val type: String = "Burger"

    constructor(){
       MenuDetailInfo.burgersList.forEach{
            if(it.length > lonNameLength) lonNameLength = it.length
        }
    }

    override fun displayInfo() {
    }

}