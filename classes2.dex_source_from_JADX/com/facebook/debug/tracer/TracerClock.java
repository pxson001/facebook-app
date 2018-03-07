package com.facebook.debug.tracer;

/* compiled from: zero_rating2/clearable/default_optin/secondary_button_intent_key */
public class TracerClock {
    private static volatile long f434a = -1;

    public static long m909a() {
        return f434a != -1 ? f434a : System.nanoTime();
    }

    public static long m910b() {
        return System.nanoTime();
    }
}
