package com.pedrocomitto.poc.kafkaproducer.event

data class SimpleEvent(
    val id: Long,
    val param1: String,
    val param2: String
)