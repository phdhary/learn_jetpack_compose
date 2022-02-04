package com.phdhary.learn_jetpack_compose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeState,
                tween(3000, 0, LinearOutSlowInEasing)
            )

            Box(
                modifier = Modifier
                    .size(size)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Button(onClick = { sizeState += 50.dp }) {
                        Text("Expand")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { sizeState -= 50.dp }) {
                        Text("Shrink")
                    }

                }
            }
        }
    }
}
