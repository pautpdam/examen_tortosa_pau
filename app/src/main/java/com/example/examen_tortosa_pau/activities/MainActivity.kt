package com.example.examen_tortosa_pau.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_tortosa_pau.R
import com.example.examen_tortosa_pau.databinding.ActivityMainBinding
import com.example.examen_tortosa_pau.databinding.DialogPersoBinding
import com.example.examen_tortosa_pau.fragments.ODSFragment
import com.example.examen_tortosa_pau.fragments.ODSImageFragment
import com.example.examen_tortosa_pau.fragments.ODSListener
import com.fpsimarro.practicas.provesexamen1.pojo.ODS
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), ODSListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogoBinding: DialogPersoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val odsFragment = supportFragmentManager.findFragmentById(R.id.contenedorOdsFragment) as ODSFragment
        odsFragment.setOnClickListener(this)

        binding.btnAnyadir.setOnClickListener {
            val intent = Intent(this, NewODSActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClickOds(ods: ODS) {
        dialogoBinding = DialogPersoBinding.inflate(layoutInflater)

        dialogoBinding.imgDetalleOds.setImageResource(ods.icono)
        dialogoBinding.txtDetallesOds.text = mostrarDetalles(ods)

        MaterialAlertDialogBuilder(this)
            .setTitle(ods.nombre)
            .setView(dialogoBinding.root)
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, i ->
                dialog.cancel()
            })
            .setCancelable(false)
            .show()

        val imagenOdsFragment = ODSImageFragment.newInstance(ods.icono)
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorImageFragment, imagenOdsFragment)
            .addToBackStack(null)
            .commit()
    }

    fun mostrarDetalles(ods: ODS): String {
        val totalAcciones = ods.acciones.size
        var detalles = ""

        for (i in 0..totalAcciones-1)
        {
            detalles += ods.acciones[i].descripcion + "\n"
        }

        return detalles
    }
}