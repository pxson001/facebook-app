package com.facebook.feed.util.injection;

import android.os.Bundle;
import android.os.Environment;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: meme_busting_sentry_warning_received */
public class FeedClientSideInjectionTool {
    public static final File f10423a = new File(Environment.getExternalStorageDirectory(), "feed-inject.json");
    private static volatile FeedClientSideInjectionTool f10424j;
    public Optional<File> f10425b = Absent.INSTANCE;
    public Optional<String> f10426c = Absent.INSTANCE;
    public final boolean f10427d;
    public final DefaultBlueServiceOperationFactory f10428e;
    public final InjectedFeedStoryHolder f10429f;
    private int f10430g;
    private int f10431h;
    private int f10432i;

    /* compiled from: meme_busting_sentry_warning_received */
    public enum Action {
        DETECT,
        CLEAR,
        REMOVE
    }

    public static com.facebook.feed.util.injection.FeedClientSideInjectionTool m16603a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10424j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.injection.FeedClientSideInjectionTool.class;
        monitor-enter(r1);
        r0 = f10424j;	 Catch:{ all -> 0x003a }
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
        r0 = m16604b(r0);	 Catch:{ all -> 0x0035 }
        f10424j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10424j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.injection.FeedClientSideInjectionTool.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.injection.FeedClientSideInjectionTool");
    }

    private static FeedClientSideInjectionTool m16604b(InjectorLike injectorLike) {
        return new FeedClientSideInjectionTool(IdBasedSingletonScopeProvider.a(injectorLike, 3922), PerfTestConfig.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), InjectedFeedStoryHolder.b(injectorLike));
    }

    @Inject
    public FeedClientSideInjectionTool(Provider<Boolean> provider, PerfTestConfig perfTestConfig, BlueServiceOperationFactory blueServiceOperationFactory, InjectedFeedStoryHolder injectedFeedStoryHolder) {
        boolean z = ((Boolean) provider.get()).booleanValue() || PerfTestConfigBase.a();
        this.f10427d = z;
        this.f10428e = blueServiceOperationFactory;
        this.f10429f = injectedFeedStoryHolder;
        m16606a(Action.DETECT);
    }

    public final void m16606a(Action action) {
        if (this.f10427d) {
            switch (action) {
                case REMOVE:
                    if (f10423a.exists()) {
                        f10423a.delete();
                    }
                    if (this.f10425b.isPresent()) {
                        this.f10425b = Absent.INSTANCE;
                    }
                    if (this.f10426c.isPresent()) {
                        this.f10426c = Absent.INSTANCE;
                        break;
                    }
                    break;
                case DETECT:
                    Object obj;
                    if (this.f10427d) {
                        this.f10429f.a();
                        int i;
                        if (this.f10425b.isPresent() && this.f10429f.a((File) this.f10425b.get())) {
                            i = 1;
                        } else if (this.f10426c.isPresent() && this.f10429f.a((String) this.f10426c.get())) {
                            i = 1;
                        } else if (this.f10429f.a(f10423a)) {
                            i = 1;
                        } else {
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        break;
                    }
                    return;
                case CLEAR:
                    break;
                default:
                    return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("clearCacheResetFeedLoader", true);
            BlueServiceOperationFactoryDetour.a(this.f10428e, "feed_clear_cache", bundle, 1701140954).a(true).c();
        }
    }

    @DoNotStrip
    public void installInjectionFile(@Nullable File file) {
        this.f10425b = Optional.fromNullable(file);
        m16606a(Action.DETECT);
    }

    @DoNotStrip
    void installInjectionString(@Nullable String str) {
        this.f10426c = Optional.fromNullable(str);
        m16606a(Action.DETECT);
    }

    public final FetchFeedResult m16605a(FetchFeedResult fetchFeedResult) {
        Object obj;
        if (this.f10427d && this.f10429f.b()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return fetchFeedResult;
        }
        ImmutableList immutableList = this.f10429f.c;
        Builder builder = ImmutableList.builder();
        int i;
        int i2;
        GraphQLFeedUnitEdge a;
        if (fetchFeedResult.d().isEmpty() && fetchFeedResult.a.e == null && fetchFeedResult.a.d == null) {
            i = fetchFeedResult.a.c;
            i2 = 0;
            while (i2 < i && i2 < immutableList.size()) {
                FeedUnit feedUnit = (FeedUnit) immutableList.get(this.f10432i % immutableList.size());
                GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
                builder2.i = feedUnit;
                GraphQLFeedUnitEdge.Builder builder3 = builder2;
                builder3.f = "injected-cacheid-" + this.f10432i;
                builder3 = builder3;
                builder3.k = "injected-dedup-" + this.f10432i;
                builder3 = builder3;
                builder3.e = "synthetic_cursor";
                a = builder3.a();
                this.f10432i++;
                builder.c(a);
                i2++;
            }
        } else {
            ImmutableList d = fetchFeedResult.d();
            int size = d.size();
            for (i = 0; i < size; i++) {
                a = (GraphQLFeedUnitEdge) d.get(i);
                i2 = this.f10431h;
                this.f10431h = i2 + 1;
                FeedUnit feedUnit2 = (FeedUnit) immutableList.get(i2 % immutableList.size());
                if (feedUnit2 instanceof GraphQLStory) {
                    GraphQLStory.Builder a2 = GraphQLStory.Builder.a((GraphQLStory) feedUnit2);
                    int i3 = this.f10430g;
                    this.f10430g = i3 + 1;
                    a2.F = (long) i3;
                    feedUnit2 = a2.a();
                }
                GraphQLFeedUnitEdge.Builder builder4 = new GraphQLFeedUnitEdge.Builder();
                builder4.i = feedUnit2;
                GraphQLFeedUnitEdge.Builder builder5 = builder4;
                builder5.f = DedupableUtil.a(a);
                builder5 = builder5;
                builder5.k = a.d();
                builder5 = builder5;
                builder5.e = a.g();
                builder.c(builder5.a());
            }
        }
        GraphQLPageInfo.Builder builder6 = new GraphQLPageInfo.Builder();
        builder6 = GraphQLPageInfo.Builder.a(fetchFeedResult.e());
        builder6.f = true;
        GraphQLPageInfo a3 = builder6.a();
        FetchFeedParams fetchFeedParams = fetchFeedResult.a;
        GraphQLFeedHomeStories.Builder builder7 = new GraphQLFeedHomeStories.Builder();
        builder7.f = builder.b();
        builder7 = builder7;
        builder7.i = a3;
        GraphQLFeedHomeStories.Builder builder8 = builder7;
        builder8.e = fetchFeedResult.f();
        return new FetchFeedResult(fetchFeedParams, builder8.a(), fetchFeedResult.freshness, fetchFeedResult.clientTimeMs, fetchFeedResult.c);
    }
}
