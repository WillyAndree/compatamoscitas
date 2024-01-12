package com.compartamos.citasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.aristidevs.androidmaster.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetalleCitaActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getCitaInformation(id)
    }

    private fun getCitaInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val citaDetail =
                getRetrofit().create(ApiService::class.java).getCitasDetail(id)

            if(citaDetail.body() != null){
                runOnUiThread { createUI(citaDetail.body()!!) }
            }
        }
    }

    private fun createUI(cita: CitaDetailResponse) {

        binding.tvSuperheroName.text = cita.nombre

    }



    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://webapicalendar.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}