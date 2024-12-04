package io.wookoo.flyticketssearch.tickets.modal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.flyticketssearch.domain.models.UserFromModel
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ModalBottomSheetViewModel(
    private val masterRepository: IMasterRepository
) : ViewModel() {

    private val _whereEditText = MutableStateFlow("")

    val whereEditText = combine(
        _whereEditText,
        masterRepository.getUserInfo()
    ) { whereEditText, userInfo ->
        whereEditText.ifEmpty { userInfo.lastUserInput }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ""
    )

    fun setEditText(newText: String) {
        viewModelScope.launch {
            val newUserInfo = UserFromModel(1, newText)
            masterRepository.saveUserInfo(newUserInfo)
        }
    }
}
