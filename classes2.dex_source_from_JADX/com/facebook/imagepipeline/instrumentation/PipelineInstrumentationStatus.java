package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;

/* compiled from: page_link_menu_management?page_id=%s */
public class PipelineInstrumentationStatus {
    private final BaseAnalyticsConfig f10481a;
    private final Clock f10482b;
    private long f10483c;
    private TriState f10484d = TriState.UNSET;

    public PipelineInstrumentationStatus(BaseAnalyticsConfig baseAnalyticsConfig, Clock clock) {
        this.f10481a = baseAnalyticsConfig;
        this.f10482b = clock;
    }

    public final synchronized TriState m15600a() {
        if (m15599b()) {
            this.f10484d = this.f10481a.m3563a("image_pipeline_counters") ? TriState.YES : TriState.NO;
            this.f10483c = this.f10482b.mo211a();
        }
        return this.f10484d;
    }

    private synchronized boolean m15599b() {
        boolean z = true;
        synchronized (this) {
            if (this.f10484d != TriState.UNSET && this.f10482b.mo211a() - this.f10483c < 3600000) {
                z = false;
            }
        }
        return z;
    }
}
