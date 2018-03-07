package com.facebook.multifeed.ranking.core.value_model;

import com.facebook.inject.Assisted;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import javax.inject.Inject;

/* compiled from: gnustl_shared */
public class ClientValueModelHolder {
    @DoNotStrip
    private final HybridData mHybridData;

    private static native HybridData initHybrid(String str, String str2);

    public native double score(String[] strArr, String[] strArr2, String str);

    static {
        SoLoader.a("value_model_holder-jni");
    }

    @Inject
    public ClientValueModelHolder(@Assisted String str, @Assisted String str2) {
        this.mHybridData = initHybrid(str, str2);
    }
}
