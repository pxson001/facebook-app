package com.facebook.timeline.service;

import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: extra_message_as_group */
public class TimelineImagePrefetchDataSubscriber implements DataSubscriber<Void> {
    public final PrefetchListener f12714a;
    @GuardedBy("this")
    private int f12715b;
    public int f12716c;

    public TimelineImagePrefetchDataSubscriber(PrefetchListener prefetchListener) {
        this.f12714a = prefetchListener;
    }

    public final synchronized void m12666a(DataSource dataSource) {
        this.f12715b++;
        m12665a();
    }

    public final synchronized void m12667b(DataSource dataSource) {
        this.f12715b++;
        m12665a();
    }

    public final synchronized void m12668c(DataSource dataSource) {
        this.f12715b++;
        m12665a();
    }

    public final void m12669d(DataSource dataSource) {
    }

    private void m12665a() {
        if (this.f12715b == this.f12716c) {
            this.f12714a.m12598b();
        }
    }
}
