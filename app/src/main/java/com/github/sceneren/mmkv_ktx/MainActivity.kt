package com.github.sceneren.mmkv_ktx

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.sceneren.mmkv_ktx.ui.theme.MMKV_KTXTheme
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MMKV_KTXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val isNightMode by remember {
        mutableStateOf(SettingsRepository.isNightMode)
    }
    val language by remember {
        mutableStateOf(SettingsRepository.language)
    }

    val mainViewModel = viewModel<MainViewModel>()

    val isFirst by mainViewModel.isFirst.collectAsState()

    Column(modifier = modifier) {
        Text(modifier = Modifier
            .clickable {
                SettingsRepository.isNightMode = !SettingsRepository.isNightMode
            }
            .padding(vertical = 10.dp), text = "isNightMode= $isNightMode!")
        Text(modifier = Modifier
            .clickable {
                SettingsRepository.language = "new ZH"
            }
            .padding(vertical = 10.dp), text = "language= $language!")
        Text(
            modifier = Modifier
                .clickable {
                    mainViewModel.changeFirst()
                }
                .padding(vertical = 10.dp),
            text = "isFirst= $isFirst!"
        )
    }

}