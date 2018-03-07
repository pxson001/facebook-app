package com.facebook.tigon.javaservice;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: last_visible_action_id DESC */
public abstract class AbstractRequestToken {
    @DoNotStrip
    private HybridData mHybridData;

    @DoNotStrip
    public abstract void cancel();

    @DoNotStrip
    public abstract void changePriority(int i);

    protected AbstractRequestToken(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
