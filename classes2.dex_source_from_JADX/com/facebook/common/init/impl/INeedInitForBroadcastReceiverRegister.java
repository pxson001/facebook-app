package com.facebook.common.init.impl;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager$ReceiverBuilder;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.C0153x827e3911;
import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: trace size limit must be at least  */
public class INeedInitForBroadcastReceiverRegister implements INeedInit {
    private static final Class<?> f2289a = INeedInitForBroadcastReceiverRegister.class;
    private static volatile INeedInitForBroadcastReceiverRegister f2290g;
    private final Lazy<FbBroadcastManager> f2291b;
    private final Lazy<FbBroadcastManager> f2292c;
    private final Lazy<FbBroadcastManager> f2293d;
    private final Lazy<FbBroadcastManager> f2294e;
    private final Lazy<Set<INeedInitForBroadcastReceiverRegistration>> f2295f;

    /* compiled from: trace size limit must be at least  */
    /* synthetic */ class C01541 {
        static final /* synthetic */ int[] f2298a = new int[FbBroadcastManagerType.values().length];

        static {
            try {
                f2298a[FbBroadcastManagerType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2298a[FbBroadcastManagerType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2298a[FbBroadcastManagerType.CROSS_APP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2298a[FbBroadcastManagerType.CROSS_PROCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static com.facebook.common.init.impl.INeedInitForBroadcastReceiverRegister m4476a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2290g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.init.impl.INeedInitForBroadcastReceiverRegister.class;
        monitor-enter(r1);
        r0 = f2290g;	 Catch:{ all -> 0x003a }
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
        r0 = m4479b(r0);	 Catch:{ all -> 0x0035 }
        f2290g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2290g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.init.impl.INeedInitForBroadcastReceiverRegister.a(com.facebook.inject.InjectorLike):com.facebook.common.init.impl.INeedInitForBroadcastReceiverRegister");
    }

    private static INeedInitForBroadcastReceiverRegister m4479b(InjectorLike injectorLike) {
        return new INeedInitForBroadcastReceiverRegister(IdBasedLazy.m1808a(injectorLike, 401), IdBasedLazy.m1808a(injectorLike, 399), IdBasedLazy.m1808a(injectorLike, 392), IdBasedLazy.m1808a(injectorLike, 393), ProviderLazy.m1699a(new C0153x827e3911(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public INeedInitForBroadcastReceiverRegister(Lazy<FbBroadcastManager> lazy, Lazy<FbBroadcastManager> lazy2, Lazy<FbBroadcastManager> lazy3, Lazy<FbBroadcastManager> lazy4, Lazy<Set<INeedInitForBroadcastReceiverRegistration>> lazy5) {
        this.f2291b = lazy;
        this.f2292c = lazy2;
        this.f2293d = lazy3;
        this.f2294e = lazy4;
        this.f2295f = lazy5;
    }

    public void init() {
        m4477a();
    }

    private void m4477a() {
        TracerDetour.a("INeedInitForBroadcastReceiverRegister-RegisterActionReceivers", 480857615);
        try {
            for (INeedInitForBroadcastReceiverRegistration a : m4480b()) {
                m4478a(a);
            }
        } finally {
            TracerDetour.a(-606725322);
        }
    }

    private Set<INeedInitForBroadcastReceiverRegistration> m4480b() {
        TracerDetour.a("INeedInitForBroadcastReceiverRegister-RegisterActionReceivers#construct", 1444359896);
        try {
            Set<INeedInitForBroadcastReceiverRegistration> set = (Set) this.f2295f.get();
            return set;
        } finally {
            TracerDetour.a(-161600716);
        }
    }

    private BaseFbBroadcastManager m4475a(FbBroadcastManagerType fbBroadcastManagerType) {
        switch (C01541.f2298a[fbBroadcastManagerType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (BaseFbBroadcastManager) this.f2291b.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (BaseFbBroadcastManager) this.f2292c.get();
            case 3:
                return (BaseFbBroadcastManager) this.f2293d.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (BaseFbBroadcastManager) this.f2294e.get();
            default:
                throw new IllegalArgumentException("Unknown broadcast manager type!");
        }
    }

    private void m4478a(INeedInitForBroadcastReceiverRegistration iNeedInitForBroadcastReceiverRegistration) {
        FbBroadcastManager$ReceiverBuilder a = m4475a(iNeedInitForBroadcastReceiverRegistration.mBroadcastType).m2951a();
        for (String a2 : iNeedInitForBroadcastReceiverRegistration.mActions) {
            a.mo506a(a2, iNeedInitForBroadcastReceiverRegistration);
        }
        a.mo505a(iNeedInitForBroadcastReceiverRegistration.mHandler).mo503a().m3296b();
    }
}
