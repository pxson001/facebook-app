package com.facebook.messaging.prefs.omnistore;

/* compiled from: destination_place_id */
public enum MessengerOmnistoreUserPrefsKey {
    LOW_DATA_MODE_ENABLED("low_data_mode_enabled"),
    EMOJI_COLOR_PREF("emoji_color_pref");
    
    public final String keyString;

    private MessengerOmnistoreUserPrefsKey(String str) {
        this.keyString = str;
    }
}
