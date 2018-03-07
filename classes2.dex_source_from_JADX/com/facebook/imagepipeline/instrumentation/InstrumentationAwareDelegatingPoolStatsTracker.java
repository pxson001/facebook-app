package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.memory.BasePool;

/* compiled from: page_identity_video */
public class InstrumentationAwareDelegatingPoolStatsTracker implements FbPoolStatsTracker {
    private final PipelineInstrumentationStatus f10491a;
    private final FbPoolStatsTracker f10492b;

    public InstrumentationAwareDelegatingPoolStatsTracker(PipelineInstrumentationStatus pipelineInstrumentationStatus, FbPoolStatsTracker fbPoolStatsTracker) {
        this.f10491a = pipelineInstrumentationStatus;
        this.f10492b = fbPoolStatsTracker;
    }

    public final void mo2006a(BasePool basePool) {
        this.f10492b.mo2006a(basePool);
    }

    public final void mo2005a(HoneyClientEvent honeyClientEvent) {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2005a(honeyClientEvent);
        }
    }

    public final void mo2004a(int i) {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2011d(i);
        }
    }

    public final void mo2008b() {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2008b();
        }
    }

    public final void ak_() {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.ak_();
        }
    }

    public final void mo2009b(int i) {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2009b(i);
        }
    }

    public final void mo2010c(int i) {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2010c(i);
        }
    }

    public final void mo2011d(int i) {
        if (this.f10491a.m15600a() == TriState.YES) {
            this.f10492b.mo2011d(i);
        }
    }
}
