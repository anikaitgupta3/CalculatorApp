package com.example.calculatorapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailET = findViewById<EditText>(R.id.email)
        val nameET = findViewById<EditText>(R.id.name)
        val submitButton = findViewById<Button>(R.id.submit)
        val emailandNameTV = findViewById<TextView>(R.id.email_name_text_view)

        submitButton.setOnClickListener {
            val emailText = emailET.text
            val nameText = nameET.text

            emailandNameTV.text = "$emailText $nameText"

            //Launch the calculator activity explicit intent
            val intent = Intent(
                this,
                CalculatorActivity::class.java
            )//means we are telling android to move from current activity to calculator activity
            startActivity(intent) //we can move back to main activity by pressing back
            finish() //main activity will be removed from back stack

            //Implicit Intent
            /*val implicitIntent=Intent(Intent.ACTION_VIEW)
            implicitIntent.setData(Uri.parse("https://www.geeksforgeeks.org"))
            startActivity(implicitIntent)*/

//            /*val mailIntent=Intent(Intent.ACTION_SEND)
//            mailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
//            mailIntent.putExtra(Intent.EXTRA_TEXT,"Body of the mail")
//            mailIntent.putExtra(Intent.EXTRA_CC,"CC")
//            mailIntent.putExtra(Intent.EXTRA_BCC,"BCC")
//
//            startActivity(Intent.createChooser(mailIntent,"Choose an email client"))*/
        }
    }
}