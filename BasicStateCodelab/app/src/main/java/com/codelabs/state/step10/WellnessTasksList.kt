package com.codelabs.state.step10

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// TODO: step10
@Composable
fun WellnessTasksList(
    tasks: List<WellnessTask>,
    onCheckChange: (TaskId, Boolean) -> Unit,
    onClose: (TaskId) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked ->
                    onCheckChange(task.id, checked)
                },
                onClose = { onClose(task.id) }
            )
        }
    }
}
