package com.example.myapp.data.model

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class City(
    val id: String,
    val imageResourceId: Int,
    val stringResourceId: Int
)

data class Trip(
    val id: String,
    val name: String,
    val members: List<String>,
    val budget: Int,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val note: String,
    val dailyPlans: List<DayPlan>
) {
    val days: Long
        get() = ChronoUnit.DAYS.between(startDate, endDate) + 1
}

data class Location(
    val id: String,
    val title: String,
    val imageResId: Int,
    val stringResourceId: Int,
    val details: String,
    val cityId: String
)

data class DayPlan(
    val day: Int,
    val attractions: List<AttractionPlan>
)

data class AttractionPlan(
    val time: String,
    val name: String,
    val type: String
)

data class User(
    val name: String = "",
    val email: String = "",
    val gender: String = "",
    val birthday: LocalDate,
    val mbti: String = "",
    val avatarUrl: String = ""
)

data class Friend(
    val id: String,
    val name: String,
    val avatarUrl: String
)
