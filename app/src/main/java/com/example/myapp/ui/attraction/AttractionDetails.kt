package com.example.myapp.ui.attraction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.viewmodel.AttrModel

@Composable
fun AttractionDetailsScreen(attrId: String, navController: NavController, viewModel: AttrModel = viewModel()) {
    val attr = viewModel.attr.collectAsState().value.find { it.id == attrId }

    Scaffold{ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            if (attr != null) {
                Text(text = attr.title, style = MaterialTheme.typography.headlineSmall)
                Image(
                    painter = painterResource(attr.imageResId),
                    contentDescription = stringResource(attr.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = attr.details)
                Button(onClick = { navController.popBackStack() }) {
                    Text("返回")
                }
            } else {
                Text("找不到景點")
            }
        }
    }
}