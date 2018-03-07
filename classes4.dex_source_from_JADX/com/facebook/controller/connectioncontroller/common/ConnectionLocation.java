package com.facebook.controller.connectioncontroller.common;

/* compiled from: messenger_region */
public class ConnectionLocation {
    public static final ConnectionLocation f7941a = new ConnectionLocation(null, LocationType.INITIAL, true);
    public final String f7942b;
    public final LocationType f7943c;
    public final boolean f7944d;

    /* compiled from: messenger_region */
    public enum LocationType {
        INITIAL,
        BEFORE,
        AFTER
    }

    public ConnectionLocation(String str, LocationType locationType, boolean z) {
        this.f7942b = str;
        this.f7943c = locationType;
        this.f7944d = z;
    }

    public final String m8260a() {
        return this.f7942b;
    }

    public final LocationType m8261b() {
        return this.f7943c;
    }
}
