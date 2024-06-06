package by.vjacheslavkovalenko.notesapptms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDiscover = findViewById<Button>(R.id.id_button_discover)
        val textLogin = findViewById<TextView>(R.id.id_text_login)

        buttonDiscover.setOnClickListener {
            val intent = Intent (this, SignupActivity::class.java)
            startActivity(intent)
        }

        textLogin.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }

//
//    For App "Notes" in TeachMeSkills (group AN18-onl). This is Branch for Lesson 16.
//
//   Commit N4. Add Screen 36. Add transitions. And all is working.

}