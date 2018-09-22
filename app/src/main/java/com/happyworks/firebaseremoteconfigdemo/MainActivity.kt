package com.happyworks.firebaseremoteconfigdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.util.*


class MainActivity : AppCompatActivity() {


    //list containing target urls
    private val urlList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //create/fetch an instance of RemoteConfig
        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val remoteConfigUtils = RemoteConfigUtils.getInstance()

        //initialize Remote config to fetch data from Firebase Console
        //make sure that when data is fetched success fully you need to restart the app
        remoteConfigUtils.initRemoteConfig(mFirebaseRemoteConfig, this)

        //TODO  create a preference which defines that the data is fetched

        //add fetched data from firebase console
        //keep in mind that if the data is not fetched config will load data from the remote_config_defaults_map.xml
        urlList.add(remoteConfigUtils.getRemoteStringData(mFirebaseRemoteConfig, "url1"))
        urlList.add(remoteConfigUtils.getRemoteStringData(mFirebaseRemoteConfig, "url2"))
        urlList.add(remoteConfigUtils.getRemoteStringData(mFirebaseRemoteConfig, "url3"))
        urlList.add(remoteConfigUtils.getRemoteStringData(mFirebaseRemoteConfig, "url4"))

        val randomButton = findViewById<Button>(R.id.randomPageButton)
        randomButton.setOnClickListener {

            //get random index to select url
            val index = Random().nextInt(3)
            val url = urlList[index]
            //showing url to user, not needed in released app
            Toast.makeText(this, "URL: $url", Toast.LENGTH_LONG).show()

            //firing intent to open in the browser
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }
    }
}
