package com.example.myapp.ui.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapp.viewmodel.TmpTripsViewModel


@Composable
fun TmpTripDetailsScreen(tripId: String, navController: NavController, viewModel: TmpTripsViewModel = viewModel()) {
    val trip = viewModel.tmpTrips.collectAsState().value.find { it.id == tripId }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            if (trip != null) {
                Text(text = trip.title, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "時間：${trip.startDate} - ${trip.endDate}")
                Text(text = "共 ${trip.days} 天")
                Text(text = "旅伴：${trip.members.joinToString("、")}")
                Button(onClick = { navController.popBackStack() }) {
                    Text("返回")
                }
            } else {
                Text("找不到旅程")
            }
        }
    }
}
