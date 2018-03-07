package com.facebook.common.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: stroke_color */
public class InexactTimerOverride {
    private static volatile InexactTimerOverride f3974c;
    private final SystemClock f3975a;
    private final RealtimeSinceBootClock f3976b;

    public static com.facebook.common.alarm.InexactTimerOverride m6578a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3974c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.alarm.InexactTimerOverride.class;
        monitor-enter(r1);
        r0 = f3974c;	 Catch:{ all -> 0x003a }
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
        r0 = m6579b(r0);	 Catch:{ all -> 0x0035 }
        f3974c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3974c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.alarm.InexactTimerOverride.a(com.facebook.inject.InjectorLike):com.facebook.common.alarm.InexactTimerOverride");
    }

    private static InexactTimerOverride m6579b(InjectorLike injectorLike) {
        return new InexactTimerOverride(SystemClockMethodAutoProvider.m1498a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.m6582a(injectorLike));
    }

    @Inject
    public InexactTimerOverride(SystemClock systemClock, RealtimeSinceBootClock realtimeSinceBootClock) {
        this.f3975a = systemClock;
        this.f3976b = realtimeSinceBootClock;
    }

    public final void m6580a(int i, long j, long j2, PendingIntent pendingIntent, AlarmManager alarmManager) {
        Object obj = 1;
        if (pendingIntent == null || j2 <= 0) {
            return;
        }
        if (j2 % 900000 != 0) {
            alarmManager.setRepeating(i, j, j2, pendingIntent);
            return;
        }
        long a;
        long j3;
        if (!(i == 1 || i == 0)) {
            obj = null;
        }
        if (obj != null) {
            a = this.f3975a.mo211a() - this.f3976b.now();
        } else {
            a = 0;
        }
        a = (j - a) % 900000;
        if (a != 0) {
            j3 = (j - a) + 900000;
        } else {
            j3 = j;
        }
        alarmManager.setRepeating(i, j3, j2, pendingIntent);
    }
}
