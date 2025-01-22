package com.alphatheory.demoprojreleasesnsherrill.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerA {

    @RequestMapping("api/v1/letter")
    fun giveMeLetter(): String{
        return "your letter is ${('a'..'z').random()}"
    }
}