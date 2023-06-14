package com.example.phonetextfiledserver.controller

import com.example.phonetextfiledserver.controller.model.CountryModel
import com.example.phonetextfiledserver.controller.model.OverviewCountryModel
import com.example.phonetextfiledserver.controller.model.convertToDBModel
import com.example.phonetextfiledserver.controller.model.convertToOverviewCountryModel
import com.example.phonetextfiledserver.repository.CountryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/country")
class CountryController(
    val countryRepository: CountryRepository
) {

    @PostMapping("/add-all")
    fun addAllCountry(@RequestBody countryModelList: List<CountryModel>) {
        countryRepository.saveAll(
            countryModelList.map {
                it.convertToDBModel()
            }
        )
    }

    @PostMapping("/add")
    fun addCountry(@RequestBody countryModel: CountryModel) {
        countryRepository.save(countryModel.convertToDBModel())
    }

    @GetMapping("/all")
    fun getAllCountries(): List<OverviewCountryModel> {
        return countryRepository.findAll().map {
            it.convertToOverviewCountryModel()
        }
    }

    @GetMapping
    fun getCountry(@RequestParam code: String): OverviewCountryModel {
        return countryRepository.findAll().firstOrNull {
            it.code == code
        }?.convertToOverviewCountryModel() ?: OverviewCountryModel("", "", "", "", "", Date(), "")
    }

}