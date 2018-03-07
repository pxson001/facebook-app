package com.facebook.earlyfetch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.fragmentconstants.FragmentConstants;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.earlyfetch.map.EarlyFetcherMap;
import com.facebook.earlyfetch.map.EarlyFetcherMapImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_cache */
public class EarlyFetchController {
    private static volatile EarlyFetchController f20464g;
    public final Context f20465a;
    public final ViewerContextManager f20466b;
    private Provider<Boolean> f20467c;
    public EarlyFetcherMap f20468d;
    @Nullable
    public EarlyFetcher f20469e;
    private int f20470f = 0;

    public static com.facebook.earlyfetch.EarlyFetchController m28202a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20464g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.earlyfetch.EarlyFetchController.class;
        monitor-enter(r1);
        r0 = f20464g;	 Catch:{ all -> 0x003a }
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
        r0 = m28204b(r0);	 Catch:{ all -> 0x0035 }
        f20464g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20464g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.earlyfetch.EarlyFetchController.a(com.facebook.inject.InjectorLike):com.facebook.earlyfetch.EarlyFetchController");
    }

    private static EarlyFetchController m28204b(InjectorLike injectorLike) {
        return new EarlyFetchController((Context) injectorLike.getInstance(Context.class), ViewerContextManagerProvider.m2496b(injectorLike), IdBasedProvider.m1811a(injectorLike, 3963), EarlyFetcherMapImpl.m28207a(injectorLike));
    }

    @Inject
    public EarlyFetchController(Context context, ViewerContextManager viewerContextManager, Provider<Boolean> provider, EarlyFetcherMap earlyFetcherMap) {
        this.f20465a = context;
        this.f20466b = viewerContextManager;
        this.f20467c = provider;
        this.f20468d = earlyFetcherMap;
    }

    public final void m28205a(int i, String str, Bundle bundle) {
        m28203a();
        if (((Boolean) this.f20467c.get()).booleanValue()) {
            ImmutableList a = this.f20468d.mo3139a();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                EarlyFetcher earlyFetcher = (EarlyFetcher) a.get(i2);
                if (earlyFetcher.b() && earlyFetcher.a(i)) {
                    earlyFetcher.a(this.f20466b, this.f20465a, i, str, bundle);
                    this.f20469e = earlyFetcher;
                    this.f20470f = i;
                }
            }
        }
    }

    public final void m28206a(Intent intent) {
        if (this.f20469e == null || !this.f20469e.c() || !this.f20469e.a(this.f20470f)) {
            m28203a();
            if (((Boolean) this.f20467c.get()).booleanValue() && intent.hasExtra("target_fragment")) {
                FragmentConstants$ContentFragmentType a = FragmentConstants.a(intent.getIntExtra("target_fragment", -1));
                if (a != null) {
                    EarlyFetcher a2 = this.f20468d.mo3138a(a);
                    if (a2 != null && a2.b()) {
                        ViewerContextManager viewerContextManager = this.f20466b;
                        Context context = this.f20465a;
                        a2.c = viewerContextManager;
                        a2.d = viewerContextManager.mo217d();
                        a2.e = a2.a(context, intent);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        a2.b = uptimeMillis;
                        a2.a = uptimeMillis;
                    }
                    this.f20469e = a2;
                }
            }
        }
    }

    private void m28203a() {
        if (this.f20469e != null && this.f20469e.c()) {
            EarlyFetcher earlyFetcher = this.f20469e;
            if (earlyFetcher.e != null) {
                earlyFetcher.a(earlyFetcher.e.b);
                earlyFetcher.e = null;
                earlyFetcher.d = null;
            }
        }
        this.f20469e = null;
        this.f20470f = 0;
    }
}
