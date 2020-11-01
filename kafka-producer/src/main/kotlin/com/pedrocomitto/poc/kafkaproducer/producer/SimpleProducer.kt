package com.pedrocomitto.poc.kafkaproducer.producer

import com.pedrocomitto.poc.kafkaproducer.event.SimpleEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*
import kotlin.random.Random

@Component
class SimpleProducer(
    private val kafkaTemplate: KafkaTemplate<String, SimpleEvent>
) {

    @Value("\${simple-topic}")
    lateinit var topic: String

    private val log = LoggerFactory.getLogger(javaClass)

    fun send(simpleEvent: SimpleEvent) {
        log.info("sending message=$simpleEvent")

        kafkaTemplate.send(topic, UUID.randomUUID().toString(), simpleEvent)
                .completable()
    }
}