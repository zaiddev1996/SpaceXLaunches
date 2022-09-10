package zaiddev1996.android.moneseassignment.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import health.dept.ecarecameroon.core.repository.ErrorWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import zaiddev1996.android.moneseassignment.data.models.Either
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.repo.SpaceXRepo
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val spaceXRepo: SpaceXRepo
) : ViewModel() {

    private val _launchStateFlow: MutableStateFlow<LaunchesState?> = MutableStateFlow(null)
    val launchStateFlow: StateFlow<LaunchesState?> = _launchStateFlow

    private var filterActivated = false

    init {
        getLaunches()
    }

    fun getLaunches() {
        _launchStateFlow.value = LaunchesState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val response = if (filterActivated) {
                spaceXRepo.callGetFilteredLaunchesApi()
            } else {
                spaceXRepo.callGetLaunchesApi()

            }
            response.onSuccess {
                _launchStateFlow.value = LaunchesState.Success(it)
            }.onFailure {
                _launchStateFlow.value = LaunchesState.Failure(it)
            }
        }
    }

    sealed class LaunchesState {
        data class Success(
            val data: ArrayList<Launch>
        ) : LaunchesState()

        data class Failure(
            val errorMessage: String
        ) : LaunchesState()

        object Loading : LaunchesState()
    }

    fun toggleFitter(checked: Boolean) {
        filterActivated = checked
        getLaunches()
    }
}