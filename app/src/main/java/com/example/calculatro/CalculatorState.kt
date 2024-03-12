package com.example.calculatro

data class CalculatorState(
    val number1 : String = "",
    val number2 : String = "",
    val operation : CalculatorOperations? = null
)
