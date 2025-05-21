package com.github.sceneren.mmkv_ktx

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvMode = findViewById<TextView>(R.id.tv_mode)
        val tvLanguage = findViewById<TextView>(R.id.tv_language)

        tvMode.text = "当前模式：${if (SettingsRepository.isNightMode) "深色" else "浅色"}"
        tvLanguage.text = "当前语言：${SettingsRepository.language}"

    }
}