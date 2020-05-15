package com.barcoding.projeckkelasc_3

import android.graphics.Color
import android.graphics.Color.RED
import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3

class GameActivity : AppCompatActivity() {

    companion object{
        const val  EXTRA_USER = "username"
    }

    var username:String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        username = intent.getStringExtra(EXTRA_USER)

        var pilihanKomputer:Int
        var pilihanPlayer:Int

        btn_btu.setOnClickListener {
            tv_ply.text = "BATU"
            pilihanPlayer = BATU
            pilihanKomputer = getPilihanKomputet()
            tv_komp.text = ""
            Handler().postDelayed({
                tv_hsl.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            }, 2000)
        }

        btn_gtg.setOnClickListener {
            tv_ply.text = "GUNTING"
            pilihanPlayer = GUNTING
            pilihanKomputer = getPilihanKomputet()
            tv_komp.text = ""
            Handler().postDelayed({
                tv_hsl.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            }, 2000)
        }

        btn_kts.setOnClickListener {
            tv_ply.text = "KERTAS"
            pilihanPlayer = KERTAS
            pilihanKomputer = getPilihanKomputet()
            tv_komp.text = ""
            Handler().postDelayed({
                tv_hsl.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            }, 2000)
        }
    }

    fun getPilihanKomputet():Int{
        return Random.nextInt(3) + 1;
    }

    fun suwit(pilihanPlayer: Int, pilihanKomputer: Int):String{
        var hasil: String= ""
        if (pilihanPlayer == pilihanKomputer){
            tv_hsl.setTextColor(Color.GRAY)
            hasil = "SERI"
        } else if ((pilihanPlayer == BATU && pilihanKomputer == KERTAS) ||
            (pilihanPlayer == GUNTING && pilihanKomputer == BATU) ||
            (pilihanPlayer == KERTAS && pilihanKomputer == GUNTING)){
            hasil = username + " LOSE"
            tv_hsl.setTextColor(Color.RED)
        } else {
            hasil = username + " WIN"
            tv_hsl.setTextColor(Color.GREEN)
        }


        return hasil
    }

    fun showPilihanKomputer(pilihanKomputer: Int){
        when(pilihanKomputer){
            1 -> tv_komp.text = "Komputer memilih: BATU"
            2 -> tv_komp.text = "Komputer memilih: GUNTING"
            3 -> tv_komp.text = "Komputer memilih: KERTAS"
        }
    }
}
