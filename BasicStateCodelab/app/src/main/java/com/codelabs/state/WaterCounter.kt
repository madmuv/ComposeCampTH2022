package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count: Int by rememberSaveable { mutableStateOf(0) }

    StateLessCounter(count, { count++}, modifier)

}

@Composable
fun StateLessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }
        Button(
            onClick = onIncrement
            ,
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}
