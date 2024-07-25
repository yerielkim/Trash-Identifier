package com.yerirang27.natureapp

import android.media.Rating
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.theokanning.openai.completion.CompletionChoice
import com.theokanning.openai.completion.CompletionRequest
import com.theokanning.openai.completion.chat.ChatMessage
import com.theokanning.openai.service.OpenAiService
import java.time.Duration
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ChatGPTService private constructor() {
    fun query() {
        try {
            val prompt =
                """
                 Should I throw away the object centered in this image in "trash," "compost," or "recycling"? Answer in single word.
                 """.trimIndent()
            val service: OpenAiService = OpenAiService(
                "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",
                Duration.ZERO
            )
            com.theokanning.openai.completion.chat.ChatCompletionRequest.builder()
                .messages(
                    listOf(
                        ChatMessage()
                    )
                )
            val completionRequest: CompletionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("gpt-4o")
                .stream(false)
                .echo(false)
                .maxTokens(2048)
                .build()
            val list: List<CompletionChoice> =
                service.createCompletion(completionRequest).getChoices()
            val completionChoice: CompletionChoice = list[0]
            var response: String = completionChoice.getText()
            response = response.replace("(?m)^[ \t]*\r?\n".toRegex(), "").trim { it <= ' ' }
            Log.e("minmin", "response: $response")

            val index = response.indexOf("{")
            if (index != 0) {
                response = response.substring(index)
            }

        } catch (e: Exception) {
            Log.e("minmin", e.message!!)
        }
    }
}