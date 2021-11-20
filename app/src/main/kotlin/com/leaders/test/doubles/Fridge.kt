package com.leaders.test.doubles

class Fridge(var open: Boolean) {

    private var items: List<Any> = ArrayList()

    fun open() {
        open = true
    }

    fun close() {
        open = false
    }

    fun put(elephant: Elephant) {
        items.plus(elephant)
    }
}