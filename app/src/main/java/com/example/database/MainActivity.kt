package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup=findViewById<Button>(R.id.enter)
        val ename=findViewById<TextInputEditText>(R.id.name)
        val eid=findViewById<TextInputEditText>(R.id.idd)
        val emaal = findViewById<TextInputEditText>(R.id.email)
        val ep=findViewById<TextInputEditText>(R.id.passwd)

        signup.setOnClickListener {

            val name = ename.text.toString()
            val email=emaal.text.toString()
            val uniqid=eid.text.toString()
            val upass=ep.text.toString()
            val user = User(name,email,uniqid,upass)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"Successfully Registered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }

            ename.setText("")
            emaal.setText("")
            ep.setText("")
            eid.setText("")

        }
    }
}