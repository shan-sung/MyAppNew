package com.example.myapp.data

import com.example.myapp.R
import com.example.myapp.data.model.Trip
import com.example.myapp.data.model.City

object Datasource {

    fun loadHotTrips(): List<Trip> {
        return listOf(
            Trip(
                id = "1",
                title = "高雄探索之旅",
                startDate = "2025-05-01",
                endDate = "2025-05-03",
                days = 3,
                members = listOf("Gary", "Henry")
            ),
            Trip(
                id = "2",
                title = "台南美食行",
                startDate = "2025-06-10",
                endDate = "2025-06-14",
                days = 5,
                members = listOf("Elle", "Frank")
            )
        )
    }

    fun loadCities(): List<City> {
        return listOf(
            City(R.drawable.image1, R.string.taipei),
            City(R.drawable.image1, R.string.new_taipei),
            City(R.drawable.image1, R.string.keelung),
            City(R.drawable.image1, R.string.taoyuan),
            City(R.drawable.image1, R.string.taichung),
            City(R.drawable.image1, R.string.tainan),
            City(R.drawable.image1, R.string.kaohsiung),
            City(R.drawable.image1, R.string.pingtung),
            City(R.drawable.image1, R.string.hsinchu),
            City(R.drawable.image1, R.string.yilan),
            City(R.drawable.image1, R.string.hualien),
            City(R.drawable.image1, R.string.chiayi),
            City(R.drawable.image1, R.string.taitung),
        )
    }

    fun loadTrip(): List<Trip> {
        return listOf(
            Trip(
                id = "3",
                title = "my台北探索之旅",
                startDate = "2025-05-01",
                endDate = "2025-05-03",
                days = 3,
                members = listOf("Alice", "Bob")
            ),
            Trip(
                id = "4",
                title = "my台中美食行",
                startDate = "2025-06-10",
                endDate = "2025-06-12",
                days = 3,
                members = listOf("Charlie", "David")
            )
        )
    }
}