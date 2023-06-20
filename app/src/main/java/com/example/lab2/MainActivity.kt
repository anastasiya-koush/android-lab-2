package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    companion object {
        const val QUESTION_REQUEST_CODE = 100
        const val QUESTION_KEY = "QUESTION"
        const val ANSWER_KEY = "ANSWER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    fun onQuestionSubmit(view: View) {
        var question = findViewById<EditText>(R.id.questionEditText).text.toString()
        var intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra(QUESTION_KEY, question)
        startActivityForResult(intent, QUESTION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === QUESTION_REQUEST_CODE) {
            if (resultCode === RESULT_OK) {
                val answer = data?.getStringExtra(ANSWER_KEY).toString()
                val answerTextView = findViewById<TextView>(R.id.answerTextView)
                answerTextView.text = answer
            }
        }
    }
}