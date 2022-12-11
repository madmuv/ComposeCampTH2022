package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.state.step10.WellnessTasksList
import com.codelabs.state.step10.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    mViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StateLessCounter(
            // ตัวนี้จะแปลงเป็น state ให้
            count = mViewModel.waterCount.collectAsState().value,
            onIncrement = mViewModel::addWaterCount
        )
        WellnessTasksList(
            tasks = mViewModel.task.collectAsState().value,
            onCheckChange = mViewModel::setTaskChecked,
            onClose = mViewModel::removeTask
        )
    }
}
