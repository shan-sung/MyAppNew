package com.example.myapp.ui.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TmpTripsScreen() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text("這是參考行程詳細頁", modifier = Modifier.padding(16.dp))
        }
    }
}