package com.facebook.loom.provider;

import com.facebook.loom.core.TraceEvents;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: zero_rating2/clearable/default_optin/clickable_link_url_key */
public final class NativeEventProvider {
    static native void insertNativeAnnotations();

    static native void insertNativeCounters();

    public static void m987a() {
        if (TraceEvents.a) {
            insertNativeAnnotations();
        }
    }

    public static void m988b() {
        if (TraceEvents.a) {
            insertNativeCounters();
        }
    }
}
