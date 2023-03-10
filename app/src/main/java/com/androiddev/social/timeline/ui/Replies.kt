package com.androiddev.social.timeline.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Parent(
    label: String,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AssistChip(
            border = AssistChipDefaults.assistChipBorder(borderColor = Color.Transparent),
            colors = AssistChipDefaults.assistChipColors(
                containerColor = colorScheme.surfaceVariant,
                labelColor = colorScheme.primary
            ),
            shape = RoundedCornerShape(50, 50, 50, 50),
            onClick = onClick,
            label = {
                Text(label, style = MaterialTheme.typography.labelMedium)
            },
        )
    }
}
