package com.leaders.test.doubles

class Chef {
    fun putElephantToFridge(elephant: Elephant, fridge: Fridge) {
        fridge.open()

        try {
            fridge.put(elephant)
        } finally {
            fridge.close()
        }
    }
}