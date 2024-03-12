package com.example.calculatro

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewMode : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun OnAction(actions: CalculatorActions){
        when(actions){
            is CalculatorActions.Number -> enterNumber(actions.number)
            CalculatorActions.Calculate -> performCalculation()
            CalculatorActions.Clear -> state = CalculatorState()
            CalculatorActions.Decimal -> enterDecimal()
            CalculatorActions.Delete -> performDeletion()
            is CalculatorActions.Operation -> enterOperation(actions.operation)
        }
    }

    private fun performDeletion() {
       when{
           state.number2.isNotBlank() -> state = state.copy(
               number2 = state.number2.dropLast(1)
           )

           state.operation != null -> state = state.copy(
               operation = null
           )

           state.number1.isNotBlank() -> state = state.copy(
               number1 = state.number1.dropLast(1)
           )
       }
    }

    private fun enterOperation(operation: CalculatorOperations) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null){
            val resut = when(state.operation){
                CalculatorOperations.Add -> number1 + number2
                CalculatorOperations.Divide -> number1 / number2
                CalculatorOperations.Minus -> number1 - number2
                CalculatorOperations.Times -> number1 * number2
                null -> return
            }
            state = state.copy(
                number1 = resut.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterDecimal() {
       if (state.operation == null && !state.number1.contains(".")
           && state.number1.isNotBlank()){
           state = state.copy(
               number1 = state.number1 + "."
           )
           return
       }
        if (!state.number2.contains(".")
            && state.number2.isNotBlank()){
            state = state.copy(
                number1 = state.number2 + "."
            )
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null){
            if (state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )

    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}