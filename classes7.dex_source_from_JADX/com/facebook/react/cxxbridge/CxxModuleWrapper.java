package com.facebook.react.cxxbridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ExecutorToken;
import com.facebook.react.bridge.JsonWriter;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModule$NativeMethod;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.soloader.SoLoader;
import java.util.Map;

@DoNotStrip
/* compiled from: getBlob */
public class CxxModuleWrapper implements NativeModule {
    @DoNotStrip
    private HybridData mHybridData;

    @DoNotStrip
    /* compiled from: getBlob */
    class MethodWrapper implements NativeModule$NativeMethod {
        @DoNotStrip
        HybridData mHybridData = initHybrid();

        public native HybridData initHybrid();

        public native void invoke(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray);

        MethodWrapper() {
        }

        public final String mo640c() {
            return "remote";
        }
    }

    private native HybridData initHybrid(String str, String str2);

    public native String getConstantsJson();

    public native Map<String, NativeModule$NativeMethod> getMethods();

    public native String getName();

    static {
        SoLoader.a("reactnativejnifb");
    }

    public final void m13654a(JsonWriter jsonWriter, String str) {
        String constantsJson = getConstantsJson();
        if (constantsJson != null && !constantsJson.isEmpty()) {
            jsonWriter.m13478a(str).m13483c(constantsJson);
        }
    }

    public final void m13655c() {
    }

    public final boolean m13656d() {
        return false;
    }

    public final boolean m13658f() {
        return false;
    }

    public final void m13657e() {
        this.mHybridData.resetNative();
    }

    protected CxxModuleWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
