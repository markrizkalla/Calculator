package com.example.calculatro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatro.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp,
    modifier: Modifier = Modifier,
    onAction : (CalculatorActions) -> Unit
){
    Box(modifier = modifier){
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing))
        {
            Text(text = state.number1 + (state.operation?.symbol ?:"") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                CalculateButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f)
                        ,
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                CalculateButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }

                )
                CalculateButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Divide))
                    }

                )

            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculateButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                CalculateButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                CalculateButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculateButton(
                    symbol = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Times))
                    }
                )

            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculateButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                CalculateButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                CalculateButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculateButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Minus))
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculateButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                CalculateButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                CalculateButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculateButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Add))
                    }
                )

            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculateButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                CalculateButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                CalculateButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                    ,
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}