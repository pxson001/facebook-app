package com.facebook.push.c2dm;

import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
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
/* compiled from: include */
public class C2dmPushManager implements PushManager {
    private static final Class<?> f10396a = C2dmPushManager.class;
    private static volatile C2dmPushManager f10397h;
    private final Lazy<C2DMRegistrar> f10398b;
    private final Lazy<FacebookPushServerRegistrar> f10399c;
    public final Provider<String> f10400d;
    private final PushServiceSelector f10401e;
    public final Product f10402f;
    public final Provider<TriState> f10403g;

    public static com.facebook.push.c2dm.C2dmPushManager m10942a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10397h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.c2dm.C2dmPushManager.class;
        monitor-enter(r1);
        r0 = f10397h;	 Catch:{ all -> 0x003a }
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
        r0 = m10943b(r0);	 Catch:{ all -> 0x0035 }
        f10397h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10397h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.c2dm.C2dmPushManager.a(com.facebook.inject.InjectorLike):com.facebook.push.c2dm.C2dmPushManager");
    }

    private static C2dmPushManager m10943b(InjectorLike injectorLike) {
        return new C2dmPushManager(IdBasedSingletonScopeProvider.b(injectorLike, 3162), IdBasedSingletonScopeProvider.b(injectorLike, 3215), IdBasedProvider.a(injectorLike, 4442), PushServiceSelector.m10724a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 751));
    }

    @Inject
    public C2dmPushManager(Lazy<C2DMRegistrar> lazy, Lazy<FacebookPushServerRegistrar> lazy2, Provider<String> provider, PushServiceSelector pushServiceSelector, Product product, Provider<TriState> provider2) {
        this.f10398b = lazy;
        this.f10399c = lazy2;
        this.f10400d = provider;
        this.f10401e = pushServiceSelector;
        this.f10402f = product;
        this.f10403g = provider2;
    }

    public final ServiceType mo794a() {
        return ServiceType.GCM;
    }

    private boolean m10944f() {
        return this.f10401e.m10731a(ServiceType.GCM);
    }

    public final void mo795b() {
        if (m10944f()) {
            this.f10401e.m10730a(((C2DMRegistrar) this.f10398b.get()).m10961b(), C2DMBroadcastReceiver.class, C2DMService.class);
        }
    }

    public final void mo796c() {
        if (m10944f()) {
            ((C2DMRegistrar) this.f10398b.get()).m10960a(true);
        }
    }

    public final void mo797d() {
        if (m10944f()) {
            Object obj;
            boolean z;
            if (StringUtil.a((CharSequence) this.f10400d.get())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                z = true;
            } else {
                if (Product.MESSENGER == this.f10402f || Product.FB4A == this.f10402f) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z = false;
                } else {
                    z = ((TriState) this.f10403g.get()).asBoolean(false);
                }
            }
            if (z) {
                ((C2DMRegistrar) this.f10398b.get()).m10960a(false);
            }
        }
    }

    public final void mo798e() {
        if (m10944f()) {
            ((FacebookPushServerRegistrar) this.f10399c.get()).m10798a(ServiceType.GCM);
        }
    }
}
