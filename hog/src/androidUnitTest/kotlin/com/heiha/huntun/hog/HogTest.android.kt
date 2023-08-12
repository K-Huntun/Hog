package com.heiha.huntun.hog

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.verify
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class AndroidHogTest {

    @BeforeTest
    fun setUp() {
        mockkStatic(Log::class)
    }

    @AfterTest
    fun tearDown() {
        unmockkAll()
    }


    @Test
    fun `log function should print the log message with correct format`() {
        val level = LogLevel.INFO
        val tag = "TestTag"
        val msg = "Test message"
        val throwable = null

        val expectedLogMessage = "$msg"

        every { Log.println(any(), any(), any()) } returns 0
        log(level, tag, msg, throwable)

        verify { Log.println(level.priority, tag, expectedLogMessage) }
    }

    @Test
    fun `log function should print the log message with throwable with correct format`() {
        val level = LogLevel.INFO
        val tag = "TestTag"
        val msg = "Test message"
        val throwable = IllegalStateException()

        val expectedLogMessage = "$msg\n${throwable.stackTraceToString()}".trimEnd()

        every { Log.println(any(), any(), any()) } returns 0
        log(level, tag, msg, throwable)

        verify { Log.println(level.priority, tag, expectedLogMessage) }
    }
}