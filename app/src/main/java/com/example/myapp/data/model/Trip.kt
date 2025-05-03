package com.example.myapp.data.model

data class Trip(
    val imageResourceId: Int,
    val stringResourceId: Int
)

data class MyTrips(
    val title: String,
    val startDate: String,
    val endDate: String,
    val days: Int,
    val members: List<String>  // 成員姓名清單，例如 ["Alice", "Bob"]
)
