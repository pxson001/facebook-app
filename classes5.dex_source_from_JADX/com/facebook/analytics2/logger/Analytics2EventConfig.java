package com.facebook.analytics2.logger;

import javax.annotation.Nullable;

/* compiled from: threaded_comments */
public class Analytics2EventConfig {
    @Nullable
    public final String f1947a;
    public final String f1948b;
    public final boolean f1949c;
    public final EventLogType f1950d;
    public final boolean f1951e;

    public static Analytics2EventConfig m2621a(@Nullable String str, String str2, boolean z, EventLogType eventLogType, boolean z2) {
        return new Analytics2EventConfig(str, str2, z, eventLogType, z2);
    }

    private Analytics2EventConfig(@Nullable String str, String str2, boolean z, EventLogType eventLogType, boolean z2) {
        this.f1947a = str;
        this.f1948b = str2;
        this.f1949c = z;
        this.f1950d = eventLogType;
        this.f1951e = z2;
    }
}
