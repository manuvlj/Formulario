package com.manudavid.formulario

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fecha_button.setOnClickListener{
            // Initialize a new DatePickerFragment
            val newFragment = DatePickerFragment()
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")
        }

        guardar_button.setOnClickListener {
            val nombre = nombre_edit_text.text.toString()
            val correo = correo_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val repContrasena = repetir_contrasena_edit_text.text.toString()
            var genero =  if(femenino_radioButton.isChecked) getString(R.string.femenino) else getString(R.string.masculino)
            val ciudadDeNacimiento = nacimiento_spinner.selectedItem

            var pasatiempos = ""
            if (videojuegos_checkBox.isChecked) pasatiempos += getString(R.string.videojuegos) + SPACE
            if (peliculas_series_checkBox.isChecked) pasatiempos += getString(R.string.peliculas_series) + SPACE
            if (leer_checkBox.isChecked) pasatiempos += getString(R.string.leer) + SPACE

            if(nombre == EMPTY || correo == EMPTY || contrasena == EMPTY || repContrasena == EMPTY){
                textView.text ="Usted no ingresó todos los datos"
            }

            else{
                if (contrasena != repContrasena)
                    textView.text = "Las contraseñas son diferentes."

                else
                    textView.text = getString(R.string.respuesta, nombre, correo, genero, pasatiempos, ciudadDeNacimiento)

            }

        }
    }
}

