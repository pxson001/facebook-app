package com.facebook.localstats;

import com.facebook.analytics.counterlogger.CommunicationScheduler;
import com.facebook.analytics.counterlogger.CommunicationScheduler.Logger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.module.LocalStatsListenerForLoom;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: prompt_entry_point_analytics_extra */
public class LocalStatsLoggerImpl {
    Set<LocalStatsListener> f8760a = new HashSet();
    Set<LocalStatsValuesListener> f8761b;
    public Set<LocalStatsEventDefinition> f8762c = new HashSet();
    final ImmutableSet<Integer> f8763d;
    private final StatMap f8764e = new StatMap();
    private StatMap f8765f;
    private int f8766g = -1;

    public LocalStatsLoggerImpl(CommunicationScheduler communicationScheduler, @Nullable Set<LocalStatsValuesListener> set, Set<LocalStatsEventDefinition> set2) {
        this.f8761b = set;
        this.f8762c.add(new LocalStatsEventDefinition("counters", null));
        this.f8762c.addAll(set2);
        Builder builder = new Builder();
        for (LocalStatsEventDefinition localStatsEventDefinition : set2) {
            Iterator it = localStatsEventDefinition.f8768b.keySet().iterator();
            while (it.hasNext()) {
                builder.m4813c((Integer) it.next());
            }
        }
        this.f8763d = builder.m4812b();
        for (final LocalStatsEventDefinition localStatsEventDefinition2 : this.f8762c) {
            communicationScheduler.m12623a(localStatsEventDefinition2.f8767a, "quick_data", new Logger(this) {
                final /* synthetic */ LocalStatsLoggerImpl f8776b;

                public final JsonNode mo1706a(boolean z, int i) {
                    if (z) {
                        return this.f8776b.m13615a(localStatsEventDefinition2, i);
                    }
                    LocalStatsLoggerImpl.m13614b(this.f8776b, i);
                    return null;
                }
            });
        }
    }

    public final void m13620a(int i, short s, long j) {
        this.f8764e.m13625a(i, s, j);
        m13613b(i, s, j);
    }

    public final void m13619a(int i, short s) {
        this.f8764e.m13625a(i, s, 1);
        m13613b(i, s, 1);
    }

    public final void m13617a(int i, long j) {
        this.f8764e.m13625a(i, (short) 0, j);
        m13613b(i, (short) 0, j);
    }

    public final void m13618a(int i, String str) {
        this.f8764e.m13626a(i, (short) 0, str);
    }

    public final void m13616a(int i) {
        this.f8764e.m13625a(i, (short) 0, 1);
        m13613b(i, (short) 0, 1);
    }

    public final void m13621a(LocalStatsListener localStatsListener) {
        synchronized (this.f8760a) {
            this.f8760a.add(localStatsListener);
        }
    }

    @VisibleForTesting
    public final JsonNode m13615a(LocalStatsEventDefinition localStatsEventDefinition, int i) {
        m13614b(this, i);
        StatMap statMap = this.f8765f;
        Object obj = (statMap.f8772b == 0 && statMap.f8773c.size() == 0) ? 1 : null;
        return obj != null ? null : this.f8765f.m13624a(localStatsEventDefinition.f8768b, this.f8763d);
    }

    @VisibleForTesting
    public static void m13614b(LocalStatsLoggerImpl localStatsLoggerImpl, int i) {
        if (localStatsLoggerImpl.f8766g != i) {
            localStatsLoggerImpl.f8766g = i;
            localStatsLoggerImpl.m13612a();
            localStatsLoggerImpl.f8765f = localStatsLoggerImpl.f8764e.m13627b();
        }
    }

    private void m13612a() {
        synchronized (this.f8760a) {
            for (LocalStatsListener a : this.f8760a) {
                a.mo1834a();
            }
        }
    }

    private void m13613b(int i, short s, long j) {
        if (this.f8761b != null) {
            for (LocalStatsListenerForLoom localStatsListenerForLoom : this.f8761b) {
                com.facebook.loom.logger.Logger.a(32, EntryType.COUNTER, i, Integer.MIN_VALUE | (65535 & s), j);
            }
        }
    }
}
