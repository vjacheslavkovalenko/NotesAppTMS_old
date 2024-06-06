package by.vjacheslavkovalenko.notesapptms

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val textSignup = findViewById<TextView>(R.id.id_text_signup)
        val firstName = findViewById<TextView>(R.id.id_first_name)
        val lastName = findViewById<TextView>(R.id.id_last_name)
        val emailSignup = findViewById<TextView>(R.id.id_email_signup)
        val emailString = emailSignup.text.toString()
        val passwordSignup = findViewById<TextView>(R.id.id_password_signup)
        val passwordString = passwordSignup.text.toString()

        firstName.doAfterTextChanged { text ->
            var validationResultFirstName: ValidResult = validationNamesText(text.toString())
            when (validationResultFirstName) {
                is ValidResult.Valid -> {
                    firstName.error = null
                }

                is ValidResult.Invalid -> {
                    firstName.error = getString(validationResultFirstName.errorRes)
                }
            }
        }

        lastName.doAfterTextChanged { text ->
            var validationResultLastName: ValidResult = validationNamesText(text.toString())
            when (validationResultLastName) {
                is ValidResult.Valid -> {
                    lastName.error = null
                }

                is ValidResult.Invalid -> {
                    lastName.error = getString(validationResultLastName.errorRes)
                }
            }
        }

        emailSignup.doAfterTextChanged { text ->
            if (isEmailValid(emailString)) {
                Toast.makeText(this, "Valid Email", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
            }
        }

        passwordSignup.doAfterTextChanged { text ->
            var validationResultpasswordSignup: ValidResult =
                validationPasswordSignup(text.toString())
            when (validationResultpasswordSignup) {
                is ValidResult.Valid -> {
                    lastName.error = null
                }

                is ValidResult.Invalid -> {
                    lastName.error = getString(validationResultpasswordSignup.errorRes)
                }
            }
        }

        textSignup.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}