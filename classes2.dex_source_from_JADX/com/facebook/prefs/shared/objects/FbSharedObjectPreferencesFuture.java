package com.facebook.prefs.shared.objects;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesFuture;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: market_uri */
public class FbSharedObjectPreferencesFuture extends ForwardingListenableFuture<FbSharedObjectPreferences> {
    private static volatile FbSharedObjectPreferencesFuture f15008b;
    private final Lazy<ListenableFuture<FbSharedObjectPreferences>> f15009a;

    public static com.facebook.prefs.shared.objects.FbSharedObjectPreferencesFuture m21447a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15008b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.shared.objects.FbSharedObjectPreferencesFuture.class;
        monitor-enter(r1);
        r0 = f15008b;	 Catch:{ all -> 0x003a }
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
        r0 = m21448b(r0);	 Catch:{ all -> 0x0035 }
        f15008b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15008b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.shared.objects.FbSharedObjectPreferencesFuture.a(com.facebook.inject.InjectorLike):com.facebook.prefs.shared.objects.FbSharedObjectPreferencesFuture");
    }

    private static FbSharedObjectPreferencesFuture m21448b(InjectorLike injectorLike) {
        return new FbSharedObjectPreferencesFuture(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3077), IdBasedLazy.m1808a(injectorLike, 3086));
    }

    protected final /* synthetic */ Future mo1830a() {
        return mo2648b();
    }

    protected final /* synthetic */ Object mo105e() {
        return mo2648b();
    }

    @Inject
    public FbSharedObjectPreferencesFuture(Lazy<FbSharedPreferencesFuture> lazy, final Lazy<FbSharedObjectPreferences> lazy2) {
        this.f15009a = LazyFutures.m19931a(lazy, new Function<FbSharedPreferences, FbSharedObjectPreferences>(this) {
            final /* synthetic */ FbSharedObjectPreferencesFuture f15011b;

            public Object apply(Object obj) {
                return (FbSharedObjectPreferencesImpl) lazy2.get();
            }
        }, MoreExecutors.m1813a());
    }

    protected final ListenableFuture<FbSharedObjectPreferences> mo2648b() {
        return (ListenableFuture) this.f15009a.get();
    }
}
