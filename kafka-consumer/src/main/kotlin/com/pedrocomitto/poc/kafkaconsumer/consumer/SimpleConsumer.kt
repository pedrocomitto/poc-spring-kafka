package com.pedrocomitto.poc.kafkaconsumer.consumer

import com.pedrocomitto.poc.kafkaconsumer.event.SimpleEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class SimpleConsumer {

    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${simple-topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun consume(message: SimpleEvent) {
        log.info("event consumed, $message")
    }
}