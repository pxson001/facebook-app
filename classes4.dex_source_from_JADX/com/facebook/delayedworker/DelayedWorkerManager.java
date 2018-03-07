package com.facebook.delayedworker;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLastManifestUrl */
public class DelayedWorkerManager {
    private static final String f8662a = DelayedWorkerManager.class.getSimpleName();
    private static volatile DelayedWorkerManager f8663f;
    private final Context f8664b;
    private final DelayedWorkerExecutionTimeManager f8665c;
    private final Clock f8666d;
    private final FbAlarmManagerImpl f8667e;

    public static com.facebook.delayedworker.DelayedWorkerManager m8911a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8663f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.delayedworker.DelayedWorkerManager.class;
        monitor-enter(r1);
        r0 = f8663f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8915b(r0);	 Catch:{ all -> 0x0035 }
        f8663f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8663f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.delayedworker.DelayedWorkerManager.a(com.facebook.inject.InjectorLike):com.facebook.delayedworker.DelayedWorkerManager");
    }

    private static DelayedWorkerManager m8915b(InjectorLike injectorLike) {
        return new DelayedWorkerManager((Context) injectorLike.getInstance(Context.class), DelayedWorkerExecutionTimeManager.m8918a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbAlarmManagerImpl.a(injectorLike));
    }

    @Inject
    public DelayedWorkerManager(Context context, DelayedWorkerExecutionTimeManager delayedWorkerExecutionTimeManager, Clock clock, FbAlarmManagerImpl fbAlarmManagerImpl) {
        this.f8664b = context;
        this.f8665c = delayedWorkerExecutionTimeManager;
        this.f8666d = clock;
        this.f8667e = fbAlarmManagerImpl;
    }

    public final void m8917a(Class<? extends DelayedWorker> cls, long j) {
        if (cls == null) {
            throw new IllegalArgumentException("DelayedWorkerClass can't be null");
        } else if (j < 0) {
            throw new IllegalArgumentException("Delay can't be a negative number");
        } else {
            cls.getName();
            Long.valueOf(j);
            long convert = TimeUnit.MILLISECONDS.convert(j, TimeUnit.SECONDS);
            long a = this.f8666d.a();
            m8913a(cls, a, convert);
            m8916b((Class) cls, a + convert);
        }
    }

    private void m8913a(Class<? extends DelayedWorker> cls, long j, long j2) {
        PrefKey prefKey = (PrefKey) DelayedWorkerExecutionTimeManager.f8668a.a(cls.getName());
        long a = this.f8665c.f8670b.a(prefKey, 0);
        if (j - a > j2) {
            prefKey = (PrefKey) DelayedWorkerExecutionTimeManager.f8668a.a(cls.getName());
            this.f8665c.f8670b.edit().a(prefKey, j).commit();
            if (a > 0) {
                m8912a((Class) cls);
            }
        }
    }

    private void m8912a(Class<? extends DelayedWorker> cls) {
        this.f8664b.startService(m8910a((Class) cls, false));
    }

    private void m8916b(Class<? extends DelayedWorker> cls, long j) {
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f8667e;
        PendingIntent b = m8914b((Class) cls, true);
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(1, j, b);
        } else {
            fbAlarmManagerImpl.a.setExact(1, j, b);
        }
    }

    private Intent m8910a(Class<? extends DelayedWorker> cls, boolean z) {
        Intent intent = new Intent(this.f8664b, DelayedWorkerService.class);
        intent.setData(DelayedWorkerService.m11983a(cls.getName(), z));
        return intent;
    }

    private PendingIntent m8914b(Class<? extends DelayedWorker> cls, boolean z) {
        return PendingIntent.getService(this.f8664b, 0, m8910a((Class) cls, z), 0);
    }
}
