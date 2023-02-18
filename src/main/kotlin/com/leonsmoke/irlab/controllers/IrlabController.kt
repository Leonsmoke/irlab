package com.leonsmoke.irlab.controllers

import com.leonsmoke.irlab.utils.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class IrlabController {

    @PostMapping("/create")
    fun createChar(@RequestBody body: String): String {
        val nickname: String = StringUtils.resolveNickname(body)
        File("chars/").mkdir();
        File("chars/$nickname.dat").writeText(body)
        if(isCharExist(nickname).equals("200")){
            File("chars/characters.data").appendText(nickname+"\n")
        }
        return "201"
    }

    @GetMapping("/all")
    fun getAllChars(): String {
        val characters: List<String> = File("chars/characters.data").readLines()
        var response: String = "{ \"chars\": [";
        characters.forEach{
            response = "$response\"$it\","
        }
        response = response.trim(',');
        response = "$response]}"
        return response;
    }

    @GetMapping("/char/{name}")
    fun isCharExist(@PathVariable name: String): String {
        if(!File("chars/characters.data").exists()) {
            return "200";
        }
        val characters: List<String> = File("chars/characters.data").readLines()
        characters.forEach{
            if(it.equals(name,true)) {
                return "202"
            }
        }
        return "200";
    }

    @GetMapping("/select/{name}")
    fun getByName(@PathVariable name: String): String {
        return File("chars/$name.dat").readText()
    }

    @GetMapping("/delete")
    fun deleteAll(): Boolean {
        return File("chars/").deleteRecursively();
    }

}