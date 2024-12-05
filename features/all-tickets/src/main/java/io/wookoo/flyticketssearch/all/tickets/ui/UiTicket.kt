package io.wookoo.flyticketssearch.all.tickets.ui

data class UiTicket(
    val id:String,
    val badge:String? = null,
    val price:String,
    val departureTime:String,
    val departureAirport:String,
    val arrivalTime:String,
    val arrivalAirport:String,
    val timeToFly:String,
    val hasTransfer:Boolean,
)
