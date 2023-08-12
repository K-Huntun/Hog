package com.heiha.huntun.hog

internal var logDelegate: ((level: LogLevel, tag: String, msg: String, tr: Throwable?) -> Unit) = ::log

enum class LogLevel(val priority: Int, val simpleName: String) {
    VERBOSE(2, "V"),
    DEBUG(3, "D"),
    INFO(4, "I"),
    WARN(5, "W"),
    ERROR(6, "E")
}

fun logv(tag: String, msg: String, tr: Throwable? = null) {
    logDelegate(LogLevel.VERBOSE, tag, msg, tr)
}

fun logd(tag: String, msg: String, tr: Throwable? = null) {
    logDelegate(LogLevel.DEBUG, tag, msg, tr)
}

fun logi(tag: String, msg: String, tr: Throwable? = null) {
    logDelegate(LogLevel.INFO, tag, msg, tr)
}

fun logw(tag: String, msg: String, tr: Throwable? = null) {
    logDelegate(LogLevel.WARN, tag, msg, tr)
}

fun loge(tag: String, msg: String, tr: Throwable? = null) {
    logDelegate(LogLevel.ERROR, tag, msg, tr)
}

internal expect inline fun log(level: LogLevel, tag: String, msg: String, throwable: Throwable?)

internal fun Throwable?.toString(): String {
    this ?: return ""
    return this.stackTraceToString()
}
