package com.facebook.react.bridge.queue;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: getStatusCode */
public class NativeRunnableDeprecated extends Countable implements Runnable {
    public native void run();

    @DoNotStrip
    private NativeRunnableDeprecated() {
    }
}
