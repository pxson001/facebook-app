package com.facebook.analytics.counter;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: valueOf */
public abstract class AnalyticsCounters {
    protected final CountersPrefWriter f1345a;
    public ConcurrentMap<String, Long> f1346b = Maps.m843e();

    protected abstract String mo360a();

    public AnalyticsCounters(@Nullable CountersPrefWriter countersPrefWriter) {
        this.f1345a = countersPrefWriter;
    }

    public final void m2591a(String str, long j) {
        boolean replace;
        do {
            Long l = (Long) this.f1346b.get(str);
            if (l != null) {
                replace = this.f1346b.replace(str, l, Long.valueOf(l.longValue() + j));
                continue;
            } else if (((Long) this.f1346b.putIfAbsent(str, Long.valueOf(j))) == null) {
                replace = true;
                continue;
            } else {
                replace = false;
                continue;
            }
        } while (!replace);
        mo2064e();
    }

    public final void m2590a(String str) {
        this.f1346b.remove(str);
    }

    public final void m2592b(String str, long j) {
        boolean replace;
        do {
            Long l = (Long) this.f1346b.get(str);
            if (l != null) {
                replace = this.f1346b.replace(str, l, Long.valueOf(j));
                continue;
            } else if (((Long) this.f1346b.putIfAbsent(str, Long.valueOf(j))) == null) {
                replace = true;
                continue;
            } else {
                replace = false;
                continue;
            }
        } while (!replace);
        mo2064e();
    }

    public synchronized void al_() {
        this.f1346b.clear();
    }

    public synchronized void mo2005a(HoneyClientEvent honeyClientEvent) {
        JsonNode c = m2593c();
        if (c.mo712e() > 0) {
            honeyClientEvent.m5085a(mo360a(), c);
        }
        al_();
    }

    public final JsonNode m2593c() {
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        for (Entry entry : this.f1346b.entrySet()) {
            if (((Long) entry.getValue()).longValue() != 0) {
                objectNode.m5130a((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
        }
        return objectNode;
    }

    private synchronized void mo2064e() {
        if (this.f1345a != null && this.f1345a.a(mo360a())) {
            this.f1345a.a(mo360a(), m2593c().toString());
            al_();
        }
    }
}
