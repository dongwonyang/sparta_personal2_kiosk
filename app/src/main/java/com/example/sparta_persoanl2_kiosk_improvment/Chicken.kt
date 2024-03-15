package com.example.sparta_persoanl2_kiosk_improvment

class Chicken : Menu {
    override var lonNameLength = 0
    override val type: String = "Chicken"

    constructor(){
        MenuDetailInfo.chickenList.forEach{
            if(it.length > lonNameLength) lonNameLength = it.length
        }
    }

    override fun displayInfo() {
    }
}