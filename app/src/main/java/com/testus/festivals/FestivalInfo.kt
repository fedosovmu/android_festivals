package com.testus.festivals

data class FestivalInfo(val name: String, val place: String, val price: String, val description: String, val status: Int) {

    class List : ArrayList<FestivalInfo>()
}