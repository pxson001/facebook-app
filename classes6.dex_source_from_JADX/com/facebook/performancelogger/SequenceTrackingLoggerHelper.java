package com.facebook.performancelogger;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: tag_uid */
public class SequenceTrackingLoggerHelper {
    private final PerformanceLogger f3364a;
    public final String f3365b;
    private final boolean f3366c;
    @Nullable
    private final String f3367d;

    public SequenceTrackingLoggerHelper(PerformanceLogger performanceLogger, double d) {
        this(performanceLogger, Math.random() < d, null);
    }

    private SequenceTrackingLoggerHelper(PerformanceLogger performanceLogger, boolean z, @Nullable String str) {
        this.f3364a = performanceLogger;
        this.f3366c = z;
        this.f3365b = SafeUUIDGenerator.a().toString();
        this.f3367d = str;
    }

    public final MarkerConfig m4422a(int i, String str) {
        MarkerConfig markerConfig = new MarkerConfig(i, str);
        markerConfig.e = this.f3365b;
        markerConfig.a(this.f3366c ? 1.0d : 0.0d);
        Map c = Maps.c();
        c.put("session_id", this.f3365b);
        if (this.f3367d != null) {
            c.put("parent_session_id", this.f3367d);
        }
        markerConfig.a(c);
        return markerConfig;
    }
}
