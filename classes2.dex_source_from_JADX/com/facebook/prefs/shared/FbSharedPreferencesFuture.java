package com.facebook.prefs.shared;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFuture;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: matcher */
public class FbSharedPreferencesFuture extends ForwardingListenableFuture<FbSharedPreferences> {
    private static volatile FbSharedPreferencesFuture f14978b;
    private final Lazy<ListenableFuture<FbSharedPreferences>> f14979a;

    public static com.facebook.prefs.shared.FbSharedPreferencesFuture m21420a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14978b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.shared.FbSharedPreferencesFuture.class;
        monitor-enter(r1);
        r0 = f14978b;	 Catch:{ all -> 0x003a }
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
        r0 = m21421b(r0);	 Catch:{ all -> 0x0035 }
        f14978b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14978b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.shared.FbSharedPreferencesFuture.a(com.facebook.inject.InjectorLike):com.facebook.prefs.shared.FbSharedPreferencesFuture");
    }

    private static FbSharedPreferencesFuture m21421b(InjectorLike injectorLike) {
        return new FbSharedPreferencesFuture(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078));
    }

    protected final /* synthetic */ Future mo1830a() {
        return mo2648b();
    }

    protected final /* synthetic */ Object mo105e() {
        return mo2648b();
    }

    @Inject
    public FbSharedPreferencesFuture(final Lazy<FbSharedPreferences> lazy) {
        this.f14979a = new LazyFuture<FbSharedPreferences>(this) {
            final /* synthetic */ FbSharedPreferencesFuture f14981b;

            protected final ListenableFuture<FbSharedPreferences> mo2649a() {
                final ListenableFuture f = SettableFuture.m1547f();
                ((FbSharedPreferences) lazy.get()).mo280a(new Runnable(this) {
                    final /* synthetic */ C06461 f14983b;

                    public void run() {
                        FutureDetour.a(f, lazy.get(), -2130926045);
                    }
                });
                return f;
            }
        };
    }

    protected final ListenableFuture<FbSharedPreferences> mo2648b() {
        return (ListenableFuture) this.f14979a.get();
    }
}
