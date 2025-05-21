package com.github.sceneren.mmkv_ktx

import com.github.sceneren.mmkv.MMKVOwner
import com.github.sceneren.mmkv.mmkvBool
import com.github.sceneren.mmkv.mmkvString

object SettingsRepository : MMKVOwner(mmapID = "settings") {
  var isNightMode by mmkvBool()
  var language by mmkvString(default = "zh")
  var isFirst by mmkvBool()
}