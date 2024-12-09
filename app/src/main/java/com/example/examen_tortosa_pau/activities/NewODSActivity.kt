package com.example.examen_tortosa_pau.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_tortosa_pau.R
import com.example.examen_tortosa_pau.databinding.ActivityMainBinding
import com.example.examen_tortosa_pau.databinding.ActivityNewOdsactivityBinding
import com.example.examen_tortosa_pau.databinding.DialogPersoBinding
import com.example.examen_tortosa_pau.fragments.ODSListener
import com.fpsimarro.practicas.provesexamen1.pojo.ODS
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class NewODSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewOdsactivityBinding
    private lateinit var dialogoBinding: DialogPersoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNewOdsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tipos = arrayOf(1,2,3,4,5,6,7)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipos)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = binding.spinnerTipo
        spinner.adapter = adapter

        binding.btnGuardar.setOnClickListener {
            if (binding.edNombre.text.toString().isEmpty()) {
                Toast.makeText(this, "Debe haber contenido en todos los campos.", Toast.LENGTH_LONG).show()
            } else {
                val nombre = binding.edNombre.text.toString()
                val tipo = binding.spinnerTipo.selectedItem as Int

                val nuevoOds = ODS(tipo, nombre, ODS.ODSDatos.ODS[tipo-1].icono, ODS.ODSDatos.ODS[tipo-1].acciones)

                dialogoBinding = DialogPersoBinding.inflate(layoutInflater)

                dialogoBinding.imgDetalleOds.setImageResource(nuevoOds.icono)
                dialogoBinding.txtDetallesOds.text = nuevoOds.nombre

                MaterialAlertDialogBuilder(this)
                    .setTitle("ODS Añadido")
                    .setView(dialogoBinding.root)
                    .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, i ->
                        dialog.cancel()
                    })
                    .setCancelable(false)
                    .show()
            }
        }
    }
}