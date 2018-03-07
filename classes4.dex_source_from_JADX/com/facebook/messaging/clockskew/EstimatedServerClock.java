package com.facebook.messaging.clockskew;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: favorite_id */
public class EstimatedServerClock implements Clock {
    private static volatile EstimatedServerClock f12199i;
    private final FbSharedPreferences f12200a;
    public final Clock f12201b;
    private BaseFbBroadcastManager f12202c;
    public MonotonicClock f12203d;
    private AutoDateTimeChecker f12204e;
    public long f12205f;
    public State f12206g = State.UNKNOWN;
    public long f12207h;

    /* compiled from: favorite_id */
    public enum State {
        UNKNOWN,
        ACCURATE,
        SKEWED
    }

    public static com.facebook.messaging.clockskew.EstimatedServerClock m12867a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12199i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.clockskew.EstimatedServerClock.class;
        monitor-enter(r1);
        r0 = f12199i;	 Catch:{ all -> 0x003a }
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
        r0 = m12868b(r0);	 Catch:{ all -> 0x0035 }
        f12199i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12199i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.clockskew.EstimatedServerClock.a(com.facebook.inject.InjectorLike):com.facebook.messaging.clockskew.EstimatedServerClock");
    }

    private static EstimatedServerClock m12868b(InjectorLike injectorLike) {
        return new EstimatedServerClock((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AutoDateTimeChecker.m12865b(injectorLike));
    }

    @Inject
    public EstimatedServerClock(FbSharedPreferences fbSharedPreferences, Clock clock, BaseFbBroadcastManager baseFbBroadcastManager, MonotonicClock monotonicClock, AutoDateTimeChecker autoDateTimeChecker) {
        this.f12200a = fbSharedPreferences;
        this.f12201b = clock;
        this.f12202c = baseFbBroadcastManager;
        this.f12203d = monotonicClock;
        this.f12204e = autoDateTimeChecker;
        this.f12207h = clock.a() - monotonicClock.now();
        if (this.f12204e.m12866a()) {
            m12872d();
            this.f12206g = State.ACCURATE;
        } else if (this.f12200a.a(ClockSkewPrefKeys.a)) {
            m12871b(this.f12200a.a(ClockSkewPrefKeys.a, 0));
        }
    }

    public final long m12869a() {
        return m12870a(this.f12201b.a());
    }

    public final long m12870a(long j) {
        switch (1.a[this.f12206g.ordinal()]) {
            case 1:
                return j - this.f12205f;
            default:
                return j;
        }
    }

    public final void m12871b(long j) {
        if (this.f12205f != j) {
            this.f12205f = j;
            if (Math.abs(j) > 60000) {
                this.f12206g = State.SKEWED;
            } else {
                this.f12206g = State.ACCURATE;
            }
            this.f12200a.edit().a(ClockSkewPrefKeys.a, j).commit();
            this.f12202c.a("com.facebook.orca.SKEW_CHANGED");
        }
    }

    final void m12872d() {
        m12871b(0);
    }
}
