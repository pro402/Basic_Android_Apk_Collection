package com.example.alertdialogbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var b : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b= ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.b1.setOnClickListener{
            val bin1 = AlertDialog.Builder(this)
            bin1.setTitle("Are you sure??")
            bin1.setMessage("Do you want to close the app??")
            bin1.setIcon(R.drawable.baseline_exit_to_app_24)
            bin1.setPositiveButton("YES",DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            bin1.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            bin1.show()
        }
        b.b2.setOnClickListener{
            val bin2 = AlertDialog.Builder(this)
            val optons = arrayOf("Vegan","LacticIntollarent","Veg","Non-Veg(Hallal)","Non-Veg(Hindu)")
            bin2.setTitle("What is your passion?")
            bin2.setIcon(R.drawable.baseline_food_bank_24)
            bin2.setSingleChoiceItems(optons,0,DialogInterface.OnClickListener { dialog, w ->
                Toast.makeText(this,"You have selected ${optons[w]}",Toast.LENGTH_SHORT).show()
            })
            bin2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Your response is Registered", Toast.LENGTH_SHORT).show()
            })
            bin2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Please report if You are facing an Issue", Toast.LENGTH_SHORT).show()
            })
            bin2.show()
        }
        b.b3.setOnClickListener {
            val bin2 = AlertDialog.Builder(this)
            val optons = arrayOf("Web Dev","App Dev","DevOps","DSA","Open Source")
            bin2.setTitle("What is your passion?")
            bin2.setIcon(R.drawable.baseline_developer_mode_24)
            bin2.setMultiChoiceItems(optons,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You have selected ${optons[which]}",Toast.LENGTH_SHORT).show()

            })

            bin2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Your response is Registered", Toast.LENGTH_SHORT).show()
            })
            bin2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Please report if You are facing an Issue", Toast.LENGTH_SHORT).show()
            })
            bin2.show()
        }
    }
}