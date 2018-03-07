package com.facebook.push.externalcloud;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.adm.ADMPushPrefKeys;
import com.facebook.push.c2dm.C2DMPushPrefKeys;
import com.facebook.push.fbns.FbnsPushPrefKeys;
import com.facebook.push.fbnslite.FbnsLitePushPrefKeys;
import com.facebook.push.fbpushtoken.PushPrefKeys;
import com.facebook.push.nna.NNAPushPrefKeys;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: inetCondition */
public class PushPrefKeysSelector {
    private static volatile PushPrefKeysSelector f10344f;
    private final Provider<C2DMPushPrefKeys> f10345a;
    private final Provider<ADMPushPrefKeys> f10346b;
    private final Provider<NNAPushPrefKeys> f10347c;
    private final Provider<FbnsPushPrefKeys> f10348d;
    private final Provider<FbnsLitePushPrefKeys> f10349e;

    public static com.facebook.push.externalcloud.PushPrefKeysSelector m10873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10344f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.externalcloud.PushPrefKeysSelector.class;
        monitor-enter(r1);
        r0 = f10344f;	 Catch:{ all -> 0x003a }
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
        r0 = m10874b(r0);	 Catch:{ all -> 0x0035 }
        f10344f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10344f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.externalcloud.PushPrefKeysSelector.a(com.facebook.inject.InjectorLike):com.facebook.push.externalcloud.PushPrefKeysSelector");
    }

    private static PushPrefKeysSelector m10874b(InjectorLike injectorLike) {
        return new PushPrefKeysSelector(IdBasedSingletonScopeProvider.a(injectorLike, 3161), IdBasedSingletonScopeProvider.a(injectorLike, 9740), IdBasedSingletonScopeProvider.a(injectorLike, 9754), IdBasedProvider.a(injectorLike, 3174), IdBasedSingletonScopeProvider.a(injectorLike, 3177));
    }

    @Inject
    public PushPrefKeysSelector(Provider<C2DMPushPrefKeys> provider, Provider<ADMPushPrefKeys> provider2, Provider<NNAPushPrefKeys> provider3, Provider<FbnsPushPrefKeys> provider4, Provider<FbnsLitePushPrefKeys> provider5) {
        this.f10345a = provider;
        this.f10346b = provider2;
        this.f10347c = provider3;
        this.f10348d = provider4;
        this.f10349e = provider5;
    }

    public final PushPrefKeys m10875a(ServiceType serviceType) {
        switch (serviceType) {
            case ADM:
                return (PushPrefKeys) this.f10346b.get();
            case GCM:
                return (PushPrefKeys) this.f10345a.get();
            case NNA:
                return (PushPrefKeys) this.f10347c.get();
            case FBNS:
                return (PushPrefKeys) this.f10348d.get();
            case FBNS_LITE:
                return (PushPrefKeys) this.f10349e.get();
            default:
                throw new IllegalStateException("Unknown push service type");
        }
    }
}
