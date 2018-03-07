package com.facebook.qe.api;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* compiled from: unknown_priority */
public class UniqueDeviceIdentityProvider {
    private final Context f1942a;

    public UniqueDeviceIdentityProvider(Context context) {
        this.f1942a = context;
    }

    public final String m3856a() {
        SharedPreferences sharedPreferences = this.f1942a.getSharedPreferences("QuickerExperimentUniqueDeviceIdPrefs", 0);
        String string = sharedPreferences.getString("qe_device_id", null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("qe_device_id", string).apply();
        }
        return string;
    }
}
