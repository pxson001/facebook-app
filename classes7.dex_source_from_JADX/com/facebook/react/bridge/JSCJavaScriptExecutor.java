package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: group_pinned_stories */
public class JSCJavaScriptExecutor extends JavaScriptExecutor {

    /* compiled from: group_pinned_stories */
    public class Factory implements com.facebook.react.bridge.JavaScriptExecutor.Factory {
        public final JavaScriptExecutor mo662a(WritableNativeMap writableNativeMap) {
            return new JSCJavaScriptExecutor(writableNativeMap);
        }
    }

    private native void initialize(WritableNativeMap writableNativeMap);

    static {
        SoLoader.a("reactnativejni");
    }

    public JSCJavaScriptExecutor(WritableNativeMap writableNativeMap) {
        initialize(writableNativeMap);
    }
}
