package com.th3pl4gu3.unify.ui.leaves

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat

@BindingAdapter("absenceNumberAvailable")
fun TextView.setAbsenceNumber(number: Double) {
    text = NumberFormat.getInstance().format(number)
}