package com.fpsimarro.practicas.provesexamen1.pojo


import com.example.examen_tortosa_pau.R
import java.io.Serializable

class ODS(val tipo:Int,
          val nombre:String,
          val icono:Int = R.drawable.ods1,
          val acciones:ArrayList<AccionODS> = arrayListOf<AccionODS>(
    AccionODS("Garantizando condiciones de trabajo adecuadas")))
    :Serializable {


    class ODSDatos {

        companion object {

            val accionesODS1= arrayListOf<AccionODS>(
                AccionODS("Garantizando condiciones de trabajo adecuadas"),
                AccionODS("Erradicar la pobreza extrema"),
                AccionODS("Establecer sistemas de protección social"),
                AccionODS("Fortalecer la resiliencia ante desastres")

            )

            val accionesODS2= arrayListOf<AccionODS>(
                AccionODS("Impulsando medidas para reducir el desperdicio de alimentos"),
                AccionODS("Erradicar el hambre y garantizar el acceso a alimentos"),
                AccionODS("Promover una agricultura sostenible"),
                AccionODS("Apoyar a los pequeños agricultores"),
                AccionODS("Regular los mercados de alimentos")
            )

            val accionesODS3= arrayListOf<AccionODS>(
                AccionODS("Reducir la mortalidad materna e infantil"),
                AccionODS("Combatir enfermedades transmisibles"),
                AccionODS("Aumentar la cobertura sanitaria universal"),
                AccionODS("Mejorar la salud mental y el bienestar"),
                AccionODS("Abordar la contaminación ambiental")
            )

            val accionesODS4= arrayListOf<AccionODS>(
                AccionODS("Garantizar el acceso a una educación de calidad"),
                AccionODS("Promover la formación técnica, profesional y universitaria"),
                AccionODS("Integrar la educación en sostenibilidad"),
                AccionODS("Garantizar entornos de aprendizaje seguros e inclusivos")
            )

            val accionesODS5= arrayListOf<AccionODS>(
                AccionODS("Eliminar todas las formas de discriminación"),
                AccionODS("Erradicar la violencia de género"),
                AccionODS("Fortalecer las leyes y las políticas de igualdad"),
                AccionODS("Promover la igualdad de oportunidades económicas")
            )

            val accionesODS6= arrayListOf<AccionODS>(
                AccionODS("Reducir la contaminación del agua"),
                AccionODS("Aumentar la eficiencia en el uso del agua"),
                AccionODS("Gestionar los recursos hídricos de manera integrada")
            )

            val accionesODS7= arrayListOf<AccionODS>(
                AccionODS("Ahorrar energía en el hogar"),
                AccionODS("Adoptar energías renovables"),
                AccionODS("Fomentar la movilidad sostenible")
            )



            val ODS = arrayListOf<ODS>(
               ODS(1,"Fin de la pobreza", R.drawable.ods1, accionesODS1),
               ODS(2,"Hambre cero",R.drawable.ods2, accionesODS2),
               ODS(3,"Salud y bienestar",R.drawable.ods3, accionesODS3),
               ODS(4,"Educación de calidad",R.drawable.ods4, accionesODS4),
               ODS(5,"Igualdad de género",R.drawable.ods5, accionesODS5),
               ODS(6,"Agua limpia y saneamiento",R.drawable.ods6, accionesODS6),
               ODS(7,"Energía asequible y no contaminante",R.drawable.ods7, accionesODS7)
            /*
               ODS(8,"Trabajo decente y crecimiento económico",R.drawable.ods8),
               ODS(9,"Industria, innovación e infraestructura",R.drawable.ods9),
               ODS(10,"Reducción de las desigualdades",R.drawable.ods10),
               ODS(11,"Ciudades y comunidades sostenibles",R.drawable.ods11),
               ODS(12,"Producción y consumo responsables",R.drawable.ods12),
               ODS(13,"Acción por el clima",R.drawable.ods13),
               ODS(14,"Vida submarina",R.drawable.ods14),
               ODS(15,"Vida de ecosistemas terrestres",R.drawable.ods15),
               ODS(16,"Paz, justicia e instituciones sólidas",R.drawable.ods16),
               ODS(17,"Alianzas para lograr objetivos",R.drawable.ods17),
               */

            )
        }
    }
}