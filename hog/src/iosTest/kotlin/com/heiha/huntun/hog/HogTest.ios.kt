package com.heiha.huntun.hog

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class IosHogTest {


    @Test
    fun `log function should print the log message with correct format`() {
        val level = LogLevel.INFO
        val tag = "TestTag"
        val msg = "Test message"
        val throwable = null

        val expectedLog = "[${level.simpleName}] $tag $msg"

        assertEquals(expectedLog, formatLog(level, tag, msg, throwable))
    }

    @Test
    fun `log function should print the log message with throwable with correct format`() {
        val level = LogLevel.INFO
        val tag = "TestTag"
        val msg = "Test message"
        val throwable = IllegalStateException()

        val expectedLog = "[${level.simpleName}] $tag $msg\n${throwable.stackTraceToString()}".trimEnd()

        assertEquals(expectedLog, formatLog(level, tag, msg, throwable))
    }
}