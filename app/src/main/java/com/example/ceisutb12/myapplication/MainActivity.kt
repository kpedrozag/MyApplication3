package com.example.ceisutb12.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager

class MainActivity : Activity() {

    val system_items = arrayOf("Binario", "Hexadecimal", "Octal", "Decimal")
    val system_bin = arrayOf("Hexadecimal", "Octal", "Decimal")
    val system_hex = arrayOf("Binario", "Octal", "Decimal")
    val system_oct = arrayOf("Binario", "Hexadecimal", "Decimal")
    val system_dec = arrayOf("Binario", "Hexadecimal", "Octal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, system_items)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1!!.setAdapter(aa)
        val opcion = spinner2.selectedItem.toString()

    }

    fun selector(v: View)
    {
        val texto1 = spinner1.selectedItem.toString()
        val texto2 = spinner2.selectedItem.toString()
        if (texto1 == "Decimal"){
            if (texto2 == "Binario")
            {
                decToBin(v)
            }
            else{
                if (texto2 == "Hexadecimal") {

                    var valor = numero.text.toString().toInt()
                    result.text = valor.toString(16)

                }
                else
                {
                    if (texto2 == "Octal")
                    {
                        decToOct(v)
                    }
                    else{
                        result.text = "Conversion no valida".toString()
                    }
                }
            }
        }
    }

    fun decToBin(v: View)
    {
        var valor = numero.text.toString().toInt()
        var BinaryNumber: Long = 0
        var remainder: Int
        var i = 1
        var step = 1
        while (valor != 0)
        {
            remainder = valor % 2
            valor = valor / 2
            BinaryNumber += (remainder * i).toLong()
            i *= 10
        }
        result.text = valor.toString()


    }

    fun decToOct(v: View)
    {

        var valor = numero.text.toString().toInt()
        var OctalNumber = 0
        var i = 1
        while (valor != 0)
        {
            OctalNumber += valor % 8 * i
            valor = valor / 8
            i *= 10
        }
        result.text = valor.toString()


    }


}
