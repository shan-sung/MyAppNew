package com.example.myapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.data.Datasource
import com.example.myapp.data.model.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AttrModel : ViewModel() {

    private val _attr = MutableStateFlow<List<Location>>(emptyList())
    val attr: StateFlow<List<Location>> = _attr

    init {
        _attr.value = Datasource.loadAttr()
    }
}