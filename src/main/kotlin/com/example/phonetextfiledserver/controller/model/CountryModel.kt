package com.example.phonetextfiledserver.controller.model

import com.example.phonetextfiledserver.repository.model.CountryDBModel

class CountryModel(
    val dial_code: String,
    val code: String,
    val country: String,
    val flag_url: String,
    val hint: String
)

fun CountryModel.convertToDBModel() = CountryDBModel(
    dialCode = this.dial_code,
    code = this.code,
    country = this.country,
    flagUrl = this.flag_url,
    hint = this.hint
)