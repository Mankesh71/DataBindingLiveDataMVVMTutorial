package com.test.databindinglivedatamvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitNames: List<String> = listOf(
        "Apple", "Banana", "Papaya", "Grapes", "Oranges", "Pear", "Raspberry", "Gooseberry", "Blueberry", "Watermelon", "Pineapple"
    )

    private val _currentRandomFruit = MutableLiveData<String>()
    val currentRandomFruit: LiveData<String>
        get() = _currentRandomFruit

    init {
        _currentRandomFruit.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentFruitName() {
        _currentRandomFruit.value = getRandomFruitName()
    }
}