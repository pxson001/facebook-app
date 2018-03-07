package com.facebook.debug.tracer;

import android.util.SparseArray;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.TraceEvent.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: zero_rating2/clearable/default_optin/secondary_button_override_back_only_key */
public final class ThreadTrace {
    static final ThreadLocal<ThreadTrace> f426a = new C00131();
    public static int f427b = -1;
    private static final Comparator<TraceEvent> f428c = new C00142();
    private static final AtomicInteger f429d = new AtomicInteger(1);
    public final SparseArray<TraceEvent> f430e = new SparseArray();
    public TraceEvent[] f431f = new TraceEvent[100];
    public int f432g;
    public int f433h;

    /* compiled from: zero_rating2/clearable/default_optin/secondary_button_override_back_only_key */
    final class C00131 extends ThreadLocal<ThreadTrace> {
        C00131() {
        }

        protected final Object initialValue() {
            return new ThreadTrace();
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/secondary_button_override_back_only_key */
    final class C00142 implements Comparator<TraceEvent> {
        C00142() {
        }

        public final int compare(Object obj, Object obj2) {
            TraceEvent traceEvent = (TraceEvent) obj;
            TraceEvent traceEvent2 = (TraceEvent) obj2;
            long j = traceEvent.f508e - traceEvent.f509f;
            long j2 = traceEvent2.f508e - traceEvent2.f509f;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return 0;
        }
    }

    ThreadTrace() {
    }

    final int m904a(String str, Object[] objArr, boolean z) {
        Type type;
        m900d();
        int h = m903h();
        if (z) {
            type = Type.START_ASYNC;
        } else {
            type = Type.START;
        }
        TraceEvent a = TraceEvent.m1036a(type, h, str, objArr, -1, -1);
        m895a(a);
        this.f430e.append(h, a);
        return a.f505b;
    }

    final long m905a(int i, long j, boolean z) {
        long j2;
        long a = TracerClock.m909a();
        if (z) {
            j2 = 1000000 * j;
        } else {
            j2 = 3000000;
        }
        int indexOfKey = this.f430e.indexOfKey(i);
        if (indexOfKey < 0) {
            return -1;
        }
        TraceEvent traceEvent = (TraceEvent) this.f430e.valueAt(indexOfKey);
        this.f430e.removeAt(indexOfKey);
        a -= traceEvent.f508e;
        if (a < j2) {
            for (indexOfKey = this.f432g - 1; indexOfKey >= 0; indexOfKey--) {
                if (this.f431f[indexOfKey] == traceEvent) {
                    this.f431f[indexOfKey] = null;
                    this.f433h++;
                    traceEvent.m1040a();
                    break;
                }
            }
        } else {
            m895a(TraceEvent.m1037a(traceEvent));
        }
        return a;
    }

    private void m898c() {
        for (int i = 0; i < this.f432g; i++) {
            TraceEvent traceEvent = this.f431f[i];
            if (traceEvent != null) {
                if (traceEvent.f504a == Type.START) {
                    this.f430e.remove(traceEvent.f505b);
                }
                traceEvent.m1040a();
            }
        }
        this.f432g = 0;
        this.f433h = 0;
        this.f430e.clear();
    }

    final void m907a(String str, Object[] objArr) {
        m895a(TraceEvent.m1036a(Type.COMMENT, m903h(), str, objArr, -1, -1));
    }

    final long m908b() {
        for (int i = this.f432g - 1; i >= 0; i--) {
            TraceEvent traceEvent = this.f431f[i];
            if (traceEvent != null) {
                return traceEvent.f508e;
            }
        }
        return -1;
    }

    public final void m906a(int i, int i2, String str) {
        TraceFormatter.m5057a(i, i2, str, Arrays.asList(this.f431f).subList(0, this.f432g), this.f430e);
    }

    private void m900d() {
        long b = TracerClock.m910b();
        long b2;
        try {
            if (m902g() <= 2000) {
                b2 = TracerClock.m910b();
                if (b2 - b > 1000000) {
                    Integer.valueOf(0);
                    Long.valueOf(Thread.currentThread().getId());
                    Long.valueOf((b2 - b) / 1000000);
                    return;
                }
                return;
            }
            int e = (m901e() + 0) + m896b(1500);
            if (m902g() > 1500) {
                e += m899d(1500);
            }
            if (m902g() > 2000) {
                BLog.c("ThreadTrace", "Resetting because hit couldn't get under hard limit after normal pruning");
                m898c();
            } else if (m902g() > 1500) {
                BLog.a("ThreadTrace", "Couldn't get under soft limit after normal pruning");
            }
            b2 = TracerClock.m910b();
            if (b2 - b > 1000000 || e > 0) {
                Integer.valueOf(e);
                Long.valueOf(Thread.currentThread().getId());
                Long.valueOf((b2 - b) / 1000000);
            }
        } catch (Throwable th) {
            b2 = TracerClock.m910b();
            if (b2 - b > 1000000 || null > null) {
                Integer.valueOf(0);
                Long.valueOf(Thread.currentThread().getId());
                Long.valueOf((b2 - b) / 1000000);
            }
        }
    }

    private int m901e() {
        int i;
        int i2 = 0;
        long a = TracerClock.m909a();
        int i3 = 0;
        int i4 = 0;
        for (i = 0; i < this.f432g; i++) {
            TraceEvent traceEvent = this.f431f[i];
            if (traceEvent != null) {
                Type type = traceEvent.f504a;
                if (type == Type.START) {
                    i4++;
                } else if (type == Type.STOP) {
                    i4--;
                }
                if (a - traceEvent.f508e < 180000000000L) {
                    break;
                } else if (i4 == 0) {
                    i3 = i;
                }
            }
        }
        if (i3 > 0) {
            i = 0;
            while (i2 < i3 + 1) {
                TraceEvent traceEvent2 = this.f431f[i2];
                if (traceEvent2 != null) {
                    traceEvent2.m1040a();
                    this.f431f[i2] = null;
                    this.f433h++;
                    i++;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        Integer.valueOf(i);
        return i;
    }

    private int m896b(int i) {
        long c = m897c(i);
        if (c < 0) {
            return 0;
        }
        return m894a(c);
    }

    private long m897c(int i) {
        if (m902g() <= i) {
            return -1;
        }
        PriorityQueue priorityQueue = new PriorityQueue(this.f432g / 2, f428c);
        for (int i2 = 0; i2 < this.f432g; i2++) {
            TraceEvent traceEvent = this.f431f[i2];
            if (traceEvent != null && traceEvent.f504a == Type.STOP) {
                priorityQueue.add(traceEvent);
            }
        }
        int g = m902g() - i;
        Iterator it = priorityQueue.iterator();
        long j = 0;
        while (it.hasNext() && g > 0) {
            TraceEvent traceEvent2 = (TraceEvent) it.next();
            j = traceEvent2.f508e - traceEvent2.f509f;
            g -= 2;
        }
        return g > 0 ? Long.MAX_VALUE : j;
    }

    private int m894a(long j) {
        int i = 0;
        int[] iArr = new int[10];
        int i2 = 0;
        int i3 = 0;
        while (i < this.f432g) {
            TraceEvent traceEvent = this.f431f[i];
            if (traceEvent != null) {
                if (traceEvent.f504a == Type.START) {
                    if (i3 >= iArr.length) {
                        iArr = Arrays.copyOf(iArr, ((iArr.length * 3) / 2) + 1);
                    }
                    iArr[i3] = i;
                    i3++;
                } else if (traceEvent.f504a == Type.STOP) {
                    int i4 = iArr[i3 - 1];
                    i3--;
                    if (traceEvent.m1046f() - traceEvent.m1045e() <= j) {
                        TraceEvent traceEvent2 = this.f431f[i4];
                        traceEvent.m1040a();
                        traceEvent2.m1040a();
                        this.f431f[i] = null;
                        this.f431f[i4] = null;
                        this.f433h += 2;
                        i2 += 2;
                    }
                }
            }
            i++;
        }
        Integer.valueOf(i2);
        return i2;
    }

    private int m899d(int i) {
        int i2 = 0;
        int g = m902g() - i;
        int i3 = 0;
        while (i2 < this.f432g && g > 0) {
            TraceEvent traceEvent = this.f431f[i2];
            if (traceEvent != null && traceEvent.f504a == Type.COMMENT) {
                traceEvent.m1040a();
                this.f431f[i2] = null;
                this.f433h++;
                i3++;
                g--;
            }
            i2++;
        }
        Integer.valueOf(i3);
        return i3;
    }

    private int m902g() {
        return this.f432g - this.f433h;
    }

    private void m895a(TraceEvent traceEvent) {
        if (this.f433h * 8 > this.f432g) {
            int i = 0;
            for (int i2 = 0; i2 < this.f432g; i2++) {
                TraceEvent traceEvent2 = this.f431f[i2];
                if (traceEvent2 != null) {
                    this.f431f[i] = traceEvent2;
                    i++;
                }
            }
            this.f432g = i;
            this.f433h = 0;
        }
        if (this.f432g >= this.f431f.length) {
            this.f431f = (TraceEvent[]) Arrays.copyOf(this.f431f, (this.f431f.length * 2) + 1);
        }
        TraceEvent[] traceEventArr = this.f431f;
        int i3 = this.f432g;
        this.f432g = i3 + 1;
        traceEventArr[i3] = traceEvent;
    }

    private static int m903h() {
        int incrementAndGet = f429d.incrementAndGet();
        while (true) {
            if (incrementAndGet != f427b && incrementAndGet != 0) {
                return incrementAndGet;
            }
            incrementAndGet = f429d.incrementAndGet();
        }
    }
}
