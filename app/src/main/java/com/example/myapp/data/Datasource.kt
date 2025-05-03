package com.example.myapp.data

import com.example.myapp.R
import com.example.myapp.data.model.Trip

object Datasource {

    fun loadHotTrips(): List<Trip> {
        return listOf(
            Trip(R.drawable.image1, R.string.trip_title1),
            Trip(R.drawable.image1, R.string.trip_title2),
            Trip(R.drawable.image1, R.string.trip_title3)
        )
    }

    fun loadCities(): List<Trip> {
        return listOf(
            Trip(R.drawable.image1, R.string.trip_title4),
            Trip(R.drawable.image1, R.string.trip_title5),
            Trip(R.drawable.image1, R.string.trip_title6)
        )
    }
}
