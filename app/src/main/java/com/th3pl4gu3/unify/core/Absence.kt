package com.th3pl4gu3.unify.core

import java.util.*

data class Absence(val title: String = ABSENCE_TYPE_TITLE_DEFAULT, val numberAvailable: Double = ABSENCE_TYPE_NUMBER_AVAILABLE_DEFAULT) {

    var uniqueId: String = UUID.randomUUID().toString()

    fun takeAbsence(taking: Double) : Double = numberAvailable - taking
}