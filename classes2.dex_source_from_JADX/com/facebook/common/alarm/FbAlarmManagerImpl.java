package com.facebook.common.alarm;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import com.facebook.common.android.AlarmManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"SetRepeatingUse", "AlarmManagerUse"})
/* compiled from: stroke_width */
public class FbAlarmManagerImpl {
    private static volatile FbAlarmManagerImpl f3971c;
    public final AlarmManager f3972a;
    private final InexactTimerOverride f3973b;

    public static com.facebook.common.alarm.FbAlarmManagerImpl m6572a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3971c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.alarm.FbAlarmManagerImpl.class;
        monitor-enter(r1);
        r0 = f3971c;	 Catch:{ all -> 0x003a }
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
        r0 = m6573b(r0);	 Catch:{ all -> 0x0035 }
        f3971c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3971c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.alarm.FbAlarmManagerImpl.a(com.facebook.inject.InjectorLike):com.facebook.common.alarm.FbAlarmManagerImpl");
    }

    private static FbAlarmManagerImpl m6573b(InjectorLike injectorLike) {
        return new FbAlarmManagerImpl(AlarmManagerMethodAutoProvider.m6581b(injectorLike), InexactTimerOverride.m6578a(injectorLike));
    }

    @Inject
    public FbAlarmManagerImpl(AlarmManager alarmManager, InexactTimerOverride inexactTimerOverride) {
        this.f3972a = alarmManager;
        this.f3973b = inexactTimerOverride;
    }

    public final void m6577b(int i, long j, PendingIntent pendingIntent) {
        this.f3972a.set(i, j, pendingIntent);
    }

    public final void m6575a(int i, long j, PendingIntent pendingIntent) {
        if (VERSION.SDK_INT < 19) {
            this.f3972a.set(i, j, pendingIntent);
        } else {
            this.f3972a.setExact(i, j, pendingIntent);
        }
    }

    @SuppressLint({"SetInexactRepeatingArgs"})
    public final void m6574a(int i, long j, long j2, PendingIntent pendingIntent) {
        boolean z;
        Object obj = null;
        Preconditions.checkArgument(j > 0, "The alarm trigger time must be > 0");
        if (j2 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Alarm interval must be > 0");
        if (VERSION.SDK_INT < 14) {
            this.f3973b.m6580a(i, j, j2, pendingIntent, this.f3972a);
        } else {
            int i2 = 1;
        }
        if (obj != null) {
            this.f3972a.setInexactRepeating(i, j, j2, pendingIntent);
        }
    }

    public final void m6576a(PendingIntent pendingIntent) {
        this.f3972a.cancel(pendingIntent);
    }
}
