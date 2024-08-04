package com.yerirang27.natureapp

import android.R.attr.type
import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import com.google.gson.Gson
import com.theokanning.openai.completion.chat.ChatCompletionChoice
import com.theokanning.openai.completion.chat.ChatCompletionRequest
import com.theokanning.openai.completion.chat.ChatMessage
import com.theokanning.openai.service.OpenAiService
import java.io.ByteArrayOutputStream
import java.time.Duration


class ChatGPTService constructor() {
    private fun encodeImageToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    fun query(bitmap: Bitmap): Item? {
        val jsonFormat = "" +
                "{" +
                "\"item\": \"Chair\"," +
                "\"recycleMethod\": \"trash\"" +
                "}"
        try {
            val prompt =
                """
                    $jsonFormat
                   Your answer should be generated as above json Format. "item" should indicate what the recognized item from the image is and "recycleMethod" should be either "trash", "compost" or "recycling".
     Should I throw away the recognized item from the image in "trash," "compost," or "recycling"? Image: ${encodeImageToBase64(bitmap)}
     """.trimIndent()
            val service: OpenAiService = OpenAiService(
                "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",
                Duration.ZERO
            )
            val chatCompletionRequest = ChatCompletionRequest.builder()
                .messages(
                    listOf(
                        ChatMessage(
                            "user",
                            prompt
                        )
                    )
                )
                .model("gpt-4o")
                .stream(false)
                .maxTokens(2048)
                .build()
//            val completionRequest: CompletionRequest = CompletionRequest.builder()
//                .prompt(prompt)
//                .model("gpt-4o")
//                .stream(false)
//                .echo(false)
//                .maxTokens(2048)
//                .build()
            val list: List<ChatCompletionChoice> =
                service.createChatCompletion(chatCompletionRequest).getChoices()
            val completionChoice: ChatCompletionChoice = list[0]
            var response: String = completionChoice.message.content
            response = response.replace("(?m)^[ \t]*\r?\n".toRegex(), "").trim { it <= ' ' }
            val formattedResponse = trimToJson(response)
            Log.e("minmin", "response: $formattedResponse")

            val gson = Gson()
            val item = gson.fromJson(formattedResponse, Item::class.java)
            return item
        } catch (e: Exception) {
            Log.e("minmin", e.message!!)
            return null
        }
    }

    fun trimToJson(text: String): String {
        val startIndex = text.indexOf('{')
        val endIndex = text.lastIndexOf('}') + 1
        return if (startIndex != -1 && endIndex != -1) {
            text.substring(startIndex, endIndex)
        } else {
            "Invalid JSON input"
        }
    }
}

data class Item(
    val item: String,
    val recycleMethod: String,
)