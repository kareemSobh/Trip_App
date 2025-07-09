package com.kareemsobh.tripapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kareemsobh.tripapp.Model.Place
import com.kareemsobh.tripapp.Model.Trip
import com.kareemsobh.tripapp.Repository.TripsRepository


class MainViewModel (
    private val repository:TripsRepository=TripsRepository()
):ViewModel(){
    val upcomingTrips:LiveData<List<Trip>> = repository.getUpcomingTrips()
    val recommededPlaces:LiveData<List<Place>> =repository.getRecommendedTrips()
}
