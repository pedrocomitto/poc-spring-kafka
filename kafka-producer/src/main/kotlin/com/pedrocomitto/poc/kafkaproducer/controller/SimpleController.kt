package com.pedrocomitto.poc.kafkaproducer.controller

import com.pedrocomitto.poc.kafkaproducer.event.SimpleEvent
import com.pedrocomitto.poc.kafkaproducer.producer.SimpleProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simple")
class SimpleController(
        private val simpleProducer: SimpleProducer
) {

    @PostMapping
    fun produce(@RequestBody simpleEvent: SimpleEvent) {
        simpleProducer.send(simpleEvent)
    }
}