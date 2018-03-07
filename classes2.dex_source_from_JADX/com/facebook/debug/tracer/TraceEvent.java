package com.facebook.debug.tracer;

import android.os.SystemClock;
import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.BasicAllocator;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.debug.log.BLog;

/* compiled from: zero_rating2/allow_zero_rating_on_wifi */
public class TraceEvent {
    private static final ObjectPool<TraceEvent> f503i;
    public Type f504a;
    public int f505b;
    public String f506c;
    public Object[] f507d;
    public long f508e;
    public long f509f;
    private long f510g;
    private long f511h;

    /* compiled from: zero_rating2/allow_zero_rating_on_wifi */
    public enum Type {
        START,
        STOP,
        START_ASYNC,
        STOP_ASYNC,
        COMMENT,
        SPAWN;

        public final boolean isStartLikeEvent() {
            return this == START || this == START_ASYNC;
        }

        public final boolean isStopLikeEvent() {
            return this == STOP || this == STOP_ASYNC;
        }
    }

    /* compiled from: zero_rating2/allow_zero_rating_on_wifi */
    final class C00211 extends BasicAllocator<TraceEvent> {
        C00211(Class cls) {
            super(cls);
        }

        public final void mo87a(Object obj) {
            TraceEvent traceEvent = (TraceEvent) obj;
            traceEvent.f506c = null;
            traceEvent.f507d = null;
        }

        public final Object mo86a() {
            return new TraceEvent();
        }
    }

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(TraceEvent.class, AwakeTimeSinceBootClock.INSTANCE);
        objectPoolBuilder.f517f = new C00211(TraceEvent.class);
        f503i = objectPoolBuilder.m1047a();
    }

    public static TraceEvent m1036a(Type type, int i, String str, Object[] objArr, long j, long j2) {
        TraceEvent traceEvent = (TraceEvent) f503i.m1057a();
        traceEvent.f504a = type;
        traceEvent.f505b = i;
        traceEvent.f507d = objArr;
        traceEvent.f506c = str;
        traceEvent.f510g = SystemClock.currentThreadTimeMillis();
        traceEvent.f508e = TracerClock.m909a();
        traceEvent.f509f = j;
        traceEvent.f511h = j2;
        return traceEvent;
    }

    final void m1040a() {
        f503i.m1058a((Object) this);
    }

    public final int m1042b() {
        return this.f505b;
    }

    static TraceEvent m1037a(TraceEvent traceEvent) {
        return m1036a(traceEvent.f504a == Type.START ? Type.STOP : Type.STOP_ASYNC, traceEvent.f505b, traceEvent.f506c, traceEvent.f507d, traceEvent.f508e, traceEvent.f510g);
    }

    public final Type m1043c() {
        return this.f504a;
    }

    public final String m1044d() {
        if (this.f507d != null) {
            try {
                this.f506c = StringFormatUtil.a(this.f506c, this.f507d);
                this.f507d = null;
            } catch (Throwable e) {
                BLog.c("TraceEvent", "Bad format string", e);
                this.f507d = null;
            }
        }
        return this.f506c;
    }

    public final long m1045e() {
        return this.f509f;
    }

    public final long m1046f() {
        return this.f508e;
    }

    final void m1041a(StringBuilder stringBuilder, long j, long j2, int i) {
        if (j2 == -1) {
            stringBuilder.append("-----");
        } else {
            stringBuilder.append(m1039b((this.f508e - j2) / 1000000));
        }
        stringBuilder.append(" ");
        stringBuilder.append(m1038a((this.f508e - j) / 1000000));
        if (this.f504a == Type.START) {
            stringBuilder.append(" Start    ...     ...   ");
        } else if (this.f504a == Type.START_ASYNC) {
            stringBuilder.append(" AStart   ...     ...   ");
        } else if (this.f504a == Type.STOP || this.f504a == Type.STOP_ASYNC) {
            stringBuilder.append(" Done ");
            long j3 = this.f510g - this.f511h;
            stringBuilder.append(m1039b((this.f508e - this.f509f) / 1000000));
            stringBuilder.append(" ms ");
            stringBuilder.append(m1039b(j3));
            stringBuilder.append(" ms ");
        } else if (this.f504a != Type.SPAWN) {
            stringBuilder.append(" Comment  ...     ...   ");
        }
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("|  ");
        }
        stringBuilder.append(m1044d());
    }

    public String toString() {
        return m1044d();
    }

    private static String m1039b(long j) {
        StringBuilder stringBuilder = new StringBuilder(10);
        long round = (long) Math.round((float) j);
        if (round < 10) {
            stringBuilder.append("____");
        } else if (round < 100) {
            stringBuilder.append("___");
        } else if (round < 1000) {
            stringBuilder.append("__");
        } else if (round < 10000) {
            stringBuilder.append("_");
        }
        stringBuilder.append(round);
        return stringBuilder.toString();
    }

    static String m1038a(long j) {
        long round = (long) Math.round((float) j);
        return Long.toString(Math.max(0, (round / 1000) % 60) + 100).substring(1, 3) + '.' + Long.toString(Math.max(round % 1000, 0) + 1000).substring(1, 4);
    }
}
