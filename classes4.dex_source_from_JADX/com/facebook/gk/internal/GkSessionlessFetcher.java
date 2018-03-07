package com.facebook.gk.internal;

import android.os.Bundle;
import com.facebook.debug.log.BLog;
import com.facebook.gk.internal.FetchGatekeepersParams.Session;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: timestamp<? */
public class GkSessionlessFetcher {
    private static final Class<?> f993a = GkSessionlessFetcher.class;
    private static volatile GkSessionlessFetcher f994f;
    private final AbstractSingleMethodRunner f995b;
    private final Lazy<FetchMobileGatekeepersMethod> f996c;
    private final List<GatekeeperFetchListener> f997d;
    private final List<GatekeeperFetchListener> f998e = new CopyOnWriteArrayList();

    public static com.facebook.gk.internal.GkSessionlessFetcher m1311a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f994f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gk.internal.GkSessionlessFetcher.class;
        monitor-enter(r1);
        r0 = f994f;	 Catch:{ all -> 0x003a }
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
        r0 = m1313b(r0);	 Catch:{ all -> 0x0035 }
        f994f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f994f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gk.internal.GkSessionlessFetcher.a(com.facebook.inject.InjectorLike):com.facebook.gk.internal.GkSessionlessFetcher");
    }

    private static GkSessionlessFetcher m1313b(InjectorLike injectorLike) {
        return new GkSessionlessFetcher((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 2109), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0065x19bc20d8(injectorLike)));
    }

    @Inject
    public GkSessionlessFetcher(SingleMethodRunner singleMethodRunner, Lazy<FetchMobileGatekeepersMethod> lazy, Set<GatekeeperFetchListener> set) {
        this.f995b = singleMethodRunner;
        this.f996c = lazy;
        if (set.isEmpty()) {
            this.f997d = Collections.emptyList();
        } else {
            this.f997d = new ArrayList(set);
        }
    }

    public final boolean m1314a() {
        try {
            m1312a((Bundle) this.f995b.a((ApiMethod) this.f996c.get(), new FetchGatekeepersParams(ImmutableSet.of(), Session.IS_SESSIONLESS)));
            return true;
        } catch (Throwable e) {
            BLog.b(f993a, "Sessionless gatekeeper fetch with SingleMethodRunner failed", e);
            return false;
        }
    }

    private void m1312a(@Nullable Bundle bundle) {
        if (bundle != null && !bundle.isEmpty() && bundle.containsKey("gatekeepers")) {
            int size = this.f997d.size();
            for (int i = 0; i < size; i++) {
                ((GatekeeperFetchListener) this.f997d.get(i)).mo84a(bundle);
            }
            for (GatekeeperFetchListener a : this.f998e) {
                a.mo84a(bundle);
            }
        }
    }
}
