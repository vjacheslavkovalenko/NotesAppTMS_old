package by.vjacheslavkovalenko.notesapptms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailLogin = findViewById<TextView>(R.id.id_email_login)
        val passwordLogin = findViewById<TextView>(R.id.id_password_login)
        val textReturn = findViewById<TextView>(R.id.id_text_return)
//        val buttonLogin = findViewById<Button>(R.id.id_button_login)

        emailLogin.doAfterTextChanged { text ->
            var validationResultEmail : ValidResult =validationLoginText(text.toString())
            if (validationResultEmail is ValidResult.Valid) {
                  emailLogin.error = null
            } else {
                Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
            }
        }

//        emailField.doAfterTextChanged { text ->
//            if (text.isNullOrEmpty() || text.trim().isEmpty()) {
//                Toast.makeText(this, "field is required", Toast.LENGTH_SHORT).show()
//            }
//        }




//        emailLogin.doAfterTextChanged { text ->
//            val str = text.toString()
//            if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
//                Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
//            }
//        }


//        passwordLogin.doAfterTextChanged { text ->
//            val str = text.toString()
//            val lengthString = str.length
//            val patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$")
//            val matcher = patternPassword.matcher(str)
//
//            if ((lengthString < 6 || lengthString > 50) || !matcher.matches()) {
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
//            }
//        }




        textReturn.setOnClickListener {
            val intent = Intent (this, SignupActivity::class.java)
            startActivity(intent)
        }


    }

    //Toast.makeText(this, "Error Email", Toast.LENGTH_LONG).show()
}