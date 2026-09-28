package com.example.tipcalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.R
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

@Composable
@Preview
fun TipCalculatorScreenPreview(){
    TipCalculatorTheme {
        TipCalculatorScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorScreen(){
    var totalAmountState = remember { TextFieldState("0.0") }
    val guestNumberState = remember { TextFieldState("0") }
    var checked by rememberSaveable { mutableStateOf(false) }
    val sliderState = rememberSliderState (
            steps = 3,
            valueRange = 0f..4f
        )
    var tipValue = 0.0f
    Scaffold (
        modifier = Modifier.fillMaxSize()
    ){
        innerPadding ->
        val columnModifier = Modifier
            .consumeWindowInsets(innerPadding)
            .padding(innerPadding)
        Column (
            modifier = columnModifier
        ) {
            val customQuantityKeyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal
            )
            val textFieldModifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)

            TextField(
                modifier = textFieldModifier,
                state = totalAmountState,
            )
            TextField(
                modifier = textFieldModifier,
                state = guestNumberState,
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text= stringResource(R.string.TipLabel)
                )
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            }

            Slider(
                state = sliderState,
                enabled = checked
            )
            val guestNumber =  guestNumberState.text.toString().toIntOrNull()
            val totalAmount = totalAmountState.text.toString().toDoubleOrNull()
            val isCalulateButtonEnabled = (guestNumber != null && totalAmount != null)
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = isCalulateButtonEnabled
            ) {
                Text(stringResource(R.string.CalculateLabel))
                when (tipValue) {
                    1.0f ->{

                    }
                }
            }

            Text("")
        }
    }
}