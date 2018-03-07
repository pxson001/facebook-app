package com.facebook.http.debug;

import com.google.common.collect.Maps;
import java.util.TreeMap;

/* compiled from: lifetime_count */
public class Histogram {
    private final TreeMap<Long, Counter> f17620a = Maps.m844f();
    private long f17621b;

    /* compiled from: lifetime_count */
    class Counter {
        public long f17622a;
    }

    public final synchronized void m24791a(long j) {
        Counter counter = (Counter) this.f17620a.get(Long.valueOf(j));
        if (counter == null) {
            counter = new Counter();
            this.f17620a.put(Long.valueOf(j), counter);
        }
        r0.f17622a++;
        this.f17621b++;
    }
}
