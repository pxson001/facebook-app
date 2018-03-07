package com.facebook.launcherbadges;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: main_dex_store_optimization_complete */
public class LauncherBadgesManager {
    private static volatile LauncherBadgesManager f8415c;
    public final ImmutableSet<LauncherBadgesInterface> f8416a;
    private final ListeningExecutorService f8417b;

    public static com.facebook.launcherbadges.LauncherBadgesManager m8676a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8415c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.launcherbadges.LauncherBadgesManager.class;
        monitor-enter(r1);
        r0 = f8415c;	 Catch:{ all -> 0x003a }
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
        r0 = m8677b(r0);	 Catch:{ all -> 0x0035 }
        f8415c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8415c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.launcherbadges.LauncherBadgesManager.a(com.facebook.inject.InjectorLike):com.facebook.launcherbadges.LauncherBadgesManager");
    }

    private static LauncherBadgesManager m8677b(InjectorLike injectorLike) {
        return new LauncherBadgesManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$LauncherBadgesInterface(injectorLike)), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    LauncherBadgesManager(Set<LauncherBadgesInterface> set, ListeningExecutorService listeningExecutorService) {
        this.f8416a = ImmutableSet.copyOf(set);
        this.f8417b = listeningExecutorService;
    }

    public final ListenableFuture<TriState> m8678a(final int i) {
        return this.f8417b.a(new Callable<TriState>(this) {
            final /* synthetic */ LauncherBadgesManager f11078b;

            public Object call() {
                TriState triState = TriState.NO;
                Iterator it = this.f11078b.f8416a.iterator();
                TriState triState2 = triState;
                while (it.hasNext()) {
                    triState = ((LauncherBadgesInterface) it.next()).mo683a(i);
                    if (triState == TriState.YES) {
                        return TriState.YES;
                    }
                    if (triState != TriState.UNSET || triState2 != TriState.NO) {
                        triState = triState2;
                    }
                    triState2 = triState;
                }
                return triState2;
            }
        });
    }
}
