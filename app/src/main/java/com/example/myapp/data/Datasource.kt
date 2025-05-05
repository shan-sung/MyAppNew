package com.example.myapp.data

import com.example.myapp.R
import com.example.myapp.data.model.Trip
import com.example.myapp.data.model.City
import com.example.myapp.data.model.Location

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
            City("1", R.drawable.image1, R.string.taipei),
            City("2", R.drawable.image1, R.string.new_taipei),
            City("3", R.drawable.image1, R.string.keelung),
            City("4", R.drawable.image1, R.string.taoyuan),
            City("5", R.drawable.image1, R.string.taichung),
            City("6", R.drawable.image1, R.string.tainan),
            City("7", R.drawable.image1, R.string.kaohsiung),
            City("8", R.drawable.image1, R.string.pingtung),
            City("9", R.drawable.image1, R.string.hsinchu),
            City("10", R.drawable.image1, R.string.yilan),
            City("11", R.drawable.image1, R.string.hualien),
            City("12", R.drawable.image1, R.string.chiayi),
            City("13", R.drawable.image1, R.string.taitung),
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
    fun loadAttr(): List<Location> {
        return listOf(
            Location(
                id = "1",
                imageResId = R.drawable.image1,
                title = "attr1",
                details = "my warm day, good good, good",
                cityId = "1"
            ),
            Location(
                id = "2",
                imageResId = R.drawable.image1,
                title = "my台中美食行",
                details = "taichung good, yummy, yummy, yummy",
                cityId = "5"
            )
        )
    }
}