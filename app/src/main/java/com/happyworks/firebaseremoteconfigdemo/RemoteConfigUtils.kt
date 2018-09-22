package com.happyworks.firebaseremoteconfigdemo

import android.app.Activity
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object RemoteConfigUtils {

    fun getInstance(): RemoteConfigUtils {
        return this
    }

    fun initRemoteConfig(mFirebaseRemoteConfig: FirebaseRemoteConfig, context: Activity) {
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
    }

    fun getRemoteStringData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): String {
        return mFirebaseRemoteConfig.getString(key)
    }

    fun getRemoteDoubleData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Double {
        return mFirebaseRemoteConfig.getDouble(key)
    }

    fun getRemoteLongData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Long {
        return mFirebaseRemoteConfig.getLong(key)
    }

    fun getRemoteBooleanData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Boolean {
        return mFirebaseRemoteConfig.getBoolean(key)
    }

    fun getRemoteByteArray(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): ByteArray {
        return mFirebaseRemoteConfig.getByteArray(key)
    }

}