package com.heiha.huntun.hog

import platform.Foundation.NSLog

internal actual inline fun log(level: LogLevel, tag: String, msg: String, throwable: Throwable?) {
    NSLog(formatLog(level, tag, msg, throwable))
}

internal inline fun formatLog(level: LogLevel, tag: String, msg: String, throwable: Throwable?) =
    """
        |[${level.simpleName}] $tag $msg
        |${throwable.toString()}
    """.trimMargin().trimEnd()
