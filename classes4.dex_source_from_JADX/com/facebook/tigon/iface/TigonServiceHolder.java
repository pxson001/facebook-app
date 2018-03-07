package com.facebook.tigon.iface;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: last_write_attempt_age_ms */
public abstract class TigonServiceHolder {
    @DoNotStrip
    protected final HybridData mHybridData;

    protected TigonServiceHolder(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
