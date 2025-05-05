package com.example.myapp.ui.attraction

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.ui.component.AttractionCard
import com.example.myapp.ui.component.GridList
import com.example.myapp.viewmodel.AttrModel

@Composable
fun AttractionScreen(
    navController: NavController,
    cityId: String,
    viewModel: AttrModel = viewModel()
) {
    val attr by viewModel.attr.collectAsState()

    val filteredAttr = attr.filter { it.cityId == cityId }

    Scaffold { innerPadding ->
        GridList(
            items = filteredAttr,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) { attraction ->
            AttractionCard(attr = attraction, navController = navController)
        }
    }
}
