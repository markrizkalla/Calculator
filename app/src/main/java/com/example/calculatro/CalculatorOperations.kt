package com.example.calculatro

sealed class CalculatorOperations(val symbol : String) {

    object Add: CalculatorOperations("+")
    object Minus: CalculatorOperations("-")
    object Times: CalculatorOperations("*")
    object Divide: CalculatorOperations("/")
}