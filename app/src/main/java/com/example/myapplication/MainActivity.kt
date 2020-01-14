package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btcalcular (view: View) {
        val precoalcool = preco_alcool.text.toString()
        val precogasolina = preco_gasolina.text.toString()

        val validaCampos = validarCampos(precoalcool, precogasolina)
        if (validaCampos) {
            calcularMelhorPreco(precoalcool, precogasolina)
        } else {
            text_resultado.setText("Preencha os preços primeiro!")
        }
    }


        fun validarCampos( precoAlcool: String, precoGasolina: String ) : Boolean {

            var camposValidados: Boolean = true

            if ( precoAlcool == null || precoAlcool.equals("") ){
                camposValidados = false
            }else if( precoGasolina == null || precoGasolina.equals("") ){
                camposValidados = false
            }

            return camposValidados

    }

    fun calcularMelhorPreco( precoalcool: String, precogasolina: String) {

        //converte valores string para numeros
        val valorAlcool = precoalcool.toDouble()
        val valorGasolina = precogasolina.toDouble()

        //calculo
        val resultado = valorAlcool / valorGasolina
        if (resultado >= 0.7) {
            text_resultado.setText("melhor utilizar Gasolina")
        } else {
            text_resultado.setText("melhor utilizar Alcool")
        }
    }
}
