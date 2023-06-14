package com.example.phonetextfiledserver.repository

import com.example.phonetextfiledserver.repository.model.CountryDBModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CountryRepository : CrudRepository<CountryDBModel, UUID>