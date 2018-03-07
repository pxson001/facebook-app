package com.facebook.react.cxxbridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: group_pinned_stories */
public class JSCJavaScriptExecutor extends JavaScriptExecutor {

    /* compiled from: group_pinned_stories */
    public class Factory implements com.facebook.react.cxxbridge.JavaScriptExecutor.Factory {
        private ReadableNativeArray f11616a;

        public Factory(WritableNativeMap writableNativeMap) {
            ReadableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.mo689a((WritableMap) writableNativeMap);
            this.f11616a = writableNativeArray;
        }

        public final JavaScriptExecutor mo716a() {
            return new JSCJavaScriptExecutor(this.f11616a);
        }
    }

    private static native HybridData initHybrid(ReadableNativeArray readableNativeArray);

    static {
        SoLoader.a("reactnativejnifb");
    }

    public JSCJavaScriptExecutor(ReadableNativeArray readableNativeArray) {
        super(initHybrid(readableNativeArray));
    }
}
