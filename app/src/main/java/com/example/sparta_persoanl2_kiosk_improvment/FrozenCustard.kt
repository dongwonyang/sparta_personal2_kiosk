package com.example.sparta_persoanl2_kiosk_improvment

class FrozenCustard : Menu {
    override var lonNameLength = 0
    override val type: String = "FrozenCustard"

    constructor(){
        MenuDetailInfo.frozenCustardList.forEach{
            if(it.length > lonNameLength) lonNameLength = it.length
        }
    }

    override fun displayInfo() {
    }
}