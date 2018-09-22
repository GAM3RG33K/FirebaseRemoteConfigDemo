package com.happyworks.firebaseremoteconfigdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {


    private val urlList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        urlList.add(RemoteConfig.getRemoteStringData(activity = this, key = "url1"))
        urlList.add(RemoteConfig.getRemoteStringData(activity = this, key = "url2"))
        urlList.add(RemoteConfig.getRemoteStringData(activity = this, key = "url3"))
        urlList.add(RemoteConfig.getRemoteStringData(activity = this, key = "url4"))

        val randomButton = findViewById<Button>(R.id.randomPageButton)
        randomButton.setOnClickListener {

            val index = Random().nextInt(3)
            val url = urlList[index]
            //showing url to user
            Toast.makeText(this, "URL: $url", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "list:" + urlList.toString(), Toast.LENGTH_LONG).show()
            //firing intent to open in the browser
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }
    }
}
