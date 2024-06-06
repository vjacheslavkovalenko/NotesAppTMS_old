package by.vjacheslavkovalenko.notesapptms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailLogin = findViewById<TextView>(R.id.id_email_login)
        val passwordLogin = findViewById<TextView>(R.id.id_password_login)
        val textReturn = findViewById<TextView>(R.id.id_text_return)

        emailLogin.doAfterTextChanged { text ->
            var validationResultEmail: ValidResult = validationLoginsText(text.toString())
            if (validationResultEmail is ValidResult.Valid) {
                emailLogin.error = null
            } else {
                Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
            }
        }

        passwordLogin.doAfterTextChanged { text ->
            var validationResultPassword: ValidResult = validationLoginsText(text.toString())
            if (validationResultPassword is ValidResult.Valid) {
                passwordLogin.error = null
            } else {
                Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
            }
        }

        textReturn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }

}