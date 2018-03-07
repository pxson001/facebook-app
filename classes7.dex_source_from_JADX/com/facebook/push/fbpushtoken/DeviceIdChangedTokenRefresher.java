package com.facebook.push.fbpushtoken;

import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.DeviceIdChangedCallback.ChangeType;
import com.facebook.device_id.UniqueDeviceId;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.adm.ADMRegistrar;
import com.facebook.push.c2dm.C2DMRegistrar;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.fbns.FbnsRegistrar;
import com.facebook.push.fbnslite.FbnsLiteRegistrar;
import com.facebook.push.nna.NNARegistrar;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: heisman_profile_overlay_page */
public class DeviceIdChangedTokenRefresher implements DeviceIdChangedCallback {
    private static final Class<?> f11295a = DeviceIdChangedTokenRefresher.class;
    private static volatile DeviceIdChangedTokenRefresher f11296i;
    private final Lazy<C2DMRegistrar> f11297b;
    private final Lazy<ADMRegistrar> f11298c;
    private final Lazy<NNARegistrar> f11299d;
    private final Lazy<FbnsRegistrar> f11300e;
    private final Lazy<FbnsLiteRegistrar> f11301f;
    private final Lazy<FacebookPushServerRegistrar> f11302g;
    private final Lazy<PushServiceSelector> f11303h;

    public static com.facebook.push.fbpushtoken.DeviceIdChangedTokenRefresher m13190a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11296i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbpushtoken.DeviceIdChangedTokenRefresher.class;
        monitor-enter(r1);
        r0 = f11296i;	 Catch:{ all -> 0x003a }
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
        r0 = m13191b(r0);	 Catch:{ all -> 0x0035 }
        f11296i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11296i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbpushtoken.DeviceIdChangedTokenRefresher.a(com.facebook.inject.InjectorLike):com.facebook.push.fbpushtoken.DeviceIdChangedTokenRefresher");
    }

    private static DeviceIdChangedTokenRefresher m13191b(InjectorLike injectorLike) {
        return new DeviceIdChangedTokenRefresher(IdBasedSingletonScopeProvider.b(injectorLike, 3162), IdBasedSingletonScopeProvider.b(injectorLike, 3158), IdBasedSingletonScopeProvider.b(injectorLike, 9756), IdBasedLazy.a(injectorLike, 3175), IdBasedSingletonScopeProvider.b(injectorLike, 3178), IdBasedSingletonScopeProvider.b(injectorLike, 3215), IdBasedSingletonScopeProvider.b(injectorLike, 3171));
    }

    @Inject
    public DeviceIdChangedTokenRefresher(Lazy<C2DMRegistrar> lazy, Lazy<ADMRegistrar> lazy2, Lazy<NNARegistrar> lazy3, Lazy<FbnsRegistrar> lazy4, Lazy<FbnsLiteRegistrar> lazy5, Lazy<FacebookPushServerRegistrar> lazy6, Lazy<PushServiceSelector> lazy7) {
        this.f11297b = lazy;
        this.f11298c = lazy2;
        this.f11299d = lazy3;
        this.f11300e = lazy4;
        this.f11301f = lazy5;
        this.f11302g = lazy6;
        this.f11303h = lazy7;
    }

    public final void m13192a(UniqueDeviceId uniqueDeviceId, UniqueDeviceId uniqueDeviceId2, ChangeType changeType, String str) {
        if (((PushServiceSelector) this.f11303h.get()).a(ServiceType.GCM)) {
            ((FacebookPushServerRegistrar) this.f11302g.get()).a(ServiceType.GCM, ((C2DMRegistrar) this.f11297b.get()).a);
        }
        if (((PushServiceSelector) this.f11303h.get()).a(ServiceType.FBNS)) {
            ((FacebookPushServerRegistrar) this.f11302g.get()).a(ServiceType.FBNS, ((FbnsRegistrar) this.f11300e.get()).a);
        }
        if (((PushServiceSelector) this.f11303h.get()).a(ServiceType.ADM)) {
            ((FacebookPushServerRegistrar) this.f11302g.get()).a(ServiceType.ADM, ((ADMRegistrar) this.f11298c.get()).a);
        }
        if (((PushServiceSelector) this.f11303h.get()).a(ServiceType.NNA)) {
            ((FacebookPushServerRegistrar) this.f11302g.get()).a(ServiceType.NNA, ((NNARegistrar) this.f11299d.get()).f11322a);
        }
        if (((PushServiceSelector) this.f11303h.get()).a(ServiceType.FBNS_LITE)) {
            ((FacebookPushServerRegistrar) this.f11302g.get()).a(ServiceType.FBNS_LITE, ((FbnsLiteRegistrar) this.f11301f.get()).a);
        }
    }
}
