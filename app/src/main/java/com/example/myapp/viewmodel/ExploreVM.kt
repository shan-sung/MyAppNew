package com.example.myapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.data.Datasource
import com.example.myapp.data.model.City
import com.example.myapp.data.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExploreViewModel : ViewModel() {

    private val _tmpTrips = MutableStateFlow<List<Trip>>(emptyList())
    val tmpTrips: StateFlow<List<Trip>> = _tmpTrips

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> = _cities

    init {
        _tmpTrips.value = Datasource.loadHotTrips()
        _cities.value = Datasource.loadCities()
    }
}