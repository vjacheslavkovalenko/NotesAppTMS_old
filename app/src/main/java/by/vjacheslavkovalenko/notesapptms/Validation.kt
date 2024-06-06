package by.vjacheslavkovalenko.notesapptms

import android.widget.EditText



    internal fun EditText.isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
    }


    fun validationLoginText(text: String): ValidResult {
        return if (text.isBlank()) {
            ValidResult.Invalid(R.string.error_empty_text)
        } else
            ValidResult.Valid
    }


    fun validationText(text: String): ValidResult {
        return when {
            text.isBlank() -> ValidResult.Invalid(R.string.error_empty_text)
            text.length < 6 || text.length > 25 -> ValidResult.Invalid(R.string.error_length_text)
            else -> ValidResult.Valid
        }
    }

    sealed class ValidResult {

        data object Valid : ValidResult()
        data class Invalid(val errorRes: Int) : ValidResult()
    }

