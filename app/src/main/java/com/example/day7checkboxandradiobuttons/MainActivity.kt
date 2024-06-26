package com.example.day7checkboxandradiobuttons

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        val cbOnions = findViewById<CheckBox>(R.id.cbOnions)
        val cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        val tvOrder = findViewById<TextView>(R.id.tvOrder)

        btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked

            val orderString = "You ordered a burger with : \n " +
                    "${meat.text}" +
                    (if(cheese) "\nCheese" else "") +
                    (if (onions) "\nOnions" else "") +
                    (if (salad) "\nSalad" else "")
            tvOrder.text = orderString

        }
    }
}