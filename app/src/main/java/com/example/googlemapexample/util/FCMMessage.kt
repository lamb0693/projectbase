package com.example.googlemapexample.util

data class FCMMessage(
    val to: String,  // The FCM token or topic to which you want to send the message
    val notification: FCMNotification,
    val data: Map<String, String>
)
