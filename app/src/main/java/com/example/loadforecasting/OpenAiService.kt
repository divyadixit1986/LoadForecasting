import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.MediaType
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

import okhttp3.*

class OpenAIService {

    fun analyzeDataUsingOpenAI(input: String, apiKey: String, callback: (result: String?, error: String?) -> Unit) {
        val client = OkHttpClient()

        val mediaType = MediaType.parse("application/json") ?: return
        val body = RequestBody.create(mediaType, "{\"prompt\": \"$input\", \"max_tokens\": 100}")
        val request = Request.Builder()
            .url("https://api.openai.com/v1/engines/davinci/completions")
            .post(body)
            .addHeader("Authorization", "Bearer $apiKey")
            .addHeader("Content-Type", "application/json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        callback(null, "Error: ${response.code}")
                        return
                    }

                    val responseString = response.body?.string()
                    callback(responseString, null)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                callback(null, e.message ?: "Unknown error occurred")
            }
        })
    }
}
