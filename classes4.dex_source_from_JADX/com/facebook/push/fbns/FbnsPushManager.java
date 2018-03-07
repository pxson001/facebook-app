package com.facebook.push.fbns;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.PushManager;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: imported_phone_entries */
public class FbnsPushManager implements PushManager {
    private static final Class<?> f10450a = FbnsPushManager.class;
    private static volatile FbnsPushManager f10451d;
    private final Lazy<FbnsRegistrar> f10452b;
    private final PushServiceSelector f10453c;

    public static com.facebook.push.fbns.FbnsPushManager m10980a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10451d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbns.FbnsPushManager.class;
        monitor-enter(r1);
        r0 = f10451d;	 Catch:{ all -> 0x003a }
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
        r0 = m10981b(r0);	 Catch:{ all -> 0x0035 }
        f10451d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10451d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbns.FbnsPushManager.a(com.facebook.inject.InjectorLike):com.facebook.push.fbns.FbnsPushManager");
    }

    private static FbnsPushManager m10981b(InjectorLike injectorLike) {
        return new FbnsPushManager(IdBasedLazy.a(injectorLike, 3175), PushServiceSelector.m10724a(injectorLike));
    }

    @Inject
    public FbnsPushManager(Lazy<FbnsRegistrar> lazy, PushServiceSelector pushServiceSelector) {
        this.f10452b = lazy;
        this.f10453c = pushServiceSelector;
    }

    public final ServiceType mo794a() {
        return ServiceType.FBNS;
    }

    private boolean m10982f() {
        return this.f10453c.m10731a(ServiceType.FBNS);
    }

    public final void mo795b() {
    }

    public final void mo796c() {
        if (m10982f()) {
            ((FbnsRegistrar) this.f10452b.get()).m11047a(true);
        }
    }

    public final void mo797d() {
        if (m10982f()) {
            ((FbnsRegistrar) this.f10452b.get()).m11047a(false);
        }
    }

    public final void mo798e() {
        if (m10982f()) {
            FbnsRegistrar.m11044a((FbnsRegistrar) this.f10452b.get(), null);
        }
    }
}
