package com.example.gridcardviewapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private  var gvTabla: GridView?=null
    var nombre = arrayListOf<String>("Kevin","Emerson","Mario")
    var departamento = arrayListOf<String>("Sonsonate","Ahuchapan","Cabañas","San Salvador")

    var imagenes = arrayListOf(

        R.drawable.kevin,
        R.drawable.Mario,
        R.drawable.Emerson,

    )
    var imagenesLista = arrayListOf(
        ImgItems(imagenes.get(0),nombre.get(0),departamento.get(0)),
        ImgItems(imagenes.get(1),nombre.get(1),departamento.get(1)),
        ImgItems(imagenes.get(2),nombre.get(2),departamento.get(2))
    )
    var myImagenList = ArrayList<ImgItems>()
    var modificadorAdaptador:AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(imagen in imagenesLista){
            myImagenList.add(imagen)

        }
        gvTabla = findViewById(R.id.gv_Tabla)

        modificadorAdaptador = AdaptadorModificado(myImagenList,this)
        gvTabla?.adapter = modificadorAdaptador

        gvTabla?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                   var ventana:Intent = Intent(applicationContext,Detalle::class.java)
                ventana.putExtra("imagen",imagenes.get(position))
                ventana.putExtra("Nombre",nombre.get(position))
                ventana.putExtra("Departamento",departamento.get(position))
            startActivity(ventana)

            }

        }
        fun btSiguiente(Vista:View){
            var ventana:Intent = Intent(applicationContext,WebViewApp::class.java)
            startActivity(ventana)

        }
    }
}