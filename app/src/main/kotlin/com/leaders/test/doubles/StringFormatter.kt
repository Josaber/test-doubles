package com.leaders.test.doubles

class StringFormatter(private val util: Util?) {
    fun format(stringToFormat: String): String {
        return stringToFormat
    }

    fun split(stringToSplit: String): List<String> {
        return if (util === null) stringToSplit.split(",") else util.split(stringToSplit)
    }
}