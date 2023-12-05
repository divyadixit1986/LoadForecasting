package com.example.loadforecasting

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ForecastingAppActivity : AppCompatActivity() {
    private val apiKey = "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" // Replace with your actual API key
    private val openAIService = OpenAIService()
    // It's important to securely store and retrieve your API key, not hardcoding in the app


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecasting_app)

        val analyzeButton: Button = findViewById(R.id.analyzeButton)
        analyzeButton.setOnClickListener {
            val inputEditText: EditText = findViewById(R.id.inputEditText)
            val inputText = inputEditText.text.toString()
            analyzeData(inputText)
        }
    }
 {
                    // Display the result
                    //    private fun analyzeData(input: String)
                    //        openAIService.analyzeDataUsingOpenAI(input, apiKey) { result, error ->
                    //            // Update your UI with the result or error
                    //            // Since this is a network call, ensure you handle this on the main thread
                    //            runOnUiThread {
                    //                val resultTextView: TextView = findViewById(R.id.resultTextView)
                    //                if (error != null) {
                    //                    // Display the error message
                    //                    resultTextView.text = "Error: $error"
                    //                } else
                    resultTextView.text = result ?: "No result returned"
                }
            }
        }
    }
}
