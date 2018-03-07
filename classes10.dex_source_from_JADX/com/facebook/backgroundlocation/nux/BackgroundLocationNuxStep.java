package com.facebook.backgroundlocation.nux;

import com.facebook.common.util.StringLocaleUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: done_click */
public enum BackgroundLocationNuxStep {
    SHARING("sharing"),
    COMPLETED("completed"),
    SHARING_UPSELL("sharing_upsell");
    
    private static final ImmutableMap<String, BackgroundLocationNuxStep> mStepNameMap = null;
    public final String stepName;

    static {
        Builder builder = ImmutableMap.builder();
        BackgroundLocationNuxStep[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            BackgroundLocationNuxStep backgroundLocationNuxStep = values[i];
            builder.b(StringLocaleUtil.a(backgroundLocationNuxStep.stepName), backgroundLocationNuxStep);
            i++;
        }
        mStepNameMap = builder.b();
    }

    private BackgroundLocationNuxStep(String str) {
        this.stepName = str;
    }

    public static BackgroundLocationNuxStep fromStepName(String str) {
        return (BackgroundLocationNuxStep) mStepNameMap.get(StringLocaleUtil.a(str));
    }
}
