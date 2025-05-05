package com.example.myapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.data.model.City
import com.example.myapp.data.model.Location
import com.example.myapp.data.model.Trip

@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(180.dp)
            .padding(end = 8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            content()
        }
    }
}

@Composable
fun TripCard(trip: Trip, navController: NavController) {
    ClickableCard(
        onClick = { navController.navigate("tmp_trip_details/${trip.id}") }
    ) {
        Text(text = trip.name, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${trip.startDate} ~ ${trip.endDate}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun CityCard(city: City, navController: NavController) {
    ClickableCard(
        onClick = { navController.navigate("attractions/${city.id}") }
    ) {
        Image(
            painter = painterResource(city.imageResourceId),
            contentDescription = stringResource(city.stringResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = LocalContext.current.getString(city.stringResourceId),
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
@Composable
fun AttractionCard(attr: Location, navController: NavController) {
    ClickableCard(
        onClick = {
            navController.navigate("attraction_details/${attr.id}")
        }
    ) {
        Image(
            painter = painterResource(attr.imageResId),
            contentDescription = attr.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = attr.title,
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun <T> GridList(
    modifier: Modifier = Modifier,
    items: List<T>,
    columns: Int = 2,
    contentPadding: PaddingValues = PaddingValues(top = 16.dp, bottom = 80.dp),
    verticalSpacing: Dp = 16.dp,
    horizontalSpacing: Dp = 16.dp,
    itemContent: @Composable (T) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing),
        horizontalArrangement = Arrangement.spacedBy(horizontalSpacing),
        contentPadding = contentPadding
    ) {
        items(items) { item ->
            itemContent(item)
        }
    }
}