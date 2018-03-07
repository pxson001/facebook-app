package com.facebook.auth.protocol;

import android.location.Location;
import com.facebook.auth.credentials.WorkUserSwitchCredentials;
import javax.annotation.Nullable;

/* compiled from: suggesters */
public class WorkAccountSwitchMethod$Params {
    public final WorkUserSwitchCredentials f2373a;
    public final String f2374b;
    public final Location f2375c;
    public final boolean f2376d;
    private final String f2377e;

    public WorkAccountSwitchMethod$Params(WorkUserSwitchCredentials workUserSwitchCredentials, String str, @Nullable Location location, boolean z, @Nullable String str2) {
        this.f2373a = workUserSwitchCredentials;
        this.f2374b = str;
        this.f2375c = location;
        this.f2376d = z;
        this.f2377e = str2;
    }
}
