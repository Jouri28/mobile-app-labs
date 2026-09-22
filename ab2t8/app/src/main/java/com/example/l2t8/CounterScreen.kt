package com.example.l2t8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val GreyButton = Color(0xFFE5E5EA)
private val GreenButton = Color(0xFF34C759)
private val GreyText = Color(0xFF8E8E93)

@Composable
fun AttendanceCounter() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "STUDENTS PRESENT",
            color = GreyText,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$count",
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { if (count > 0) count-- },
                enabled = count > 0,
                colors = ButtonDefaults.buttonColors(containerColor = GreyButton)
            ) {
                Text(text = "-", color = Color.Black, fontSize = 20.sp)
            }

            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(containerColor = GreenButton)
            ) {
                Text(text = "+", color = Color.White, fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))


        Button(
            onClick = { count = 0 },
            enabled = count > 0,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(text = "Reset", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))


        val statusText = if (count == 0) {
            "Tap + to check a student in."
        } else {
            "$count of 30 students checked in."
        }

        Text(
            text = statusText,
            color = GreyText,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}