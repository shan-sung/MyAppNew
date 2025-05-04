package com.example.myapp.data.model

data class City(
    val imageResourceId: Int,
    val stringResourceId: Int
)

data class Trip(
    val id: String,
    val title: String,
    val startDate: String,
    val endDate: String,
    val days: Int,
    val members: List<String>
)
