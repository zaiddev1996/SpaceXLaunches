package zaiddev1996.android.moneseassignment.ui.rocket

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.models.rocket.Rocket
import zaiddev1996.android.moneseassignment.data.repo.SpaceXRepo
import zaiddev1996.android.moneseassignment.ui.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class RocketViewModel
@Inject constructor(
    private val spaceXRepo: SpaceXRepo,
    private val state: SavedStateHandle
) : ViewModel() {

    private val _rocketStateFlow: MutableStateFlow<RocketState?> = MutableStateFlow(null)
    val rocketStateFlow: StateFlow<RocketState?> = _rocketStateFlow

    private val _errorSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    val errorSharedFlow: SharedFlow<String> = _errorSharedFlow

    init {
        getRocketDetails()
    }

    private fun getRocketDetails() {
        _rocketStateFlow.value = RocketState.Loading(true)
        viewModelScope.launch(Dispatchers.IO) {
            val response = spaceXRepo.callGetRocketDetailsApi(state.get<String>("id")!!)

            response.onSuccess {
                _rocketStateFlow.value = RocketState.Success(it)
            }.onFailure {
                _rocketStateFlow.value = RocketState.Loading(false)
                _errorSharedFlow.emit(it)
            }
        }
    }

    sealed class RocketState {
        data class Success(
            val data: Rocket
        ) : RocketState()

        data class Loading(
            val loading: Boolean
        ) : RocketState()

    }

}
