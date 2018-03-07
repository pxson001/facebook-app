package com.facebook.tigon.tigonapi;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonPriorityData;

@DoNotStrip
/* compiled from: no_campaign */
class TigonXplatRequestToken implements TigonRequestToken {
    @DoNotStrip
    private final HybridData mHybridData;

    private native void changePriority(int i, int i2);

    public native void cancel();

    @DoNotStrip
    private TigonXplatRequestToken(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final void mo132a(TigonPriorityData tigonPriorityData) {
        changePriority(tigonPriorityData.a, tigonPriorityData.b);
    }
}
