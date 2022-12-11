package com.codelabs.state.step10

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WellnessViewModel : ViewModel() {

    // TODO: step10 waterCount State
    private val _waterCount = MutableStateFlow(0)
    val waterCount: StateFlow<Int> get() = _waterCount

    fun addWaterCount() {
        _waterCount.value++
    }

    // region list

    // TODO: step10 tasks: List<WellnessTask>>
    private val _tasks = MutableStateFlow(getWellnessTasks())
    val task: StateFlow<List<WellnessTask>> get() = _tasks

    fun removeTask(taskId: TaskId) {
        _tasks.value = _tasks.value.filter{ it.id != taskId}
    }

    fun setTaskChecked(taskId: TaskId, checked: Boolean) {
        _tasks.value = _tasks.value.map {
            if (it.id == taskId) it.copy(checked = checked)
            else it
        }
    }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i.toLong(), "Task # $i", checked = false) }
    // endregion
}

