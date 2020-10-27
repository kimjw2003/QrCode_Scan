package com.example.qrcode_scan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startBarcodeLeader(view: View){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null){
            Log.d("Logd", "a")

            if(result.contents != null){
                var intent = Intent(this, WebActivity::class.java)
                intent.putExtra("key", result.contents.toString())
                startActivity(intent)
                Toast.makeText(this, "scanned : ${result.contents} format : ${result.formatName}", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
            }
        }else{
            Log.d("Logd", "result == null")
            super.onActivityResult(requestCode, resultCode, data) //여기로 들어가짐. 왜??? --> gradle에 kotlin-extension추가가 안되어있었다.
        }
    }
}