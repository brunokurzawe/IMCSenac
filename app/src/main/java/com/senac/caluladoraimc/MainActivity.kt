package com.senac.caluladoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClicked = findViewById(R.id.button) as Button

        btnClicked.setOnClickListener { view ->

            var altura = findViewById(R.id.editTextNumberDecimal) as EditText
            var peso = findViewById(R.id.editTextNumberDecimal2) as EditText

            val alturaDouble = altura.text.toString().toDouble()
            val pesoDouble = peso.text.toString().toDouble()

            var imc = pesoDouble.div(alturaDouble.times(alturaDouble))

            var cor = Color.BLUE
            if (imc > 30){
                cor = Color.rgb(255,0,0)
            }else if (imc > 25 ){
                cor = Color.rgb(242,79,0)
            }else{
                cor = Color.rgb(0,128,0)
            }

            val dec = DecimalFormat("#,###.00")
            val imcFormatado = dec.format(imc)

            Snackbar.make(view, "Seu IMC é: " + imcFormatado.toString(),
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).setBackgroundTint(cor).show()
        }
    }
}






