package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: get_notified_notif_interrupetd */
public class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    private native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private native void putNativeArray(String str, WritableNativeArray writableNativeArray);

    private native void putNativeMap(String str, WritableNativeMap writableNativeMap);

    public native void putBoolean(String str, boolean z);

    public native void putDouble(String str, double d);

    public native void putInt(String str, int i);

    public native void putNull(String str);

    public native void putString(String str, String str2);

    static {
        SoLoader.a("reactnativejni");
    }

    public final void mo696a(String str, WritableMap writableMap) {
        boolean z = writableMap == null || (writableMap instanceof WritableNativeMap);
        Assertions.a(z, "Illegal type provided");
        putNativeMap(str, (WritableNativeMap) writableMap);
    }

    public final void mo695a(String str, WritableArray writableArray) {
        boolean z = writableArray == null || (writableArray instanceof WritableNativeArray);
        Assertions.a(z, "Illegal type provided");
        putNativeArray(str, (WritableNativeArray) writableArray);
    }

    public final void m13561a(ReadableMap readableMap) {
        Assertions.a(readableMap instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) readableMap);
    }
}
