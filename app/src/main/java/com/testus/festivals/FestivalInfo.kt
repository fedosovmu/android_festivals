package com.testus.festivals

data class FestivalInfo(val name: String, val place: String) {

    class List : ArrayList<FestivalInfo>()
}