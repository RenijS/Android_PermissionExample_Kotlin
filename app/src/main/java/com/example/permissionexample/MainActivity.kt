package com.example.permissionexample

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    companion object{
        //permission code should be greater than 0
        private const val CAMERA_PERMISSION_CODE = 1
        private const val FINE_LOCATION_PERMISSION_CODE = 2
        private const val CAMERA_AND_FINE_LOCATION_PERMISSION_CODE = 12

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonPermission).setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Already have the permission", Toast.LENGTH_LONG).show()
            } else{
                //request permission
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA,
                android.Manifest.permission.ACCESS_FINE_LOCATION), CAMERA_AND_FINE_LOCATION_PERMISSION_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show()
            } else{
                Toast.makeText(this, "Camera Permission is denied", Toast.LENGTH_LONG).show()

            }
        }
    }




}