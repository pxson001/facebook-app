package com.facebook.messaging.send.client;

import com.facebook.android.maps.model.LatLng;
import com.facebook.maps.ExternalMapLauncher;

/* compiled from: delete_failed_dialog */
public class NonXmaLocationTextCreator {
    public static final String f16664a = System.getProperty("line.separator");

    public static String m16672a(LatLng latLng) {
        return ExternalMapLauncher.a(latLng.a, latLng.b);
    }
}
