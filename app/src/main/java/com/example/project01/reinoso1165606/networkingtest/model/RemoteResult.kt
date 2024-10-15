package com.example.project01.reinoso1165606.networkingtest.model

data class RemoteResult(
    val current: Current,
    val current_units: CurrentUnits,
    val elevation: Int,
    val generationtime_ms: Double,
    val hourly: Hourly,
    val hourly_units: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)