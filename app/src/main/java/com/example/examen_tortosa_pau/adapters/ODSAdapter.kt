package com.example.examen_tortosa_pau.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_tortosa_pau.databinding.ItemOdsBinding
import com.example.examen_tortosa_pau.fragments.ODSListener
import com.fpsimarro.practicas.provesexamen1.pojo.ODS

class ODSAdapter(
    private val listaOds: List<ODS>,
    private val listener: ODSListener?
) : RecyclerView.Adapter<ODSAdapter.ODSViewHolder>() {

    inner class ODSViewHolder(private val binding: ItemOdsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ods: ODS) {
            binding.txtNombreOds.text = ods.nombre
            binding.imgOds.setImageResource(ods.icono)
            binding.root.setOnClickListener {
                listener?.onClickOds(ods)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ODSViewHolder {
        val binding = ItemOdsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ODSViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ODSViewHolder, position: Int) {
        holder.bind(listaOds[position])
    }

    override fun getItemCount(): Int = listaOds.size
}