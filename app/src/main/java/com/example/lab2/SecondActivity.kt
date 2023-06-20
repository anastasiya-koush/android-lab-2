package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var question = intent.getStringExtra(MainActivity.QUESTION_KEY)
        var questionTextView = findViewById<TextView>(R.id.questionTextView)
        questionTextView.text = question
    }

    fun onAnswerSubmit(view: View) {
        var answer = findViewById<EditText>(R.id.answerEditText).text.toString()
        var intent = Intent()
        intent.putExtra(MainActivity.ANSWER_KEY, answer)
        setResult(RESULT_OK, intent)
        finish()
    }
}

