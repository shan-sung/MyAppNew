package com.example.myapp.data.network

import com.example.myapp.data.model.Trip
//import retrofit2.http.Body
import retrofit2.http.GET
//import retrofit2.http.POST

interface ApiService {
    @GET("trips")
    suspend fun getTrip(): List<Trip>
}
