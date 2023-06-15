package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var question by remember {
                    mutableStateOf(intent.getStringExtra("QUESTION") ?: "")
                }

                TextField(
                    value = question,
                    onValueChange = { question = it }
                )

                Spacer(modifier = Modifier.padding(20.dp))

                var answer = intent.getStringExtra("ANSWER")

                Text(
                    text = answer ?: "No answer is provided"
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Button(onClick = {
                    var intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("QUESTION", question)
                    startActivity(intent)
                }) {
                    Text(text = "OK")
                }
            }
        }
    }
}