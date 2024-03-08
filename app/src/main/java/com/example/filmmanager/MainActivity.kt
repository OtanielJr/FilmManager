package com.example.filmmanager
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.filmmanager.classes.Film

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var filmList:MutableList<Film> = ArrayList()

    fun addFilm(view: View){
        val edURL = findViewById<EditText>(R.id.edURL)

        if(edURL!=null){
            val edFilmName = findViewById<EditText>(R.id.edFilmName)
            val edReleaseDate = findViewById<DatePicker>(R.id.edReleaseDate)
            val edDirector = findViewById<EditText>(R.id.edDirector)

            val day = edReleaseDate.dayOfMonth.toString()
            val month = edReleaseDate.month.toString()
            val year = edReleaseDate.year.toString()
            val releaseDate = "$day/$month/$year"

            val movie = Film(edURL.text.toString(), edFilmName.text.toString(), releaseDate ,edDirector.text.toString())
            filmList.add(movie)
            loadFilmList()
            Log.e("teste", filmList.toString())
        }else{
            Log.e("erro","essa coisa não funciona nem que a caceta")
        }

    }

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    fun loadFilmList(){
        val container = findViewById<LinearLayout>(R.id.container3)
        container.removeAllViews()
        filmList.forEach{
        val template =LayoutInflater.from(this).inflate(R.layout.item_film,null,false)
        template.findViewById<TextView>(R.id.txtFilmName).text = it.filmName
            container.addView(template)
            val film = it


            template.setOnClickListener{
                Log.e("teste","clicar funciona")
                val intent = Intent(applicationContext,MainActivity2::class.java)

                intent.putExtra("film", film)
                startActivity(intent)
            }

        }
    }


}





