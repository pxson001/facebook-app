package com.facebook.omnistore;

import com.facebook.soloader.SoLoader;

/* compiled from: mInteractingStateLock */
public class Prerequisites {
    private static volatile boolean sInitialized;

    public static synchronized void ensure() {
        synchronized (Prerequisites.class) {
            if (!sInitialized) {
                SoLoader.a("omnistore");
                sInitialized = true;
            }
        }
    }
}
