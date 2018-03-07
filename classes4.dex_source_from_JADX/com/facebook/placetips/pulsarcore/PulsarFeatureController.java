package com.facebook.placetips.pulsarcore;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.facebook.placetips.pulsarcore.service.PulsarManifestComponentManager;
import com.facebook.placetips.settings.PlaceTipsSettingsChangedListener;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.AccessorFuture;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_synced_date */
public class PulsarFeatureController implements PlaceTipsSettingsChangedListener {
    private static volatile PulsarFeatureController f9534d;
    private final Provider<PulsarDetectionEnabledFuture> f9535a;
    private final Lazy<PulsarManifestComponentManager> f9536b;
    private final Lazy<AccessorFuture> f9537c;

    /* compiled from: last_synced_date */
    class C04301 implements FutureCallback<List<Object>> {
        final /* synthetic */ PulsarFeatureController f9538a;

        C04301(PulsarFeatureController pulsarFeatureController) {
            this.f9538a = pulsarFeatureController;
        }

        public void onSuccess(Object obj) {
            List list = (List) obj;
            boolean z = true;
            boolean booleanValue = ((Boolean) list.get(0)).booleanValue();
            Accessor accessor = (Accessor) list.get(1);
            PulsarFeatureController pulsarFeatureController = this.f9538a;
            if (!(booleanValue && accessor.c())) {
                z = false;
            }
            pulsarFeatureController.m9914a(z);
        }

        public void onFailure(Throwable th) {
            this.f9538a.m9914a(false);
        }
    }

    public static com.facebook.placetips.pulsarcore.PulsarFeatureController m9912a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9534d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.pulsarcore.PulsarFeatureController.class;
        monitor-enter(r1);
        r0 = f9534d;	 Catch:{ all -> 0x003a }
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
        r0 = m9915b(r0);	 Catch:{ all -> 0x0035 }
        f9534d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9534d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.pulsarcore.PulsarFeatureController.a(com.facebook.inject.InjectorLike):com.facebook.placetips.pulsarcore.PulsarFeatureController");
    }

    private static PulsarFeatureController m9915b(InjectorLike injectorLike) {
        return new PulsarFeatureController(IdBasedProvider.a(injectorLike, 3014), IdBasedLazy.a(injectorLike, 3019), IdBasedLazy.a(injectorLike, 3023));
    }

    @Inject
    public PulsarFeatureController(Provider<PulsarDetectionEnabledFuture> provider, Lazy<PulsarManifestComponentManager> lazy, Lazy<AccessorFuture> lazy2) {
        this.f9535a = provider;
        this.f9536b = lazy;
        this.f9537c = lazy2;
    }

    public final void m9917a() {
        m9916c();
    }

    public final void m9919b() {
        m9914a(false);
    }

    public final void m9918a(GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel2) {
        m9916c();
    }

    private void m9916c() {
        Futures.a(Futures.a(new ListenableFuture[]{(ListenableFuture) this.f9535a.get(), (ListenableFuture) this.f9537c.get()}), new C04301(this), MoreExecutors.a());
    }

    private void m9914a(boolean z) {
        if (!z) {
            ((PulsarManifestComponentManager) this.f9536b.get()).m9940a(false);
        }
        ((PulsarManifestComponentManager) this.f9536b.get()).m9941b(z);
    }
}
