package com.facebook.common.wakelock;

import android.os.PowerManager;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: foreground_source */
public class FbWakeLockManager {
    private static volatile FbWakeLockManager f23406g;
    private final PowerManager f23407a;
    public final MonotonicClock f23408b;
    public final ScheduledExecutorService f23409c;
    private final Map<String, WakeLock> f23410d = new HashMap();
    private long f23411e = 0;
    private int f23412f = 0;

    /* compiled from: foreground_source */
    public class WakeLock {
        Runnable f23413a = new C09501(this);
        final /* synthetic */ FbWakeLockManager f23414b;
        private final android.os.PowerManager.WakeLock f23415c;
        public final String f23416d;
        private final String f23417e;
        private int f23418f;
        public final int f23419g;
        private boolean f23420h = true;
        private boolean f23421i = false;
        private boolean f23422j;
        private Map<String, Long> f23423k;
        private int f23424l = 0;
        private long f23425m = 0;
        private long f23426n = 0;

        /* compiled from: foreground_source */
        class C09501 implements Runnable {
            final /* synthetic */ WakeLock f23427a;

            C09501(WakeLock wakeLock) {
                this.f23427a = wakeLock;
            }

            public void run() {
                this.f23427a.m31693d();
            }
        }

        WakeLock(FbWakeLockManager fbWakeLockManager, android.os.PowerManager.WakeLock wakeLock, int i, String str) {
            this.f23414b = fbWakeLockManager;
            this.f23415c = wakeLock;
            this.f23419g = i;
            this.f23416d = str;
            this.f23423k = new HashMap();
            this.f23417e = this.f23416d + ((int) (Math.random() * 1000.0d));
        }

        public final String m31687a() {
            return this.f23417e;
        }

        public final synchronized void m31689a(String str, long j) {
            Preconditions.checkState(m31694e(), "only add to extra if the wakelock is being held");
            Long l = (Long) this.f23423k.get(str);
            if (l == null) {
                this.f23423k.put(str, Long.valueOf(j));
            } else {
                this.f23423k.put(str, Long.valueOf(l.longValue() + j));
            }
        }

        public final Map<String, Long> m31691b() {
            return Collections.unmodifiableMap(this.f23423k);
        }

        public final synchronized void m31692c() {
            m31688a(-1);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void m31688a(long r4) {
            /*
            r3 = this;
            monitor-enter(r3);
            r3.m31686l();	 Catch:{ all -> 0x0041 }
            r0 = r3.f23420h;	 Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0010;
        L_0x0008:
            r0 = r3.f23418f;	 Catch:{ all -> 0x0041 }
            r1 = r0 + 1;
            r3.f23418f = r1;	 Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0029;
        L_0x0010:
            r0 = r3.f23424l;	 Catch:{ all -> 0x0041 }
            r0 = r0 + 1;
            r3.f23424l = r0;	 Catch:{ all -> 0x0041 }
            r0 = r3.m31694e();	 Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0026;
        L_0x001c:
            r0 = r3.f23414b;	 Catch:{ all -> 0x0041 }
            r0 = r0.f23408b;	 Catch:{ all -> 0x0041 }
            r0 = r0.now();	 Catch:{ all -> 0x0041 }
            r3.f23425m = r0;	 Catch:{ all -> 0x0041 }
        L_0x0026:
            r0 = 1;
            r3.f23422j = r0;	 Catch:{ all -> 0x0041 }
        L_0x0029:
            r0 = r3.f23415c;	 Catch:{ all -> 0x0041 }
            r0.acquire();	 Catch:{ all -> 0x0041 }
            r0 = 0;
            r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r0 < 0) goto L_0x003f;
        L_0x0034:
            r0 = r3.f23414b;	 Catch:{ all -> 0x0041 }
            r0 = r0.f23409c;	 Catch:{ all -> 0x0041 }
            r1 = r3.f23413a;	 Catch:{ all -> 0x0041 }
            r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x0041 }
            r0.schedule(r1, r4, r2);	 Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r3);
            return;
        L_0x0041:
            r0 = move-exception;
            monitor-exit(r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.wakelock.FbWakeLockManager.WakeLock.a(long):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void m31693d() {
            /*
            r6 = this;
            monitor-enter(r6);
            r0 = r6.f23421i;	 Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r6);
            return;
        L_0x0007:
            r0 = r6.f23420h;	 Catch:{  }
            if (r0 == 0) goto L_0x000f;
        L_0x000b:
            r0 = r6.f23418f;	 Catch:{  }
            if (r0 == 0) goto L_0x0005;
        L_0x000f:
            r0 = r6.f23415c;	 Catch:{  }
            r0.release();	 Catch:{  }
            r0 = r6.f23420h;	 Catch:{  }
            if (r0 == 0) goto L_0x0020;
        L_0x0018:
            r0 = r6.f23418f;	 Catch:{  }
            r0 = r0 + -1;
            r6.f23418f = r0;	 Catch:{  }
            if (r0 != 0) goto L_0x0005;
        L_0x0020:
            r0 = r6.m31694e();	 Catch:{  }
            if (r0 == 0) goto L_0x0036;
        L_0x0026:
            r0 = r6.f23426n;	 Catch:{  }
            r2 = r6.f23414b;	 Catch:{  }
            r2 = r2.f23408b;	 Catch:{  }
            r2 = r2.now();	 Catch:{  }
            r4 = r6.f23425m;	 Catch:{  }
            r2 = r2 - r4;
            r0 = r0 + r2;
            r6.f23426n = r0;	 Catch:{  }
        L_0x0036:
            r0 = 0;
            r6.f23422j = r0;	 Catch:{  }
            goto L_0x0005;
        L_0x003a:
            r0 = move-exception;
            monitor-exit(r6);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.wakelock.FbWakeLockManager.WakeLock.d():void");
        }

        public static synchronized void m31685k(WakeLock wakeLock) {
            synchronized (wakeLock) {
                if (wakeLock.m31694e()) {
                    if (wakeLock.f23420h) {
                        while (wakeLock.f23418f > 0) {
                            wakeLock.m31693d();
                        }
                    } else {
                        wakeLock.m31693d();
                    }
                    wakeLock.f23421i = true;
                } else {
                    wakeLock.f23421i = true;
                }
            }
        }

        private void m31686l() {
            if (this.f23421i) {
                throw new RuntimeException("WakeLock already disposed");
            }
        }

        public final synchronized void m31690a(boolean z) {
            if (z) {
                Preconditions.checkState(this.f23420h, "Wake lock cannot go from non-refcounted to refcounted");
            }
            this.f23420h = z;
            this.f23415c.setReferenceCounted(z);
        }

        public final synchronized boolean m31694e() {
            return this.f23422j;
        }

        public final synchronized boolean m31695f() {
            return this.f23420h;
        }

        public final synchronized long m31696i() {
            long now;
            if (m31694e()) {
                now = (this.f23426n + this.f23414b.f23408b.now()) - this.f23425m;
            } else {
                now = this.f23426n;
            }
            return now;
        }

        public final synchronized int m31697j() {
            return this.f23424l;
        }
    }

    public static com.facebook.common.wakelock.FbWakeLockManager m31678a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23406g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.wakelock.FbWakeLockManager.class;
        monitor-enter(r1);
        r0 = f23406g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m31679b(r0);	 Catch:{ all -> 0x0035 }
        f23406g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23406g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.wakelock.FbWakeLockManager.a(com.facebook.inject.InjectorLike):com.facebook.common.wakelock.FbWakeLockManager");
    }

    private static FbWakeLockManager m31679b(InjectorLike injectorLike) {
        return new FbWakeLockManager(PowerManagerMethodAutoProvider.m5525b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    @Inject
    public FbWakeLockManager(PowerManager powerManager, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        this.f23407a = powerManager;
        this.f23408b = monotonicClock;
        this.f23409c = scheduledExecutorService;
    }

    public final synchronized WakeLock m31680a(int i, String str) {
        WakeLock wakeLock;
        wakeLock = new WakeLock(this, this.f23407a.newWakeLock(i, str), i, str);
        this.f23410d.put(wakeLock.m31687a(), wakeLock);
        return wakeLock;
    }

    public final synchronized void m31682a(WakeLock wakeLock) {
        if (this.f23410d.containsKey(wakeLock.m31687a())) {
            this.f23410d.remove(wakeLock.m31687a());
            WakeLock.m31685k(wakeLock);
            this.f23411e += wakeLock.m31696i();
            this.f23412f++;
        }
    }

    public final Map<String, WakeLock> m31681a() {
        return Collections.unmodifiableMap(this.f23410d);
    }

    public final int m31683b() {
        return this.f23412f;
    }

    public final long m31684c() {
        return this.f23411e;
    }
}
