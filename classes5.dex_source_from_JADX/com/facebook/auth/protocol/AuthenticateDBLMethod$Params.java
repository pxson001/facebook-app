package com.facebook.auth.protocol;

import android.location.Location;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import javax.annotation.Nullable;

/* compiled from: supports_event_stories */
public class AuthenticateDBLMethod$Params {
    public final DeviceBasedLoginCredentials f2304a;
    public final String f2305b;
    public final Location f2306c;
    public final boolean f2307d;
    public final String f2308e;

    public AuthenticateDBLMethod$Params(DeviceBasedLoginCredentials deviceBasedLoginCredentials, String str, @Nullable Location location, boolean z, @Nullable String str2) {
        this.f2304a = deviceBasedLoginCredentials;
        this.f2305b = str;
        this.f2306c = location;
        this.f2307d = z;
        this.f2308e = str2;
    }
}
