package com.facebook.sequencelogger;

import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.perftestutils.logger.PerfTestLogger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: ui-thread */
public class SequenceImpl<T extends SequenceDefinition> implements Sequence<T> {
    static boolean f2042a = false;
    static boolean f2043b = false;
    public final T f2044c;
    private final String f2045d;
    private final MonotonicClock f2046e;
    public final SequenceData f2047f;
    public int f2048g;
    public boolean f2049h;
    public boolean f2050i;
    public boolean f2051j = false;

    SequenceImpl(T t, @Nullable String str, MonotonicClock monotonicClock, Clock clock, long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool) {
        this.f2044c = (AbstractSequenceDefinition) Preconditions.checkNotNull(t);
        this.f2045d = str;
        this.f2046e = monotonicClock;
        this.f2047f = new SequenceData(t.m1016d(), t.m1015b(), str, j, m4166a(j, clock, monotonicClock), t.m1014a(), immutableMap, bool);
        this.f2048g = 0;
    }

    public final Sequence<T> mo630e(String str) {
        return mo611a(str, null, this.f2046e.now());
    }

    public final Sequence<T> mo611a(String str, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        this.f2047f.a(str.toString(), j, immutableMap);
        if (f2042a) {
            BLog.a(this.f2044c.f486a, "Marked Event %s", new Object[]{str});
        }
        return this;
    }

    public final Sequence<T> mo620b(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.f2047f.b(str, str2);
        return this;
    }

    public final Sequence<T> mo610a(String str) {
        return mo615a(str, null, null, this.f2046e.now());
    }

    public final Sequence<T> mo614a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        return mo615a(str, str2, (ImmutableMap) immutableMap, this.f2046e.now());
    }

    public final Sequence<T> mo615a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        return mo616a(str, str2, immutableMap, j, null);
    }

    public final Sequence<T> mo616a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        Preconditions.checkNotNull(str);
        this.f2047f.a(str.toString(), str2, j, immutableMap, bool);
        if (f2042a) {
            BLog.a(this.f2044c.f486a, "Started Marker %s (%s)", new Object[]{str, str2});
        }
        return this;
    }

    public final Sequence<T> mo619b(String str) {
        return mo622b(str, null, null, this.f2046e.now());
    }

    public final Sequence<T> mo621b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        return mo622b(str, str2, immutableMap, this.f2046e.now());
    }

    public final Sequence<T> mo622b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        return mo623b(str, str2, immutableMap, j, null);
    }

    public final Sequence<T> mo623b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        long a = this.f2047f.a(str.toString(), str2, j, immutableMap, bool, false);
        if (f2043b) {
            PerfTestLogger.a(this.f2044c.m1015b(), str, str2, j, a);
        } else if (f2042a) {
            BLog.a(this.f2044c.m1015b(), "Stopped Marker %s (%s); Monotonic Timestamp (ms): %d; Elapsed: %d ms", new Object[]{str, str2, Long.valueOf(j), Long.valueOf(a)});
        }
        return this;
    }

    public final Sequence<T> mo625c(String str) {
        return mo627c(str, null, null, this.f2046e.now());
    }

    public final Sequence<T> mo626c(String str, String str2, ImmutableMap<String, String> immutableMap) {
        return mo627c(str, str2, immutableMap, this.f2046e.now());
    }

    public final Sequence<T> mo627c(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        long a = this.f2047f.a(str.toString(), str2, j, immutableMap, null, true);
        if (f2042a) {
            BLog.a(this.f2044c.m1015b(), "Failed Marker %s (%s); Elapsed: %d ms", new Object[]{str, str2, Long.valueOf(a)});
        }
        return this;
    }

    public final Sequence<T> mo629d(String str) {
        return mo613a(str, null, this.f2046e.now());
    }

    public final Sequence<T> mo612a(String str, @Nullable String str2) {
        return mo613a(str, str2, this.f2046e.now());
    }

    public final Sequence<T> mo613a(String str, @Nullable String str2, long j) {
        this.f2047f.a(str.toString(), str2, j);
        if (f2042a) {
            String str3 = this.f2044c.f486a;
            String str4 = "Cancelled Marker %s (%s) Was Bg: %s";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = str2;
            Boolean c = this.f2047f.c();
            objArr[2] = c != null ? Boolean.toString(c.booleanValue()) : "Unknown";
            BLog.a(str3, str4, objArr);
        }
        return this;
    }

    public final boolean mo631f(String str) {
        return mo628c(str, null);
    }

    public final boolean mo628c(String str, @Nullable String str2) {
        return this.f2047f.a(str, str2);
    }

    public final void m4176a(int i) {
        this.f2048g = i;
    }

    public final int m4190d() {
        return this.f2048g;
    }

    public final void m4177a(boolean z) {
        this.f2049h = z;
    }

    public final boolean m4193e() {
        return this.f2049h;
    }

    public final void m4184b(boolean z) {
        this.f2050i = z;
    }

    public final boolean m4194f() {
        return this.f2050i;
    }

    final long m4167a(long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool, List<String>... listArr) {
        return this.f2047f.a(j, immutableMap, bool, listArr);
    }

    final void m4197j() {
        this.f2047f.a();
    }

    @VisibleForTesting
    private static long m4166a(long j, Clock clock, MonotonicClock monotonicClock) {
        return (clock.mo211a() - monotonicClock.now()) + j;
    }

    final void m4196g(String str) {
        this.f2047f.a(this.f2046e.now(), str);
    }

    @Nullable
    public final String mo617a() {
        return this.f2045d;
    }

    public final int mo618b() {
        return this.f2044c.f490e;
    }

    public final long mo624c() {
        return this.f2047f.k;
    }
}
