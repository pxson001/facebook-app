package com.facebook.bugreporter.analytics;

import android.content.Context;
import javax.inject.Inject;

/* compiled from: android.media.metadata.ALBUM */
public class NetworkUtils {
    public final Context f10729a;

    /* compiled from: android.media.metadata.ALBUM */
    public enum ConnectionType {
        NoConnection,
        Wifi,
        Mobile,
        Other
    }

    /* compiled from: android.media.metadata.ALBUM */
    public enum MobileConnectionSubtype {
        G2,
        G3,
        G4,
        OtherMobile
    }

    @Inject
    public NetworkUtils(Context context) {
        this.f10729a = context;
    }
}
