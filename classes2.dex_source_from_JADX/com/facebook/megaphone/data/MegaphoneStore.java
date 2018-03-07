package com.facebook.megaphone.data;

import android.os.Handler;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.megaphone.MegaphoneController;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.megaphone.api.FetchMegaphoneLayoutMethod;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.fetcher.MegaphoneExtraDataFetcher;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Platform;
import com.google.common.collect.Synchronized;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: peer_info */
public class MegaphoneStore implements IHaveUserData {
    private static final String f10293a = MegaphoneFetcher.class.getSimpleName();
    private static final MegaphoneEntry f10294b = new MegaphoneEntry(null, 0);
    private static volatile MegaphoneStore f10295l;
    private Handler f10296c;
    public final Clock f10297d;
    public final MegaphoneFetcher f10298e;
    public final Lazy<MegaphoneExtraDataFetcher> f10299f;
    public DefaultAndroidThreadUtil f10300g;
    public final AbstractFbErrorReporter f10301h;
    public Map<GraphQLMegaphoneLocation, MegaphoneEntry> f10302i = Maps.m843e();
    public Multimap<GraphQLMegaphoneLocation, MegaphoneUpdateListener> f10303j = Synchronized.m15399a(HashMultimap.m10690u(), null);
    public Set<GraphQLMegaphoneLocation> f10304k = Platform.m644a(Maps.m843e());

    @Immutable
    /* compiled from: peer_info */
    public class MegaphoneEntry {
        final MegaphoneWithLayout f10311a;
        public final long f10312b;

        MegaphoneEntry(@Nullable MegaphoneWithLayout megaphoneWithLayout, long j) {
            this.f10311a = megaphoneWithLayout;
            this.f10312b = j;
        }
    }

    /* compiled from: peer_info */
    public class C07251 implements FutureCallback<MegaphoneWithLayout> {
        final /* synthetic */ GraphQLMegaphoneLocation f17912a;
        final /* synthetic */ MegaphoneStore f17913b;

        public C07251(MegaphoneStore megaphoneStore, GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
            this.f17913b = megaphoneStore;
            this.f17912a = graphQLMegaphoneLocation;
        }

        public void onSuccess(Object obj) {
            MegaphoneWithLayout megaphoneWithLayout = (MegaphoneWithLayout) obj;
            this.f17913b.f10304k.remove(this.f17912a);
            MegaphoneStore megaphoneStore = this.f17913b;
            GraphQLMegaphoneLocation graphQLMegaphoneLocation = this.f17912a;
            if (megaphoneWithLayout == null || megaphoneWithLayout.b == null) {
                megaphoneStore.m15371a(graphQLMegaphoneLocation, megaphoneWithLayout, megaphoneStore.f10297d.mo211a() + 3600000);
                return;
            }
            ListenableFuture a;
            String k = megaphoneWithLayout.b.k();
            MegaphoneExtraDataFetcher megaphoneExtraDataFetcher = (MegaphoneExtraDataFetcher) megaphoneStore.f10299f.get();
            if (k.equals("2322")) {
                a = megaphoneExtraDataFetcher.a.a("android_feed_megaphone", "native_megaphone");
            } else {
                a = null;
            }
            ListenableFuture listenableFuture = a;
            if (listenableFuture == null) {
                megaphoneStore.m15371a(graphQLMegaphoneLocation, megaphoneWithLayout, megaphoneStore.f10297d.mo211a() + 3600000);
            } else {
                megaphoneStore.f10300g.m1651a(listenableFuture, new 2(megaphoneStore, k, graphQLMegaphoneLocation, megaphoneWithLayout));
            }
        }

        public void onFailure(Throwable th) {
            this.f17913b.f10304k.remove(this.f17912a);
            this.f17913b.f10301h.m2343a("megaphone", "Failure fetching megaphone for location" + this.f17912a, th);
        }
    }

    public static com.facebook.megaphone.data.MegaphoneStore m15368a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10295l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.megaphone.data.MegaphoneStore.class;
        monitor-enter(r1);
        r0 = f10295l;	 Catch:{ all -> 0x003a }
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
        r0 = m15369b(r0);	 Catch:{ all -> 0x0035 }
        f10295l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10295l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.megaphone.data.MegaphoneStore.a(com.facebook.inject.InjectorLike):com.facebook.megaphone.data.MegaphoneStore");
    }

    private static MegaphoneStore m15369b(InjectorLike injectorLike) {
        return new MegaphoneStore(SystemClockMethodAutoProvider.m1498a(injectorLike), new MegaphoneFetcher(ResourcesMethodAutoProvider.m6510a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), new FetchMegaphoneMethod(GraphQLProtocolHelper.m9427a(injectorLike)), new FetchMegaphoneLayoutMethod(SystemClockMethodAutoProvider.m1498a(injectorLike)), ApiMethodRunnerImpl.m15381a(injectorLike)), IdBasedLazy.m1808a(injectorLike, 7499), DefaultAndroidThreadUtil.m1646b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public MegaphoneStore(Clock clock, MegaphoneFetcher megaphoneFetcher, Lazy<MegaphoneExtraDataFetcher> lazy, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter) {
        this.f10297d = clock;
        this.f10298e = megaphoneFetcher;
        this.f10299f = lazy;
        this.f10300g = androidThreadUtil;
        this.f10301h = fbErrorReporter;
    }

    @Nullable
    public final MegaphoneWithLayout m15370a(GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
        m15367a();
        MegaphoneEntry megaphoneEntry = (MegaphoneEntry) this.f10302i.get(graphQLMegaphoneLocation);
        if (megaphoneEntry != null) {
            return megaphoneEntry.f10311a;
        }
        return null;
    }

    private Handler m15367a() {
        if (this.f10296c == null) {
            this.f10296c = new Handler();
        }
        return this.f10296c;
    }

    public final void m15371a(GraphQLMegaphoneLocation graphQLMegaphoneLocation, @Nullable MegaphoneWithLayout megaphoneWithLayout, long j) {
        if (megaphoneWithLayout != null && megaphoneWithLayout.b != null) {
            this.f10302i.put(graphQLMegaphoneLocation, new MegaphoneEntry(megaphoneWithLayout, j));
            m15374d(graphQLMegaphoneLocation);
        }
    }

    public final boolean m15372b(GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
        if (this.f10302i.isEmpty() || this.f10302i.get(graphQLMegaphoneLocation) == null || ((MegaphoneEntry) this.f10302i.get(graphQLMegaphoneLocation)).f10311a == null) {
            return false;
        }
        return true;
    }

    public final void m15373c(GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
        if (this.f10302i.remove(graphQLMegaphoneLocation) != null) {
            this.f10302i.put(graphQLMegaphoneLocation, f10294b);
            m15374d(graphQLMegaphoneLocation);
        }
    }

    public final void m15374d(GraphQLMegaphoneLocation graphQLMegaphoneLocation) {
        for (MegaphoneController 3 : this.f10303j.mo427c(graphQLMegaphoneLocation)) {
            HandlerDetour.a(m15367a(), new 3(this, 3), -2135590129);
        }
    }

    public void clearUserData() {
        this.f10302i.clear();
        this.f10304k.clear();
    }
}
