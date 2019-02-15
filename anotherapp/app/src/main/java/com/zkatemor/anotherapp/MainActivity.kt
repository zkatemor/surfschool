package com.zkatemor.anotherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFirstApp(view : View){
        try {
            val intent = packageManager.getLaunchIntentForPackage("com.zkatemor.two_activity")
            startActivity(intent)
        }
        catch (e : Exception){

        }
    }

    fun onClickCallApp(view : View) {
        try {
            // запуск приложения для звонков
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        } catch (e: Exception) {

        }
    }
}
