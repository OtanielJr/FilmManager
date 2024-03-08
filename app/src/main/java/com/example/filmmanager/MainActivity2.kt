package com.example.filmmanager
import android.os.Bundle
import android.os.Build
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.filmmanager.classes.Film


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val film: Film?




        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            film = intent.getSerializableExtra("film", Film::class.java)


        }else{
            film = intent.getSerializableExtra("film") as? Film

        }
        film?.let {
            loadFilm(it)
        } ?: run {
            // Tratar o caso em que o filme é nulo
            Log.e("NULO","esssa porra é nula trata disso")
        }

    }

    fun loadFilm(film: Film){
        val imageView = findViewById<ImageView>(R.id.imageURl)
        val imageUrl = film.url
        Glide
            .with(this)
            .load(imageUrl)
            .into(imageView);

        findViewById<TextView>(R.id.txtFilmName).text = film.filmName
        findViewById<TextView>(R.id.txtRelease).text = film.releaseDate
        findViewById<TextView>(R.id.txtDirector).text = film.director

    }


}

