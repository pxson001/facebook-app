package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: campaign_type */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* compiled from: campaign_type */
    public final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable f7178a = LongAddables.m13178a();
        private final LongAddable f7179b = LongAddables.m13178a();
        private final LongAddable f7180c = LongAddables.m13178a();
        private final LongAddable f7181d = LongAddables.m13178a();
        private final LongAddable f7182e = LongAddables.m13178a();
        private final LongAddable f7183f = LongAddables.m13178a();

        public final void m13144a(int i) {
            this.f7178a.mo875a((long) i);
        }

        public final void m13146b(int i) {
            this.f7179b.mo875a((long) i);
        }

        public final void m13145a(long j) {
            this.f7180c.mo874a();
            this.f7182e.mo875a(j);
        }

        public final void m13147b(long j) {
            this.f7181d.mo874a();
            this.f7182e.mo875a(j);
        }

        public final void m13143a() {
            this.f7183f.mo874a();
        }
    }

    protected AbstractCache() {
    }
}
