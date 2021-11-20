package com.leaders.test.doubles

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class StringFormatterTest {
    @Mock
    private lateinit var utilStub: Util

    @Mock
    private lateinit var utilSpy: Util

    @Mock
    private lateinit var utilMock: Util

    @Test
    internal fun `should return origin string when format a string`() {
        val dummyUtil = null
        val stringFormatter = StringFormatter(dummyUtil)
        val stringToFormat = "abc"

        assertEquals(stringToFormat, stringFormatter.format(stringToFormat))
    }

    @Test
    internal fun `should return splitted string array based on the util split method`() {
        val stringToSplit = "abc"
        val splittedStrings = listOf("abc")
        whenever(utilStub.split(any())).thenReturn(splittedStrings)

        val stringFormatter = StringFormatter(utilStub)

        assertEquals(splittedStrings, stringFormatter.split(stringToSplit))
    }

    @Test
    internal fun `should call the split method from util when call the split method in formatter`() {
        val stringToSplit = "abc"
        val stringFormatter = StringFormatter(utilSpy)
        whenever(utilSpy.split(any())).thenReturn(listOf())

        stringFormatter.split(stringToSplit)

        verify(utilSpy).split(eq(stringToSplit))
    }

    @Test
    internal fun `should call the util split method with the string to split when call the split method in formatter`() {
        val stringToSplit = "abc"
        val stringFormatter = StringFormatter(utilMock)
        `when`(utilMock.split(eq(stringToSplit))).thenReturn(listOf())

        stringFormatter.split(stringToSplit)
    }
}