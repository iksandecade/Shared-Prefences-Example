package com.example.iksan.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.Id
 * Date         : 01/05/2017
 * Project      : SharedPreferenceExample
 */
public class SPSharedPreferences {

    private static String AS_WHO = "AS_WHO";
    private static String USERNAME = "USERNAME";

    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    static void setAsWho(Context context, String asWho) {
        //fungsi untuk menset tipe
        getSharedPreferences(context).edit().putString(AS_WHO, asWho).commit();
    }

    static String getAsWho(Context context) {
        //fungsi untuk memberikan tipe berupa string
        return getSharedPreferences(context).getString(AS_WHO, null);
    }

    static void setUsername(Context context, String username) {
        //fungsi untuk menset username
        getSharedPreferences(context).edit().putString(USERNAME, username).commit();
    }

    static String getUsername(Context context) {
        //fungsi untuk memberikan username berupa string
        return getSharedPreferences(context).getString(USERNAME, null);
    }
}
