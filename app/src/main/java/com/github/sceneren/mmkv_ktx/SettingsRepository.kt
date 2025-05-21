package com.github.sceneren.mmkv_ktx

import com.github.sceneren.mmkv.MMKVOwner

object SettingsRepository : MMKVOwner(mmapID = "settings") {
    var isNightMode by mmkvBool()
    var language by mmkvString(default = "zh")
    val isFirst by mmkvBool().asStateFlow()
}