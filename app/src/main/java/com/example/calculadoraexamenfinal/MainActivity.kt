package com.example.calculadoraexamenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var no1: Double = 0.0
    private var no2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnUno=findViewById<Button>(R.id.btnuno)
        var btndos=findViewById<Button>(R.id.btndos)
        var btntres=findViewById<Button>(R.id.btntres)
        var btncuatro=findViewById<Button>(R.id.btncuatro)
        var btncinco=findViewById<Button>(R.id.btncinco)
        var btnseis=findViewById<Button>(R.id.btnseis)
        var btnsiete=findViewById<Button>(R.id.btnsiete)
        var btnocho=findViewById<Button>(R.id.btnocho)
        var btnnueve=findViewById<Button>(R.id.btnNueve)
        var btnmas=findViewById<Button>(R.id.btnmas)
        var btnresta=findViewById<Button>(R.id.btnresta)
        var btncero=findViewById<Button>(R.id.btncero)
        var btnpunto=findViewById<Button>(R.id.btnpunto)
        var btnigual=findViewById<Button>(R.id.btnigual)
        var btnmul=findViewById<Button>(R.id.btnmul)
        var btndivi=findViewById<Button>(R.id.btndivi)
        var btninfo=findViewById<Button>(R.id.btninfo)
        var btnC=findViewById<Button>(R.id.btnC)
        var resTextView=findViewById<TextView>(R.id.resTextView)

        btninfo.setOnClickListener{
            startActivity(Intent(this, info::class.java))
        }

        btnUno.setOnClickListener{numeroPrecion(digito= "1")}
        btndos.setOnClickListener{numeroPrecion(digito= "2")}
        btntres.setOnClickListener{numeroPrecion(digito= "3")}
        btncuatro.setOnClickListener{numeroPrecion(digito= "4")}
        btncinco.setOnClickListener{numeroPrecion(digito= "5")}
        btnseis.setOnClickListener{numeroPrecion(digito= "6")}
        btnsiete.setOnClickListener{numeroPrecion(digito= "7")}
        btnocho.setOnClickListener{numeroPrecion(digito= "8")}
        btnnueve.setOnClickListener{numeroPrecion(digito= "9")}
        btncero.setOnClickListener{numeroPrecion(digito= "0")}
        btnpunto.setOnClickListener{numeroPrecion(digito= ".")}

        btndivi.setOnClickListener {operacionPres(Div)}
        btnmas.setOnClickListener {operacionPres(Mas)}
        btnmul.setOnClickListener {operacionPres(Mul)}
        btnresta.setOnClickListener{operacionPres(Res)}

        btnC.setOnClickListener {
            no1 = 0.0
            no2 = 0.0
            resTextView.text = "0"
            operacion = NO_OPERACION
        }
        btnigual.setOnClickListener{
            val resultado = when(operacion){
                Mas -> no1 + no2
                Res -> no1 - no2
                Mul -> no1 * no2
                Div -> no1 / no2
                else -> 0
            }
            resTextView.text = resultado.toString()
        }
    }
    private fun numeroPrecion(digito: String) {
        var resTextView=findViewById<TextView>(R.id.resTextView)
        resTextView.text = "${resTextView.text}$digito"
        if (operacion == NO_OPERACION){
            no1 = resTextView.text.toString().toDouble()
        } else{
            no2 = resTextView.text.toString().toDouble()
        }
    }
    private fun operacionPres(operacion: Int){
        var resTextView=findViewById<TextView>(R.id.resTextView)
        this.operacion = operacion
        resTextView.text = "0"
    }
    companion object{
        const val Mas = 1
        const val Res = 2
        const val Mul = 3
        const val Div = 4
        const val NO_OPERACION = 0
    }
}





