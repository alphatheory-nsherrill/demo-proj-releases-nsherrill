package com.alphatheory.demoprojreleasesnsherrill.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue
import kotlin.random.Random
import kotlin.random.nextInt

@RestController
class ControllerA {

    @GetMapping("api/v1/letter")
    fun giveMeLetter(): String {
        return "your letter is ${('a'..'z').random()}"
    }

    @GetMapping("api/v1/gen-file")
    fun genFile(): String {
        val numLines = Random.nextInt(10, 1000)
        val now = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).filter { it.isLetterOrDigit() }
        File("generatedLines_$now.txt").writeText(
            List(numLines) { Random.nextLong().absoluteValue.toString() }.joinToString("\n")
        )
        return "wrote $numLines lines to file"
    }

    @GetMapping("api/v1/number")
    fun genNumber():String{
        return "your number is ${Random.nextInt()}"
    }

    @GetMapping("api/v1/preview-file")
    fun previewFile(): String {
        val numLines = Random.nextInt(10, 1000)
        val fileBody = List(numLines){Random.nextLong().absoluteValue.toString()}.joinToString("\n")
        return "Your file might look like:\n\n$fileBody"

    }
}