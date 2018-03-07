package com.facebook.react.cxxbridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: graphNotificationsSettings */
public class ProxyJavaScriptExecutor extends JavaScriptExecutor {
    private static native HybridData initHybrid(JavaJSExecutor javaJSExecutor);

    static {
        SoLoader.a("reactnativejnifb");
    }
}
