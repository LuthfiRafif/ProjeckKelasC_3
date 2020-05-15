package com.barcoding.projeckkelasc_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.app.AlertDialog
import android.widget.EditText
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
            var alert: AlertDialog.Builder = AlertDialog.Builder(this)
            val editUser = EditText(this)
            alert.setTitle("Username")
            alert.setMessage("hai")
            alert.setView(editUser)


            alert.setPositiveButton("Yes"){dialog, which ->
                var username = editUser.text.toString()
                val i = Intent(this@MainActivity,GameActivity::class.java)
                i.putExtra(GameActivity.EXTRA_USER,username)
                startActivity(i)
            }
            
            alert.setNegativeButton("No"){dialog, which ->  }

            alert.show()
        }
    }
}
