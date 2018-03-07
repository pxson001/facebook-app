package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: giphy.gif */
public class ReadableNativeArray extends NativeArray implements ReadableArray {
    public native ReadableNativeArray getArray(int i);

    public native boolean getBoolean(int i);

    public native double getDouble(int i);

    public native int getInt(int i);

    public native ReadableNativeMap getMap(int i);

    public native String getString(int i);

    public native ReadableType getType(int i);

    public native boolean isNull(int i);

    public native int size();

    public final /* synthetic */ ReadableArray mo668a(int i) {
        return getArray(i);
    }

    public final /* synthetic */ ReadableMap mo669b(int i) {
        return getMap(i);
    }

    static {
        SoLoader.a("reactnativejni");
    }

    protected ReadableNativeArray(HybridData hybridData) {
        super(hybridData);
    }
}
