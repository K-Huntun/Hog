package com.heiha.huntun.hog

import android.util.Log

internal actual inline fun log(level: LogLevel, tag: String, msg: String, throwable: Throwable?) {
    Log.println(level.priority, tag, """
        |$msg
        |${throwable.toString()}
    """.trimMargin().trimEnd())
}
