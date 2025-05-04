package com.example.myapp.ui.myTrips

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
import com.example.myapp.viewmodel.MyTripsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun TripDetailsScreen(tripId: String, navController: NavController, viewModel: MyTripsViewModel = viewModel()) {
    val trip = viewModel.myTrips.collectAsState().value.find { it.id == tripId }

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
                Button(
                    onClick = {
                        navController.navigate("chatroom/${trip.id}")
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("進入聊天室")
                }
            } else {
                Text("找不到旅程")
            }
        }
    }
}
