package com.mastercard.gateway.android.sampleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mastercard.gateway.android.sdk.Gateway;

public enum Config {

    MERCHANT_ID("TEST222205234001"),
    REGION(Gateway.Region.ASIA_PACIFIC.name()),
    MERCHANT_URL("https://ap-gateway.mastercard.com/api/rest/version/53/merchant/TEST222205234001");

    String defValue;

    Config(String defValue) {
        this.defValue = defValue;
    }

    public String getValue(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(this.name(), defValue);
    }

    public void setValue(Context context, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(this.name(), value);
        editor.apply();
    }
}
