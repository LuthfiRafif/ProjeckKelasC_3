package com.barcoding.projeckkelasc_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hitung.*

class HitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        btn_2.setOnClickListener {

            var isEmpatyField = false

            val stringP = edt_1.text.toString().trim()
            val stringL = edt_1.text.toString().trim()
            val stringT = edt_1.text.toString().trim()

            if (stringP.equals("")){
                isEmpatyField = true
                edt_1.error="Data Kosong"
            }

            if (stringL.isEmpty()){
                isEmpatyField = true
                edt_2.error="Data Kosong"
            }

            if (stringT ==""){
                isEmpatyField = true
                edt_3.error="Data Kosong"
            }

            if (!isEmpatyField){

                val p = stringP.toFloat()
                val l = stringL.toFloat()
                val t = stringT.toFloat()

                tv_5.text = (p*l*t).toString()
            }
        }
    }
}
