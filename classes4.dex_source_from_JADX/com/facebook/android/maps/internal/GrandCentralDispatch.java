package com.facebook.android.maps.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* compiled from: duplicate_contact_id */
public class GrandCentralDispatch {
    private static final Dispatchable f13556a = new C06421();
    public static final BlockingQueue<Dispatchable> f13557b = new DelayQueue();
    private static final Handler f13558c = new Handler(Looper.getMainLooper());
    public static int f13559d = Integer.MAX_VALUE;
    private static int f13560e = Integer.MAX_VALUE;
    private static final int f13561f;
    private static final DispatchThread[] f13562g;

    /* compiled from: duplicate_contact_id */
    public abstract class Dispatchable implements Runnable, Delayed {
        public long f13497a;
        public long f13498b;
        public String f13499c;

        public abstract void run();

        public int compareTo(Object obj) {
            Delayed delayed = (Delayed) obj;
            if (delayed instanceof Dispatchable) {
                Dispatchable dispatchable = (Dispatchable) delayed;
                long j;
                if (this.f13498b == dispatchable.f13498b) {
                    j = this.f13497a - dispatchable.f13497a;
                    if (j > 0) {
                        return -1;
                    }
                    return j == 0 ? 0 : 1;
                } else {
                    j = this.f13498b - dispatchable.f13498b;
                    if (j >= 0) {
                        return j == 0 ? 0 : 1;
                    } else {
                        return -1;
                    }
                }
            }
            throw new IllegalArgumentException("Comparing a Dispatchable to a non-Dispatchable.");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r7) {
            /*
            r6 = this;
            r0 = 1;
            r1 = 0;
            if (r6 != r7) goto L_0x0005;
        L_0x0004:
            return r0;
        L_0x0005:
            r2 = r7 instanceof com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            r0 = r1;
            goto L_0x0004;
        L_0x000b:
            r7 = (com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable) r7;
            r2 = r6.f13497a;
            r4 = r7.f13497a;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 != 0) goto L_0x0025;
        L_0x0015:
            r2 = r6.f13499c;
            if (r2 != 0) goto L_0x0027;
        L_0x0019:
            r2 = r7.f13499c;
            if (r2 != 0) goto L_0x0025;
        L_0x001d:
            r2 = r6.f13498b;
            r4 = r7.f13498b;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 == 0) goto L_0x0004;
        L_0x0025:
            r0 = r1;
            goto L_0x0004;
        L_0x0027:
            r2 = r6.f13499c;
            r3 = r7.f13499c;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x0025;
        L_0x0031:
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable.equals(java.lang.Object):boolean");
        }

        public void mo971a() {
        }

        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.f13498b - SystemClock.uptimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* compiled from: duplicate_contact_id */
    final class C06421 extends Dispatchable {
        C06421() {
        }

        public final void run() {
        }
    }

    /* compiled from: duplicate_contact_id */
    final class DispatchThread extends Thread {
        public final void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    ((Dispatchable) GrandCentralDispatch.f13557b.take()).run();
                    GrandCentralDispatch.f13556a;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static {
        int max = Math.max((int) (((float) Runtime.getRuntime().availableProcessors()) * 1.5f), 3);
        f13561f = max;
        f13562g = new DispatchThread[max];
        for (max = 0; max < f13562g.length; max++) {
            f13562g[max] = new DispatchThread();
            f13562g[max].setName("GCD-Thread #" + max);
            f13562g[max].start();
        }
    }

    public static void m14421a(Dispatchable dispatchable) {
        int i = f13559d;
        f13559d = i - 1;
        dispatchable.f13497a = ((long) i) << 32;
        dispatchable.f13499c = null;
        dispatchable.f13498b = 0;
        f13557b.add(dispatchable);
    }

    public static void m14423a(String str) {
        for (Dispatchable dispatchable : f13557b) {
            if (str.equals(dispatchable.f13499c)) {
                f13557b.remove(dispatchable);
                dispatchable.mo971a();
            }
        }
    }

    public static void m14427c(Dispatchable dispatchable) {
        HandlerDetour.a(f13558c, dispatchable, 1458541436);
    }

    public static void m14425b(Dispatchable dispatchable, long j) {
        HandlerDetour.b(f13558c, dispatchable, j, -584405576);
    }

    public static void m14422a(Dispatchable dispatchable, String str, long j) {
        HandlerDetour.a(f13558c, dispatchable, str, SystemClock.uptimeMillis() + j, -1833826995);
    }

    public static void m14428d(Dispatchable dispatchable) {
        HandlerDetour.a(f13558c, dispatchable);
    }

    public static void m14426b(String str) {
        f13558c.removeCallbacksAndMessages(str);
    }
}
