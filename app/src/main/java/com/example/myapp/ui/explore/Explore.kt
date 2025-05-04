package com.example.myapp.ui.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.data.model.City
import com.example.myapp.data.model.Trip
import com.example.myapp.ui.component.CityCard
import com.example.myapp.ui.component.TripCard
import com.example.myapp.viewmodel.ExploreViewModel


@Composable
fun ExploreScreen(navController: NavController) {
    val viewModel: ExploreViewModel = viewModel()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            HotTripsSection(viewModel, navController, onMoreClick = { navController.navigate("tmp_trips") })
            Spacer(modifier = Modifier.height(24.dp))
            CityExploreSection(viewModel, navController, onMoreClick = { navController.navigate("cities") })
        }
    }
}

@Composable
fun HotTripsSection(viewModel: ExploreViewModel, navController: NavController, onMoreClick: () -> Unit) {
    val hotTrips by viewModel.tmpTrips.collectAsState()
    ExploreTripsType(
        title = "參考行程",
        trips = hotTrips,
        navController = navController,
        onMoreClick = onMoreClick
    )
}

@Composable
fun CityExploreSection(viewModel: ExploreViewModel, navController: NavController, onMoreClick: () -> Unit) {
    val cities by viewModel.cities.collectAsState()
    ExploreCityType(
        title = "城市探索",
        cities = cities,
        navController = navController,
        onMoreClick = onMoreClick
    )
}

@Composable
fun ExploreTripsType(
    title: String,
    trips: List<Trip>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onMoreClick: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = title,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Black
        )

        val listState = rememberLazyListState()

        LazyRow(state = listState) {
            items(trips) { trip ->
                TripCard(trip = trip, navController = navController)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onMoreClick,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        ) {
            Text("more")
        }
    }
}

@Composable
fun ExploreCityType(
    title: String,
    cities: List<City>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onMoreClick: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = title,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Black
        )

        val listState = rememberLazyListState()

        LazyRow(state = listState) {
            items(cities) { city ->
                CityCard(city = city, navController = navController)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onMoreClick,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        ) {
            Text("more")
        }
    }
}