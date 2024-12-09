package com.example.examen_tortosa_pau.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_tortosa_pau.R
import com.example.examen_tortosa_pau.adapters.ODSAdapter
import com.fpsimarro.practicas.provesexamen1.pojo.ODS

class ODSFragment : Fragment() {
    private var listener: ODSListener? = null
    private lateinit var odsAdapter: ODSAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_ods, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewTareas)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val datosOds = ODS.ODSDatos.ODS
        odsAdapter = ODSAdapter(datosOds, listener)

        recyclerView.adapter = odsAdapter

        return view
    }

    fun setOnClickListener(listener: ODSListener) {
        this.listener = listener
    }
}