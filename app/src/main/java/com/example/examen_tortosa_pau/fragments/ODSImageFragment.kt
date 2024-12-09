package com.example.examen_tortosa_pau.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_tortosa_pau.R

private const val IMAGEN:Int = 1

class ODSImageFragment : Fragment() {
    private var imagen: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imagen = it.getInt(IMAGEN.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ods_image, container, false)

        val contenedorImagen = view.findViewById<ImageView>(R.id.imgOds)
        imagen?.let { contenedorImagen.setImageResource(it) }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(imagen: Int) =
            ODSImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMAGEN.toString(), imagen)
                }
            }
    }
}