package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: get_notified_notif_success */
public class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    private static native HybridData initHybrid();

    private native void pushNativeArray(WritableNativeArray writableNativeArray);

    private native void pushNativeMap(WritableNativeMap writableNativeMap);

    public native void pushBoolean(boolean z);

    public native void pushDouble(double d);

    public native void pushInt(int i);

    public native void pushNull();

    public native void pushString(String str);

    static {
        SoLoader.a("reactnativejni");
    }

    public WritableNativeArray() {
        super(initHybrid());
    }

    public final void mo688a(WritableArray writableArray) {
        boolean z = writableArray == null || (writableArray instanceof WritableNativeArray);
        Assertions.a(z, "Illegal type provided");
        pushNativeArray((WritableNativeArray) writableArray);
    }

    public final void mo689a(WritableMap writableMap) {
        boolean z = writableMap == null || (writableMap instanceof WritableNativeMap);
        Assertions.a(z, "Illegal type provided");
        pushNativeMap((WritableNativeMap) writableMap);
    }
}
