package com.dband.genapi

import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider

fun main(args: Array<String>) {
  val provider = ClassPathScanningCandidateComponentProvider(false)
  val filter = AnnotationTypeFilter(RestController::class.java)

  provider.addIncludeFilter(filter)

  val beans = provider.findCandidateComponents("com.dband.*")
  for(b in beans) {
    val clazz = Class.forName(b.getBeanClassName())
    for(m in clazz.getDeclaredMethods()) {
      val annot = AnnotationUtils.findAnnotation(m, GetMapping::class.java)
      println(annot)
    }
  }
}
