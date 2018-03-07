package com.facebook.location;

import android.annotation.TargetApi;
import android.location.Location;
import android.os.Build.VERSION;
import com.facebook.annotations.DoNotOptimize;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeConversions;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_mms_sent */
public class LocationAgeUtil {
    private static volatile LocationAgeUtil f4551c;
    public final Clock f4552a;
    public final MonotonicClock f4553b;

    @DoNotOptimize
    /* compiled from: sms_mms_sent */
    class Api17Utils {
        private Api17Utils() {
        }

        @TargetApi(17)
        static Optional<Long> m11966a(Location location) {
            Preconditions.checkState(VERSION.SDK_INT >= 17);
            long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
            if (elapsedRealtimeNanos == 0) {
                return Absent.INSTANCE;
            }
            return Optional.of(Long.valueOf(elapsedRealtimeNanos));
        }
    }

    public static com.facebook.location.LocationAgeUtil m8265a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4551c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.LocationAgeUtil.class;
        monitor-enter(r1);
        r0 = f4551c;	 Catch:{ all -> 0x003a }
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
        r0 = m8267b(r0);	 Catch:{ all -> 0x0035 }
        f4551c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4551c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.LocationAgeUtil.a(com.facebook.inject.InjectorLike):com.facebook.location.LocationAgeUtil");
    }

    private static LocationAgeUtil m8267b(InjectorLike injectorLike) {
        return new LocationAgeUtil(SystemClockMethodAutoProvider.m1498a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.m6582a(injectorLike));
    }

    @Inject
    public LocationAgeUtil(Clock clock, MonotonicClock monotonicClock) {
        this.f4552a = clock;
        this.f4553b = monotonicClock;
    }

    public final long m8269a(ImmutableLocation immutableLocation) {
        return m8264a(immutableLocation, this.f4552a.mo211a(), this.f4553b.now());
    }

    public static long m8264a(ImmutableLocation immutableLocation, long j, long j2) {
        Optional h = immutableLocation.m11991h();
        if (h.isPresent()) {
            return TimeConversions.m11977q((1000000 * j2) - ((Long) h.get()).longValue());
        }
        return j - ((Long) immutableLocation.m11990g().get()).longValue();
    }

    public final long m8268a(Location location) {
        if (VERSION.SDK_INT >= 17) {
            Optional a = Api17Utils.m11966a(location);
            if (a.isPresent()) {
                return TimeConversions.m11977q((1000000 * this.f4553b.now()) - ((Long) a.get()).longValue());
            }
        }
        return this.f4552a.mo211a() - location.getTime();
    }

    public static long m8263a(ImmutableLocation immutableLocation, long j) {
        Optional g = immutableLocation.m11990g();
        return g.isPresent() ? j - ((Long) g.get()).longValue() : Long.MIN_VALUE;
    }

    public static long m8266b(ImmutableLocation immutableLocation, long j) {
        if (VERSION.SDK_INT < 17) {
            return Long.MIN_VALUE;
        }
        Optional h = immutableLocation.m11991h();
        if (h.isPresent()) {
            return TimeConversions.m11977q((1000000 * j) - ((Long) h.get()).longValue());
        }
        return Long.MIN_VALUE;
    }
}
