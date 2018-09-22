package com.happyworks.firebaseremoteconfigdemo

import android.app.Activity
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object RemoteConfig {
    private val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    init {

    }

    private fun initRemoteConfig(context: Activity): FirebaseRemoteConfig {
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults_map)
        mFirebaseRemoteConfig.fetch(5000)
                .addOnCompleteListener(context) { task ->
                    run {
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Fetch Successful!!", Toast.LENGTH_LONG).show()
                            mFirebaseRemoteConfig.activateFetched()
                        } else {
                            Toast.makeText(context, "Fetch Unsuccessful!!", Toast.LENGTH_LONG).show()
                        }
                    }
                }
        return mFirebaseRemoteConfig
    }

    fun getRemoteStringData(key: String, activity: Activity): String {
        initRemoteConfig(activity)
        return mFirebaseRemoteConfig.getString(key)
    }

    fun getRemoteDoubleData(key: String, activity: Activity): Double {
        initRemoteConfig(activity)
        return mFirebaseRemoteConfig.getDouble(key)
    }

    fun getRemoteLongData(key: String, activity: Activity): Long {
        initRemoteConfig(activity)
        return mFirebaseRemoteConfig.getLong(key)
    }

    fun getRemoteBooleanData(key: String, activity: Activity): Boolean {
        initRemoteConfig(activity)
        return mFirebaseRemoteConfig.getBoolean(key)
    }

    fun getRemoteByteArray(key: String, activity: Activity): ByteArray {
        initRemoteConfig(activity)
        return mFirebaseRemoteConfig.getByteArray(key)
    }

}