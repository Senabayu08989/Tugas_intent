package com.example.intent

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var text_date:TextView?=null
    var calendar = Calendar.getInstance()

    lateinit var g_Thriler : CheckBox
    lateinit var g_Comedy : CheckBox
    lateinit var g_horor : CheckBox
    lateinit var g_romance : CheckBox
    lateinit var g_action : CheckBox
    lateinit var g_fantasy : CheckBox

    lateinit var rb_anak:RadioButton
    lateinit var rb_remaja:RadioButton
    lateinit var rb_dewasa: RadioButton

    lateinit var negara : Spinner




    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text_date = this.date


        text_date!!.text = "--/--/----"

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, Cyear: Int, Cmonth: Int, CdayOfMonth: Int) {

                calendar.set(Calendar.YEAR, Cyear)
                calendar.set(Calendar.MONTH, CdayOfMonth)
                calendar.set(Calendar.DAY_OF_MONTH, CdayOfMonth)
                updateDateInView()

            }

            private fun updateDateInView() {
                val myFormat = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                text_date!!.text = sdf.format(calendar.getTime())
            }

        }


        text_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,

                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        })

        val title = findViewById<EditText>(R.id.ed_title)
        val direct = findViewById<EditText>(R.id.ed_direct)
        val prodct = findViewById<EditText>(R.id.ed_prodct)
        val process = findViewById<EditText>(R.id.process)

        g_Thriler = findViewById(R.id.g_Thriler) as CheckBox
        g_Comedy = findViewById(R.id.g_comedy) as CheckBox
        g_horor = findViewById(R.id.g_horor) as CheckBox
        g_romance = findViewById(R.id.g_romance) as CheckBox
        g_action = findViewById(R.id.g_action) as CheckBox
        g_fantasy = findViewById(R.id.g_fantasy) as CheckBox

        rb_anak=findViewById(R.id.rb_anak)as RadioButton
        rb_remaja=findViewById(R.id.rb_remaja)as RadioButton
        rb_dewasa=findViewById(R.id.rb_dewasa)as RadioButton

        var country = negara.getSelectedItem().toString()

        var spinner = negara.getSelectedItemPosition()


        process.setOnClickListener {

            val title = title.text.toString()
            val direct = direct.text.toString()
            val prodct = prodct.text.toString()
            var genre = ""
            var umur = ""
            val negara = negara.getSelectedItem().toString()
            val tanggal = date.text.toString()

            if (g_Thriler.isChecked)
                genre += "Thriler"
            if (g_Comedy.isChecked)
                genre += "Comedy"
            if (g_action.isChecked)
                genre += "Action"
            if (g_fantasy.isChecked)
                genre += "Fantasy"
            if (g_horor.isChecked)
                genre += "Horror"
            if (g_romance.isChecked)
                genre += "Romance"

            if (rb_anak.isChecked)
                umur += "Dibawah 13th"
            if (rb_dewasa.isChecked)
                umur += "Diatas 18th"
            if (rb_remaja.isChecked)
                umur += "antara 13th - 18th"


            var intent = Intent(this@MainActivity, layout_tampilan::class.java)
            intent.putExtra("title", title)
            intent.putExtra("direct", direct)
            intent.putExtra("title", title)
            intent.putExtra("Genre", genre)
            intent.putExtra("Umur", umur)
            intent.putExtra("date", tanggal)
            intent.putExtra("negara",negara)
            startActivity(intent)


        }


    }

}



