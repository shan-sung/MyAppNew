package com.example.myapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.data.Datasource
import com.example.myapp.data.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyTripsViewModel : ViewModel() {
    private val _myTrips = MutableStateFlow<List<Trip>>(emptyList())
    val myTrips: StateFlow<List<Trip>> = _myTrips

    init {
        _myTrips.value = Datasource.loadTrip()
    }
}
