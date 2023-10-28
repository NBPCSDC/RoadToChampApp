package com.example.roadtochamp.utils

import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalDate::class)
object DateSerializer : KSerializer<LocalDate> {
    override fun serialize(encoder: Encoder, value: LocalDate) {
        val formattedDate = value.toString()
        encoder.encodeString(formattedDate)
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        val formattedDate = decoder.decodeString()
        return LocalDate.parse(formattedDate)
    }
}