package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

/* compiled from: media_tray_nux_last_shown_time_ms */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    private final Consumer<T> f14522b;
    private final ProducerListener f14523c;
    private final String f14524d;
    private final String f14525e;

    protected abstract void mo2797b(T t);

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2) {
        this.f14522b = consumer;
        this.f14523c = producerListener;
        this.f14524d = str;
        this.f14525e = str2;
        this.f14523c.mo2106a(this.f14525e, this.f14524d);
    }

    protected void mo2796a(T t) {
        this.f14523c.mo2109a(this.f14525e, this.f14524d, this.f14523c.mo2110a(this.f14525e) ? m20938c(t) : null);
        this.f14522b.m20910b(t, true);
    }

    protected void mo2799a(Exception exception) {
        Map map;
        ProducerListener producerListener = this.f14523c;
        String str = this.f14525e;
        String str2 = this.f14524d;
        if (this.f14523c.mo2110a(this.f14525e)) {
            map = null;
        } else {
            map = null;
        }
        producerListener.mo2108a(str, str2, exception, map);
        this.f14522b.m20907a((Throwable) exception);
    }

    protected void mo2800b() {
        Map map;
        ProducerListener producerListener = this.f14523c;
        String str = this.f14525e;
        String str2 = this.f14524d;
        if (this.f14523c.mo2110a(this.f14525e)) {
            map = null;
        } else {
            map = null;
        }
        producerListener.mo2112b(str, str2, map);
        this.f14522b.m20908b();
    }

    protected Map<String, String> m20938c(T t) {
        return null;
    }
}
