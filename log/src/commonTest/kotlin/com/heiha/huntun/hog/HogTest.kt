package com.heiha.huntun.hog

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HogTest {

    @AfterTest
    fun tearDown() {
        logDelegate = ::log
    }

    @Test
    fun testLogv() {
        val expectLevel = LogLevel.VERBOSE
        val expectTag = "TestTag"
        val expectMsg = "TestMsg"
        val expectTr = IllegalStateException()
        var invokeTag = false
        logDelegate = { level, tag, msg, tr ->
            assertEquals(expectLevel, level)
            assertEquals(expectTag, tag)
            assertEquals(expectMsg, msg)
            assertEquals(expectTr, tr)
            invokeTag = true
        }
        logv(expectTag, expectMsg, expectTr)
        assertTrue(invokeTag, "logDelegate should be invoked")
    }

    @Test
    fun testLogd() {
        val expectLevel = LogLevel.DEBUG
        val expectTag = "TestTag"
        val expectMsg = "TestMsg"
        val expectTr = IllegalStateException()
        var invokeTag = false
        logDelegate = { level, tag, msg, tr ->
            assertEquals(expectLevel, level)
            assertEquals(expectTag, tag)
            assertEquals(expectMsg, msg)
            assertEquals(expectTr, tr)
            invokeTag = true
        }
        logd(expectTag, expectMsg, expectTr)
        assertTrue(invokeTag, "logDelegate should be invoked")
    }

    @Test
    fun testLogi() {
        val expectLevel = LogLevel.INFO
        val expectTag = "TestTag"
        val expectMsg = "TestMsg"
        val expectTr = IllegalStateException()
        var invokeTag = false
        logDelegate = { level, tag, msg, tr ->
            assertEquals(expectLevel, level)
            assertEquals(expectTag, tag)
            assertEquals(expectMsg, msg)
            assertEquals(expectTr, tr)
            invokeTag = true
        }
        logi(expectTag, expectMsg, expectTr)
        assertTrue(invokeTag, "logDelegate should be invoked")
    }


    @Test
    fun testLogw() {
        val expectLevel = LogLevel.WARN
        val expectTag = "TestTag"
        val expectMsg = "TestMsg"
        val expectTr = IllegalStateException()
        var invokeTag = false
        logDelegate = { level, tag, msg, tr ->
            assertEquals(expectLevel, level)
            assertEquals(expectTag, tag)
            assertEquals(expectMsg, msg)
            assertEquals(expectTr, tr)
            invokeTag = true
        }
        logw(expectTag, expectMsg, expectTr)
        assertTrue(invokeTag, "logDelegate should be invoked")
    }

    @Test
    fun testLoge() {
        val expectLevel = LogLevel.ERROR
        val expectTag = "TestTag"
        val expectMsg = "TestMsg"
        val expectTr = IllegalStateException()
        var invokeTag = false
        logDelegate = { level, tag, msg, tr ->
            assertEquals(expectLevel, level)
            assertEquals(expectTag, tag)
            assertEquals(expectMsg, msg)
            assertEquals(expectTr, tr)
            invokeTag = true
        }
        loge(expectTag, expectMsg, expectTr)
        assertTrue(invokeTag, "logDelegate should be invoked")
    }
}