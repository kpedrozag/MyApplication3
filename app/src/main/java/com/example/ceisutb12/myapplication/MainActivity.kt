package com.example.ceisutb12.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.util.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        la_api()

    }

    fun la_api()
    {
        var u = "https://jsonplaceholder.typicode.com/posts/"
        val random = Random()
        val gg = random.nextInt(100 - 1) + 100
        u += gg
        u.httpGet().responseJson { request, response, result -> run{
            when(result){
                is Result.Failure -> {
                    texto_api.text = "Error de conexion a internet"
                }
                is Result.Success -> {
                    val datos = result.get()
                    var aux: JSONObject = JSONObject()
                    aux = datos.obj()
                    var user = aux.getString("userId")
                    var title = aux.getString("title")
                    var body = aux.getString("body")
                    texto_api.text = "Hola, soy el usuario " + user + "\n" + title + "\n" + body
                }
            }
        } }
    }

    fun selector(v: View)
    {
        val texto1 = spinner1.selectedItem.toString()
        val texto2 = spinner2.selectedItem.toString()
        var dec: Int
        var valor = numero.text.toString()
        when(texto1)
        {
            "Decimal" ->
            {
                when(texto2)
                {
                    "Binario" ->
                    {
                        // convertir decimal -> binario
                        dec = Integer.parseInt(valor)
                        valor = Integer.toBinaryString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Hexadecimal" ->
                    {
                        // convertir decimal a hexadecimal
                        dec =  Integer.parseInt(valor)
                        valor = Integer.toHexString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Octal" ->
                    {
                        // convertir decimal a -> octal
                        dec = Integer.parseInt(valor)
                        valor = Integer.toOctalString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    else ->
                    {
                        // escribir el mismo resultado
                        resuul.text = valor
                    }
                }
            }
            "Binario" ->
            {
                when(texto2)
                {
                    "Decimal" ->
                    {
                        // convertir binario a decimal
                        dec = Integer.parseInt(valor, 2)
                        valor = dec.toString()
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Hexadecimal" ->
                    {
                        // convertir binario a hexadecimal
                        dec = Integer.parseInt(valor, 2)
                        valor = Integer.toHexString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Octal" ->
                    {
                        // convertir binario a octal
                        dec = Integer.parseInt(valor, 2)
                        valor = Integer.toOctalString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    else ->
                    {
                        // escribir el mismo resultado
                        resuul.text = valor
                    }
                }
            }
            "Hexadecimal" ->
            {
                when(texto2)
                {
                    "Decimal" ->
                    {
                        // convertir hexadecimal a decimal
                        dec = Integer.parseInt(valor, 16)
                        valor = dec.toString()
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Binario" ->
                    {
                        // convertir hexadecimal a binario
                        dec = Integer.parseInt(valor, 16)
                        valor = Integer.toBinaryString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Octal" ->
                    {
                        // convertir hexadecimal a octal
                        dec = Integer.parseInt(valor, 16)
                        valor = Integer.toOctalString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    else ->
                    {
                        // escribir el mismo resultado
                        resuul.text = valor
                    }
                }
            }
            "Octal" ->
            {
                when(texto2)
                {
                    "Decimal" ->
                    {
                        // convertir octal a decimal
                        dec = Integer.parseInt(valor, 8)
                        valor = dec.toString()
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Binario" ->
                    {
                        // convertir octal a binario
                        dec = Integer.parseInt(valor, 8)
                        valor = Integer.toBinaryString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    "Hexadecimal" ->
                    {
                        // convertir octal a hexadecimal
                        dec = Integer.parseInt(valor, 8)
                        valor = Integer.toHexString(dec)
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                    else ->
                    {
                        // escribir el mismo resultado
                        // ubicar valor como texto del resultado
                        resuul.text = valor
                    }
                }
            }
        }
    }
}
