package com.leaders.test.doubles

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChefTest {
    @Test
    fun `chef put elephant to the fridge`() {
        val chef = Chef()
        val fridge = Fridge(false)
        val dummyElephant = Elephant(100)

        chef.putElephantToFridge(dummyElephant, fridge)

        assertFalse(fridge.open)
    }
}