package com.facebook.iorg.common.zero.interfaces;

import com.facebook.analytics2.logger.Analytics2EventConfig;
import com.facebook.analytics2.logger.EventLogType;
import javax.annotation.Nullable;

/* compiled from: TOPICS_AND_REGION */
public abstract class ZeroAnalyticsEventShim {
    public final String f13892n;
    @Nullable
    public final String f13893o;
    public final Analytics2EventConfig f13894p;

    ZeroAnalyticsEventShim(String str, @Nullable String str2) {
        this.f13892n = str;
        this.f13893o = str2;
        this.f13894p = Analytics2EventConfig.m2621a(str2 == null ? null : str2.toString(), str, false, EventLogType.CLIENT_EVENT, false);
    }
}
