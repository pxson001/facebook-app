package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.counter.AnalyticsCounters;
import com.facebook.analytics.counter.CountersPrefWriter;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.memory.BasePool;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: page_link */
public class DefaultPoolStatsTracker extends AnalyticsCounters implements FbPoolStatsTracker {
    private final Clock f10485b;
    private final String f10486c;
    private List<JsonNode> f10487d = Lists.m1306b();
    private Map<String, Integer> f10488e;
    private long f10489f;
    private BasePool f10490g;

    public DefaultPoolStatsTracker(@Nullable CountersPrefWriter countersPrefWriter, Clock clock, String str) {
        super(countersPrefWriter);
        this.f10485b = (Clock) Preconditions.a(clock);
        this.f10486c = (String) Preconditions.a(str);
    }

    public final void mo2006a(BasePool basePool) {
        this.f10490g = basePool;
        m15603f();
    }

    public final void mo2005a(HoneyClientEvent honeyClientEvent) {
        if (!this.f10487d.isEmpty()) {
            honeyClientEvent.m5086a(mo360a(), this.f10487d);
            this.f10487d.clear();
        }
    }

    public final void mo2004a(int i) {
        m15602e();
        m2591a("value_reuse_" + i, 1);
    }

    public final void mo2008b() {
        m15602e();
        m2591a("soft_cap_exceeded", 1);
    }

    public final void ak_() {
        m15602e();
        m2591a("hard_cap_exceeded", 1);
    }

    public final void mo2009b(int i) {
        m15602e();
        m2591a("pool_alloc_" + i, 1);
    }

    public final void mo2010c(int i) {
        m15602e();
    }

    public final void mo2011d(int i) {
        m15602e();
    }

    protected final String mo360a() {
        return this.f10486c;
    }

    private void m15602e() {
        if (this.f10485b.mo211a() - this.f10489f > 300000) {
            for (Entry entry : this.f10488e.entrySet()) {
                m2592b((String) entry.getKey(), (long) ((Integer) entry.getValue()).intValue());
            }
            this.f10487d.add(m2593c());
            m15603f();
        }
    }

    private void m15603f() {
        al_();
        this.f10489f = this.f10485b.mo211a();
        this.f10488e = this.f10490g.m15741b();
    }
}
