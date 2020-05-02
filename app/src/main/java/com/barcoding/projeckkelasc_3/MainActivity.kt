package com.barcoding.projeckkelasc_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_1.setOnClickListener{
            Toast.makeText(this,"Hai", Toast.LENGTH_LONG).show()
        }

        btn_1.setOnClickListener {
            val i = Intent(this@MainActivity,HitungActivity::class.java )
            startActivity(i)
        }

        btn_3.setOnClickListener {
            val i = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(i)
        }
    }
}
