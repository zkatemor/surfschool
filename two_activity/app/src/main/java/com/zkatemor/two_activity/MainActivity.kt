package com.zkatemor.two_activity

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "PermissionDemo"
    private val LOCATION_REQUEST_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()
    }

    fun onClick(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("message", editText.text.toString())
        }
        startActivity(intent)
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to location!")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user.")
                    Toast.makeText(this, "Permission has been denied by user.", Toast.LENGTH_SHORT).show()
                } else {
                    Log.i(TAG, "Permission has been granted by user.")
                    Toast.makeText(this, "Permission has been granted by user.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
