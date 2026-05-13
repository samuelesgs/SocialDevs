package com.saltwortdevs.socialdevs.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun InstaButton(
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    shapes : Shape = MaterialTheme.shapes.extraLarge,
    onClick : () -> Unit,
    colors : ButtonColors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
    text: String
) {
    Button(
        modifier = modifier,
        colors = colors,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        onClick = {onClick()},
        enabled = enabled,
        shape = shapes,
    ) {
        InstaText(text = text, modifier = Modifier.fillMaxWidth().padding(4.dp))
    }
}