package com.example.sparta_personal2_kiosk

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

//burger, frozen, drinks, chicken
fun main() {
    val printMenu = PrintMenu()
    var printMainBool = true
    var selectedMenuOption: Int = 0
    var selectedDetailedOption: Int = 0

    var optionList = listOf<Foods>(
        Burgers(),
        FrozenCustard(),
        Drinks(),
        Chicken()
    )

    var userInfo = UserInfo()

    val thread1 = thread{while (true) {
        if (printMainBool && selectedDetailedOption == 0) {
            println()
            printMenu.printMain()
            try {
                selectedMenuOption = readln()!!.split(' ').map(String::toInt)[0]
                if (selectedMenuOption in 0..optionList.size + 1) printMainBool = false
                else println("선택지 중 선택해 주세요.")

                if (selectedMenuOption == 0) break
            } catch (e: NumberFormatException) {
                println("선택지 중 선택해 주세요.")
            }
        } else if (selectedMenuOption <= optionList.size) {
            println()
            optionList[selectedMenuOption - 1].print()
            try {
                selectedDetailedOption = readln()!!.split(' ').map(String::toInt)[0]

                if (selectedDetailedOption == 0) printMainBool = true
                else if (selectedDetailedOption !in 0..(optionList[selectedMenuOption - 1].foodsNumberOfTypes)) println(
                    "선택지 중 선택해 주세요."
                ) else {
                    var list: List<String> = optionList[selectedMenuOption-1].menuList
                    userInfo.selectedMenu.add(list[selectedDetailedOption - 1])
                    println("${list[selectedDetailedOption - 1]} 추가 완료")
                }
            } catch (e: NumberFormatException) {
                println("선택지 중 선택해 주세요.")
            } catch (e: ArrayIndexOutOfBoundsException) {
                println("선택지 중 선택해 주세요.")
            }
        } else {
            printMainBool = timeLimit(8, 23)

            while (!printMainBool) {
                println()
                println("주문 가능 금액: ${userInfo.money}")
                printMenu.printSelectedMenu()
                try {
                    selectedDetailedOption = readln()!!.split(' ').map(String::toInt)[0]
                    if (selectedDetailedOption == 0) {
                        printMainBool = true
                        break
                    } else if (selectedDetailedOption !in 0..2) println("선택지 중 선택해 주세요.")
                } catch (e: NumberFormatException) {
                    println("선택지 중 선택해 주세요.")
                } catch (e: ArrayIndexOutOfBoundsException) {
                    println("선택지 중 선택해 주세요.")
                }

                if (selectedDetailedOption == 1) {
                    while (true) {
                        println("\n0 입력 시 뒤로가기")
                        println("현재 금액: ${userInfo.money}")
                        println("입금 금액")
                        var addMoney : Int = 0
                        try {
                            addMoney = readln()!!.split(' ').map(String::toInt)[0]
                            if (addMoney == 0) break
                            userInfo.addMoney(addMoney)
                        } catch (e: NumberFormatException) {
                            println("숫자를 입력해 주세요.")
                        }
                    }
                } else if (selectedDetailedOption == 2) {
                    userInfo.printSelectedMenu()
                    println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
                    println("0. 뒤로가기      | 뒤로가기")
                }
                var selectPayment : Int

                try {
                    selectPayment = readln()!!.split(' ').map(String::toInt)[0]
                } catch (e: NumberFormatException) {
                    selectPayment = 2
                    continue
                }
                while (selectPayment != 0) {
                    if (selectPayment == 1) {
                        if (userInfo.money < userInfo.totalPrice) {
                            println("결제 금액이 부족합니다.")
                            break
                        }
                        val currentTime = LocalTime.now()
                        println("현재 시간은 ${currentTime.hour}:${currentTime.minute}")
                        println("결제 완료. ${userInfo.money - userInfo.totalPrice}원을 반환합니다.")
                        selectedDetailedOption = 0
                        printMainBool = true
                        userInfo.reset()
                        break
                    } else {
                        println("선택지 중 입력해주세요.")
                        println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
                        println("0. 뒤로가기      | 뒤로가기")
                        try {
                            selectPayment = readln()!!.split(' ').map(String::toInt)[0]
                        } catch (e: NumberFormatException) {
                            selectPayment = 2
                            continue
                        }
                    }
                }
            }
        }
    }}

    thread {
        while(thread1.isAlive()){
            println("주문 대기 수는 5입니다.")
            Thread.sleep(5000)
        }
    }
}

fun timeLimit(start: Int, end:Int): Boolean {
    val currentTime = LocalTime.now()
    val startTime = LocalTime.of(start, 0)
    val endTime = LocalTime.of(end, 0)
    if (!(currentTime.isAfter(startTime) && currentTime.isBefore(endTime))) {
        println("현재 시간은 ${currentTime.hour}:${currentTime.minute}이며 ${startTime}-${endTime}에만 계산이 가능합니다.")
        return true
    }
    return false
}


//val thread1 = thread { while (!printMainBool) {
//    println()
//    println("주문 가능 금액: ${userInfo.money}")
//    printMenu.printSelectedMenu()
//    try {
//        selectedDetailedOption = readln()!!.split(' ').map(String::toInt)[0]
//        if (selectedDetailedOption == 0) {
//            printMainBool = true
//            break
//        } else if (selectedDetailedOption !in 0..2) println("선택지 중 선택해 주세요.")
//    } catch (e: NumberFormatException) {
//        println("선택지 중 선택해 주세요.")
//    } catch (e: ArrayIndexOutOfBoundsException) {
//        println("선택지 중 선택해 주세요.")
//    }
//
//    if (selectedDetailedOption == 1) {
//        while (true) {
//            println("\n0 입력 시 뒤로가기")
//            println("현재 금액: ${userInfo.money}")
//            println("입금 금액")
//            var addMoney : Int = 0
//            try {
//                addMoney = readln()!!.split(' ').map(String::toInt)[0]
//                if (addMoney == 0) break
//                userInfo.addMoney(addMoney)
//            } catch (e: NumberFormatException) {
//                println("숫자를 입력해 주세요.")
//            }
//        }
//    } else if (selectedDetailedOption == 2) {
//        userInfo.printSelectedMenu()
//        println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
//        println("0. 뒤로가기      | 뒤로가기")
//    }
//    var selectPayment : Int
//
//    try {
//        selectPayment = readln()!!.split(' ').map(String::toInt)[0]
//    } catch (e: NumberFormatException) {
//        selectPayment = 2
//        continue
//    }
//    while (selectPayment != 0) {
//        if (selectPayment == 1) {
//            if (userInfo.money < userInfo.totalPrice) {
//                println("결제 금액이 부족합니다.")
//                break
//            }
//            println("결제 완료. ${userInfo.money - userInfo.totalPrice}원을 반환합니다.")
//            selectedDetailedOption = 0
//            printMainBool = true
//            userInfo.reset()
//            break
//        } else {
//            println("선택지 중 입력해주세요.")
//            println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
//            println("0. 뒤로가기      | 뒤로가기")
//            try {
//                selectPayment = readln()!!.split(' ').map(String::toInt)[0]
//            } catch (e: NumberFormatException) {
//                selectPayment = 2
//                continue
//            }
//        }
//    }
//} }
//val thread2 = thread {
//    while (!printMainBool){
//        println("주문 대기인원은 5입니다.")
//        Thread.sleep(5000)
//    }
//}


//while (!printMainBool) {
//    println()
//    println("주문 가능 금액: ${userInfo.money}")
//    printMenu.printSelectedMenu()
//    try {
//        selectedDetailedOption = readln()!!.split(' ').map(String::toInt)[0]
//        if (selectedDetailedOption == 0) {
//            printMainBool = true
//            break
//        } else if (selectedDetailedOption !in 0..2) println("선택지 중 선택해 주세요.")
//    } catch (e: NumberFormatException) {
//        println("선택지 중 선택해 주세요.")
//    } catch (e: ArrayIndexOutOfBoundsException) {
//        println("선택지 중 선택해 주세요.")
//    }
//
//    if (selectedDetailedOption == 1) {
//        while (true) {
//            println("\n0 입력 시 뒤로가기")
//            println("현재 금액: ${userInfo.money}")
//            println("입금 금액")
//            var addMoney : Int = 0
//            try {
//                addMoney = readln()!!.split(' ').map(String::toInt)[0]
//                if (addMoney == 0) break
//                userInfo.addMoney(addMoney)
//            } catch (e: NumberFormatException) {
//                println("숫자를 입력해 주세요.")
//            }
//        }
//    } else if (selectedDetailedOption == 2) {
//        userInfo.printSelectedMenu()
//        println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
//        println("0. 뒤로가기      | 뒤로가기")
//    }
//    var selectPayment : Int
//
//    try {
//        selectPayment = readln()!!.split(' ').map(String::toInt)[0]
//    } catch (e: NumberFormatException) {
//        selectPayment = 2
//        continue
//    }
//    while (selectPayment != 0) {
//        if (selectPayment == 1) {
//            if (userInfo.money < userInfo.totalPrice) {
//                println("결제 금액이 부족합니다.")
//                break
//            }
//            println("결제 완료. ${userInfo.money - userInfo.totalPrice}원을 반환합니다.")
//            selectedDetailedOption = 0
//            printMainBool = true
//            userInfo.reset()
//            break
//        } else {
//            println("선택지 중 입력해주세요.")
//            println("1. 결제 완료하기  | 남은 돈은 반환됩니다.")
//            println("0. 뒤로가기      | 뒤로가기")
//            try {
//                selectPayment = readln()!!.split(' ').map(String::toInt)[0]
//            } catch (e: NumberFormatException) {
//                selectPayment = 2
//                continue
//            }
//        }
//    }
//}