package com.example.lab2

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.Lab2Theme

class SecondActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(vertical = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var question = intent.getStringExtra("QUESTION")

                    Text(
                        text = question ?: "No question is provided"
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    var answer by remember {
                        mutableStateOf("")
                    }

                    TextField(
                        value = answer,
                        onValueChange = { answer = it }
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    Button(onClick = {
                        var intent = Intent(this@SecondActivity, MainActivity::class.java)
                        intent.putExtra("ANSWER", answer)
                        intent.putExtra("QUESTION", question)
                        startActivity(intent)
                    }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
