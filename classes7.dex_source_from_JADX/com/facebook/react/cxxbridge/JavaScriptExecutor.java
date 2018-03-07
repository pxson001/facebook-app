package com.facebook.react.cxxbridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: group_product_feed */
public abstract class JavaScriptExecutor {
    private final HybridData mHybridData;

    /* compiled from: group_product_feed */
    public interface Factory {
        JavaScriptExecutor mo716a();
    }

    protected JavaScriptExecutor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
