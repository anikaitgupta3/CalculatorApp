package com.example.calculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailET=findViewById<EditText>(R.id.email)
        val nameET=findViewById<EditText>(R.id.name)
        val submitButton=findViewById<Button>(R.id.submit)
        val emailandNameTV=findViewById<TextView>(R.id.email_name_text_view)

        submitButton.setOnClickListener {
            val emailText=emailET.text
            val nameText=nameET.text

            emailandNameTV.text="$emailText $nameText"

            //Launch the calculator activity
            val intent=Intent(this,CalculatorActivity::class.java)
        }
}