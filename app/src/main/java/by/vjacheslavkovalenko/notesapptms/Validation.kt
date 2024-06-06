package by.vjacheslavkovalenko.notesapptms

import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern


fun validationLoginsText(text: String): ValidResult {
    return if (text.isBlank()) {
        ValidResult.Invalid(R.string.error_empty_text)
    } else
        ValidResult.Valid
}

fun validationNamesText(text: String): ValidResult {
    return when {
        text.isBlank() -> ValidResult.Invalid(R.string.error_empty_text)
        text.length < 3 || text.length > 255 -> ValidResult.Invalid(R.string.error_length_text)
        else -> ValidResult.Valid
    }
}

fun isEmailValid(emailString: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(emailString).matches()
}

fun validationPasswordSignup(passwordString: String): ValidResult {
    val patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$")
    return when {
        passwordString.isBlank() -> ValidResult.Invalid(R.string.error_empty_text)
        passwordString.length < 3 || passwordString.length > 255 -> ValidResult.Invalid(R.string.error_length_text)
        patternPassword.matcher(passwordString)
            .matches() -> ValidResult.Invalid(R.string.error_simbols_text)

        else -> ValidResult.Valid
    }
}

sealed class ValidResult {

    data object Valid : ValidResult()
    data class Invalid(val errorRes: Int) : ValidResult()
}
