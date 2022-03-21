package com.example.chipgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var chip: Chip
        for(i in 0 until cgCondiciones.childCount){
            chip = cgCondiciones.getChildAt(i) as Chip //getChildAt returns a view, so in order
        // to save the chip object we need to make the cast using the keyword As
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER
            chip.setOnCloseIconClickListener{
                cgCondiciones.removeView(it)
            }
            chip.setOnClickListener{
                var aux = it as Chip
                Toast.makeText(this, "${aux.text} pulsado", Toast.LENGTH_SHORT).show()
            }

        }

        val chipNew = Chip(this)
        chipNew.text = "Opcion"
        chipNew.chipIcon = ContextCompat.getDrawable(this, R.drawable.ic_email)
        chipNew.isChipIconVisible = false
        chipNew.isCloseIconVisible = true
        //necesary to get single selection working
        chipNew.isClickable = true
        chipNew.isCheckable = false
        cgCondiciones.addView(chipNew as View)
        chipNew.setOnCloseIconClickListener{
            cgCondiciones.removeView(chipNew as View)
        }

        val rb1 = vacacionesRg.getChildAt(1) as RadioButton
        vacacionesRg.check(rb1.id)
        // si no usamos la libreria kotlinx.android.synthetic.main.activity_main. tenemos que pbtener el radioGroup de la View
        /** var rgVacaciones = findViewById<View>(R.id.vacacionesRg) as RadioGroup ó var rgVacaciones = findViewById<RadioGroup>(R.id.vacacionesRg) as**/

        cbSeguro.isChecked = false
        cbSeguro.isEnabled = true

        toggleNormal.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)Toast.makeText(this, "Toggle Activado", Toast.LENGTH_SHORT).show()
            else    Toast.makeText(this, "Toggle desactivado", Toast.LENGTH_SHORT).show()
        }

        swNormal.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)Toast.makeText(this, "Switch Activado", Toast.LENGTH_SHORT).show()
            else    Toast.makeText(this, "Switch desactivado", Toast.LENGTH_SHORT).show()
        }


    }
/**ALWAYS THAT WE REFERENCE AN ONCLICK EVENT WE HAVE TO RECEIVE A VIEW OBJECT BECAUSE VIEW IS THE
 *  MAIN CLASS THAT AL OBJECTS DISPLAYED ON A SCREEN HAVE IN COMMON, ALSO THE FUNCTION CAN´T
 *  BE PRIVATE BECAUSE WE NEED TO USE IF IT WERE PRIVATE WE WOULDN'T BE ABLE TO CALL IT FROM THE XML **/
   fun onRadioButtonClicked(view: View){
//LOS IFS DENTRO DE ESTE EVENTO SE PUEDEN QUITAR PERO SE DEJAN APROPOSITO PARA VER OPCIONES
    if (view is RadioButton){//we can avoid this verification but is recommended in order to make or call safer
           var checked = view.isChecked
           when(view.id){
               R.id.rbBeach ->{
                   if (checked) Toast.makeText(this, "Playa", Toast.LENGTH_SHORT).show()
               }
               R.id.rbMontain ->{
                   if (checked) Toast.makeText(this, "Montaña", Toast.LENGTH_SHORT).show()
               }
           }
       }
    }fun onCheckBoxClicked(view: View){
    if (view is CheckBox){//we can avoid this verification but is recommended in order to make or call safer
           var checked = view.isChecked
           when(view.id){
               R.id.cbSeguro ->{
                   if (checked) Toast.makeText(this, "Seguro Contratado", Toast.LENGTH_SHORT).show()
                   else Toast.makeText(this, "Seguro Anulado", Toast.LENGTH_SHORT).show()
               }
               R.id.cbCancelable ->{
                   if (checked) Toast.makeText(this, "La reserva podra ser cancelada", Toast.LENGTH_SHORT).show()
                   else Toast.makeText(this, "La reserva no podra ser cancelada", Toast.LENGTH_SHORT).show()
               }
           }
       }
    }
}