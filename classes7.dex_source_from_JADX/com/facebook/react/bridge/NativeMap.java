package com.facebook.react.bridge;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: group_composer */
public abstract class NativeMap extends Countable {
    private native void initialize();

    public native String toString();

    static {
        SoLoader.a("reactnativejni");
    }

    public NativeMap() {
        initialize();
    }
}
