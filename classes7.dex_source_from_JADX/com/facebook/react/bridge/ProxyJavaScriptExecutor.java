package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: graphNotificationsSettings */
public class ProxyJavaScriptExecutor extends JavaScriptExecutor {
    @Nullable
    private JavaJSExecutor f11534a;

    private native void initialize(JavaJSExecutor javaJSExecutor);

    static {
        SoLoader.a("reactnativejni");
    }

    public final void mo667a() {
        if (this.f11534a != null) {
            this.f11534a = null;
        }
    }
}
