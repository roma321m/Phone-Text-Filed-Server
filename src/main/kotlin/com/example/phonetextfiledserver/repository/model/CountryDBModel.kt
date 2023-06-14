package com.example.phonetextfiledserver.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.Date
import java.util.UUID

@Entity
class CountryDBModel(
    val dialCode: String,
    val code: String,
    val country: String,
    val flagUrl: String,
    val hint: String
) {
    @Id
    @GeneratedValue
    var id: UUID? = null
        private set

    val date: Date = Date()
}