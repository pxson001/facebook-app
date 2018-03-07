package com.facebook.push.nna;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.PushManager;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: immersive_views_11_06 */
public class NNAPushManager implements PushManager {
    private static final Class<?> f10461a = NNAPushManager.class;
    private static volatile NNAPushManager f10462f;
    private final Lazy<NNARegistrar> f10463b;
    private final Lazy<FacebookPushServerRegistrar> f10464c;
    private final Provider<String> f10465d;
    private final PushServiceSelector f10466e;

    public static com.facebook.push.nna.NNAPushManager m11007a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10462f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.nna.NNAPushManager.class;
        monitor-enter(r1);
        r0 = f10462f;	 Catch:{ all -> 0x003a }
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
        r0 = m11008b(r0);	 Catch:{ all -> 0x0035 }
        f10462f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10462f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.nna.NNAPushManager.a(com.facebook.inject.InjectorLike):com.facebook.push.nna.NNAPushManager");
    }

    private static NNAPushManager m11008b(InjectorLike injectorLike) {
        return new NNAPushManager(IdBasedSingletonScopeProvider.b(injectorLike, 9756), IdBasedSingletonScopeProvider.b(injectorLike, 3215), IdBasedProvider.a(injectorLike, 4442), PushServiceSelector.m10724a(injectorLike));
    }

    @Inject
    public NNAPushManager(Lazy<NNARegistrar> lazy, Lazy<FacebookPushServerRegistrar> lazy2, Provider<String> provider, PushServiceSelector pushServiceSelector) {
        this.f10463b = lazy;
        this.f10464c = lazy2;
        this.f10465d = provider;
        this.f10466e = pushServiceSelector;
    }

    public final ServiceType mo794a() {
        return ServiceType.NNA;
    }

    private boolean m11009f() {
        return this.f10466e.m10731a(ServiceType.NNA);
    }

    public final void mo795b() {
        if (m11009f()) {
            this.f10466e.m10730a("com.nokia.pushnotifications.service", NNABroadcastReceiver.class, NNAService.class);
        }
    }

    public final void mo796c() {
        if (m11009f()) {
            ((NNARegistrar) this.f10463b.get()).a(true);
        }
    }

    public final void mo797d() {
        if (m11009f()) {
            if (!StringUtil.a(new CharSequence[]{(CharSequence) this.f10465d.get()})) {
                ((NNARegistrar) this.f10463b.get()).a(false);
            }
        }
    }

    public final void mo798e() {
        if (m11009f()) {
            ((FacebookPushServerRegistrar) this.f10464c.get()).m10798a(ServiceType.NNA);
        }
    }
}
