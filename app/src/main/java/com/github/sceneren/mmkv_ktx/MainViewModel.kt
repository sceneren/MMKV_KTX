package com.github.sceneren.mmkv_ktx

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    val isFirst = SettingsRepository.isFirst.asStateFlow()

    fun changeFirst() {

        Log.e("isFirst","isFirst=${isFirst.value}")

        SettingsRepository.isFirst.update { !isFirst.value }
    }

}