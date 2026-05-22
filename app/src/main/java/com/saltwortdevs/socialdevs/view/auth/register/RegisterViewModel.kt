package com.saltwortdevs.socialdevs.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState : StateFlow<RegisterUiState> = this._uiState

    fun onValueChanged(value: String, type : Int){
        _uiState.update { state ->

            state.copy(value = value, type = type)
        }
        verifyRegister()
    }

    private fun verifyRegister() {
        val type = _uiState.value.type
        val enabledRegisterButton = if (type == 1) isEmailValid(_uiState.value.value) else isPhoneNumber(_uiState.value.value)
        _uiState.update {
            it.copy(isLoadingEnabled = enabledRegisterButton)
        }
    }

    private fun isEmailValid(email : String) : Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPhoneNumber(phoneNumber : String) : Boolean = phoneNumber.length <= 10

    fun onChangeType(type: Int) {
        val changeType = if (type == 0) 1 else 0
        _uiState.update { it.copy(type = changeType, value = "") }
    }

}
data class RegisterUiState(
    val value : String = "",
    var type : Int = 0,
    val isLoading : Boolean = false,
    val isLoadingEnabled : Boolean = false
)