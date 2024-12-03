package io.wookoo.flyticketssearch.tickets.ui

import android.text.InputFilter

val inputFilter = InputFilter { source, _, _, _, _, _ ->
    if (source.matches("[А-Яа-я ]+".toRegex())) {
        null
    } else {
        ""
    }
}
