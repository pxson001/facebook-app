package com.facebook.zero.iptest;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_update_timestamp */
public class ZeroIPTestScheduler {
    private static final String f9529a = ZeroIPTestScheduler.class.getName();
    private static volatile ZeroIPTestScheduler f9530e;
    private final FacebookOnlyIntentActionFactory f9531b;
    private final Context f9532c;
    private final FbAlarmManagerImpl f9533d;

    public static com.facebook.zero.iptest.ZeroIPTestScheduler m9906a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9530e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.iptest.ZeroIPTestScheduler.class;
        monitor-enter(r1);
        r0 = f9530e;	 Catch:{ all -> 0x003a }
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
        r0 = m9907b(r0);	 Catch:{ all -> 0x0035 }
        f9530e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9530e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.iptest.ZeroIPTestScheduler.a(com.facebook.inject.InjectorLike):com.facebook.zero.iptest.ZeroIPTestScheduler");
    }

    private static ZeroIPTestScheduler m9907b(InjectorLike injectorLike) {
        return new ZeroIPTestScheduler((Context) injectorLike.getInstance(Context.class), FacebookOnlyIntentActionFactory.a(injectorLike), FbAlarmManagerImpl.a(injectorLike));
    }

    @Inject
    public ZeroIPTestScheduler(Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, FbAlarmManagerImpl fbAlarmManagerImpl) {
        this.f9532c = context;
        this.f9531b = facebookOnlyIntentActionFactory;
        this.f9533d = fbAlarmManagerImpl;
    }

    private boolean m9908c() {
        m9910a();
        this.f9533d.a(3, SystemClock.elapsedRealtime() + 1800000, 43200000, m9909d());
        Long.valueOf(1800000);
        Long.valueOf(43200000);
        return true;
    }

    public final void m9910a() {
        this.f9533d.a(m9909d());
    }

    public final boolean m9911b() {
        return m9908c();
    }

    private PendingIntent m9909d() {
        return SecurePendingIntent.m10163b(this.f9532c, 0, new Intent(this.f9531b.a("ZERO_IP_TEST_ACTION")), 0);
    }
}
