package com.facebook.performancelogger;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.google.common.base.Objects;

/* compiled from: taggingProfileType */
public class HoneyPerformanceEvent extends HoneyClientEvent {
    private final MarkerType f3362c;

    public String toString() {
        return "perf:" + this.c + ":" + this.f3362c;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.c, this.f3362c});
    }
}
