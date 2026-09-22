package edu.iau.cshj.csc402.lab3


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF0D1B3E)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = initials(student.name),
                            color = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF34C759))
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = student.name)
                    Text(text = student.program)
                }

                Text(text = student.gpa)
            }

            HorizontalDivider()

            Text(text = student.email)
            Text(text = student.city)
        }
    }
}

private fun initials(name: String): String {
    val parts = name.trim().split(" ")
    return if (parts.size >= 2) {
        "${parts[0].first()}${parts[1].first()}".uppercase()
    } else {
        parts.firstOrNull()?.take(2)?.uppercase() ?: ""
    }
}

@Preview(showBackground = true)
@Composable
fun StudentCardPreview() {
    MaterialTheme {
        Surface {
            StudentCard(
                student = Student(
                    name = "Ahmed Al-Qahtani",
                    program = "Computer Science - Level 4",
                    gpa = "4.62",
                    email = "220001234@iau.edu.sa",
                    city = "Jubail, Eastern Province"
                )
            )
        }
    }
}