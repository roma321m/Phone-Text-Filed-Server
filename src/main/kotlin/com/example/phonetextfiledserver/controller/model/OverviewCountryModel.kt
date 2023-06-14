package com.example.phonetextfiledserver.controller.model

import com.example.phonetextfiledserver.repository.model.CountryDBModel
import java.util.*

class OverviewCountryModel(
    val dialCode: String,
    val code: String,
    val country: String,
    val flagUrl: String,
    val hint: String,
    val date: Date,
    val id: String
)

fun CountryDBModel.convertToOverviewCountryModel() = OverviewCountryModel(
    dialCode = this.dialCode,
    code = this.code,
    country = this.country,
    flagUrl = this.flagUrl,
    hint = this.hint,
    date = this.date,
    id = this.id.toString()
)