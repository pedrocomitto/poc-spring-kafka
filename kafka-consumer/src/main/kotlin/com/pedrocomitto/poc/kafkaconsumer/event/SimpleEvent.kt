package com.pedrocomitto.poc.kafkaconsumer.event

data class SimpleEvent(
        val id: Long,
        val param1: String,
        val param2: String
)