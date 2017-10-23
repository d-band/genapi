package com.dband.genapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController () {

  @GetMapping("/")
  fun findAll(): String {
    return "hello"
  }

  @GetMapping("/{name}")
  fun findByLastName(@PathVariable name:String): String {
    return name
  }
}