package com.example.calculatro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatro.ui.theme.CalculatroTheme
import com.example.calculatro.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatroTheme {
                val viewModel = viewModel<CalculatorViewMode>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::OnAction,
                    modifier = Modifier.fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp))
            }
        }
    }
}

