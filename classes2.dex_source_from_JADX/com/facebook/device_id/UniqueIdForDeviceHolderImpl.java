package com.facebook.device_id;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tuzi_fb4a_location_lat_long_rollout */
public class UniqueIdForDeviceHolderImpl {
    private static final Class<?> f2199a = UniqueIdForDeviceHolderImpl.class;
    private static volatile UniqueIdForDeviceHolderImpl f2200e;
    private volatile UniqueDeviceId f2201b;
    public final FbSharedPreferences f2202c;
    private final Clock f2203d;

    public static com.facebook.device_id.UniqueIdForDeviceHolderImpl m4341a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2200e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device_id.UniqueIdForDeviceHolderImpl.class;
        monitor-enter(r1);
        r0 = f2200e;	 Catch:{ all -> 0x003a }
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
        r0 = m4342b(r0);	 Catch:{ all -> 0x0035 }
        f2200e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2200e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device_id.UniqueIdForDeviceHolderImpl.a(com.facebook.inject.InjectorLike):com.facebook.device_id.UniqueIdForDeviceHolderImpl");
    }

    private static UniqueIdForDeviceHolderImpl m4342b(InjectorLike injectorLike) {
        return new UniqueIdForDeviceHolderImpl(FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public UniqueIdForDeviceHolderImpl(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f2202c = fbSharedPreferences;
        this.f2203d = clock;
    }

    public final String m4346a() {
        UniqueDeviceId d = m4344d();
        if (d == null) {
            return null;
        }
        return d.f3013a;
    }

    public final UniqueDeviceId m4348b() {
        return m4344d();
    }

    public final synchronized void m4347a(UniqueDeviceId uniqueDeviceId) {
        this.f2201b = uniqueDeviceId;
        m4343b(this.f2201b);
    }

    private synchronized UniqueDeviceId m4344d() {
        if (this.f2201b == null) {
            this.f2201b = m4345e();
        }
        return this.f2201b;
    }

    private UniqueDeviceId m4345e() {
        UniqueDeviceId a;
        String a2 = this.f2202c.mo278a(DeviceIdPrefKeys.f2208a, null);
        long a3 = this.f2202c.mo277a(DeviceIdPrefKeys.f2209b, Long.MAX_VALUE);
        if (a2 == null || a3 == Long.MAX_VALUE) {
            a = m4340a(this.f2203d);
            m4343b(a);
        } else {
            a = new UniqueDeviceId(a2, a3);
        }
        new StringBuilder("loaded device id from shared prefs: ").append(a);
        return a;
    }

    private void m4343b(UniqueDeviceId uniqueDeviceId) {
        new StringBuilder("saving device id from shared prefs: ").append(uniqueDeviceId);
        this.f2202c.edit().mo1275a(DeviceIdPrefKeys.f2209b, uniqueDeviceId.f3014b).mo1276a(DeviceIdPrefKeys.f2208a, uniqueDeviceId.f3013a).commit();
    }

    static UniqueDeviceId m4340a(Clock clock) {
        return new UniqueDeviceId(SafeUUIDGenerator.m2795a().toString(), clock.mo211a());
    }
}
