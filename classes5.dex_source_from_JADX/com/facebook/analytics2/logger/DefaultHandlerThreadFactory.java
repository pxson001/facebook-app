package com.facebook.analytics2.logger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;

/* compiled from: third_party_impression_logging_needed */
public class DefaultHandlerThreadFactory implements HandlerThreadFactory {
    public DefaultHandlerThreadFactory(Context context) {
    }

    @SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor"})
    public final HandlerThread m2659a(String str) {
        return new HandlerThread(str);
    }

    @SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor"})
    public final HandlerThread m2660a(String str, int i) {
        return new HandlerThread(str, i);
    }
}
