package com.happyworks.firebaseremoteconfigdemo

import android.app.Activity
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

/**
 * This class is a utility class which provides various methods to use FirebaseRemoteConfig object easily
 *
 * date: 22-09-18
 *
 * @author hjoshi
 */
class RemoteConfigUtils {

    /**
     * method to config the remoteConfig object provided to fetch data from the FirebaseConsole
     *
     * date: 22-09-18
     * @param mFirebaseRemoteConfig FirebaseRemoteConfig object provided by an activity
     * @param context activity reference provided to initialize the fetching the remote configurations
     * @author hjoshi
     */
    fun initRemoteConfig(mFirebaseRemoteConfig: FirebaseRemoteConfig, context: Activity) {
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults_map)
        mFirebaseRemoteConfig.fetch(5000)
                .addOnCompleteListener(context) { task ->
                    run {
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Fetch Successful!!", Toast.LENGTH_SHORT).show()
                            mFirebaseRemoteConfig.activateFetched()
                        } else {
                            Toast.makeText(context, "Fetch Unsuccessful!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
    }

    /**
     * Use this method to fetch string data from the remoteConfig object
     *
     * date: 22-09-18
     * @author hjoshi
     */
    fun getRemoteStringData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): String {
        return mFirebaseRemoteConfig.getString(key)
    }

    /**
     * Use this method to fetch double(or maybe float) data from the remoteConfig object
     *
     * date: 22-09-18
     * @author hjoshi
     */
    fun getRemoteDoubleData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Double {
        return mFirebaseRemoteConfig.getDouble(key)
    }

    /**
     * Use this method to fetch long(or maybe int) data from the remoteConfig object
     *
     * date: 22-09-18
     * @author hjoshi
     */
    fun getRemoteLongData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Long {
        return mFirebaseRemoteConfig.getLong(key)
    }

    /**
     * Use this method to fetch boolean data from the remoteConfig object
     *
     * date: 22-09-18
     * @author hjoshi
     */
    fun getRemoteBooleanData(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): Boolean {
        return mFirebaseRemoteConfig.getBoolean(key)
    }

    /**
     * Use this method to fetch ByteArray data from the remoteConfig object
     *
     * date: 22-09-18
     * @author hjoshi
     */
    fun getRemoteByteArray(mFirebaseRemoteConfig: FirebaseRemoteConfig, key: String): ByteArray {
        return mFirebaseRemoteConfig.getByteArray(key)
    }

}