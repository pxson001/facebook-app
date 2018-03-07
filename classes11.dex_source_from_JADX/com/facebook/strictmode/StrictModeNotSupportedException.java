package com.facebook.strictmode;

import android.os.Build;
import android.os.Build.VERSION;

/* compiled from: No selected payment method */
public class StrictModeNotSupportedException extends Exception {
    public StrictModeNotSupportedException(String str) {
        this(str, null);
    }

    public StrictModeNotSupportedException(String str, Throwable th) {
        super("Problem with setting custom StrictMode: " + str + " " + String.format("[%d, %s]", new Object[]{Integer.valueOf(VERSION.SDK_INT), Build.MODEL}), th);
    }
}
