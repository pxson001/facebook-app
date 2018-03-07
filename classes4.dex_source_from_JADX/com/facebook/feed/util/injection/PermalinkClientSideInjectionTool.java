package com.facebook.feed.util.injection;

import com.facebook.api.story.FetchSingleStoryResult;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: platform_copy_platform_app_content_params */
public class PermalinkClientSideInjectionTool {
    public static final Class<?> f4598a = PermalinkClientSideInjectionTool.class;
    private static volatile PermalinkClientSideInjectionTool f4599h;
    private Optional<File> f4600b = Absent.INSTANCE;
    public final InjectedFeedStoryHolder f4601c;
    private final DefaultBlueServiceOperationFactory f4602d;
    private final boolean f4603e;
    public int f4604f;
    public int f4605g;

    public static com.facebook.feed.util.injection.PermalinkClientSideInjectionTool m5080a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4599h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.injection.PermalinkClientSideInjectionTool.class;
        monitor-enter(r1);
        r0 = f4599h;	 Catch:{ all -> 0x003a }
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
        r0 = m5081b(r0);	 Catch:{ all -> 0x0035 }
        f4599h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4599h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.injection.PermalinkClientSideInjectionTool.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.injection.PermalinkClientSideInjectionTool");
    }

    private static PermalinkClientSideInjectionTool m5081b(InjectorLike injectorLike) {
        return new PermalinkClientSideInjectionTool(IdBasedSingletonScopeProvider.a(injectorLike, 3922), InjectedFeedStoryHolder.m5086b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PermalinkClientSideInjectionTool(Provider<Boolean> provider, InjectedFeedStoryHolder injectedFeedStoryHolder, BlueServiceOperationFactory blueServiceOperationFactory) {
        this.f4602d = blueServiceOperationFactory;
        this.f4603e = ((Boolean) provider.get()).booleanValue();
        this.f4601c = injectedFeedStoryHolder;
    }

    public final FetchSingleStoryResult m5082a(FetchSingleStoryResult fetchSingleStoryResult) {
        if (!this.f4603e || !this.f4601c.m5090b()) {
            return fetchSingleStoryResult;
        }
        Optional of;
        ImmutableList immutableList = this.f4601c.f4608c;
        for (int i = 0; i < immutableList.size(); i++) {
            int i2 = this.f4605g;
            this.f4605g = i2 + 1;
            FeedUnit feedUnit = (FeedUnit) immutableList.get(i2 % immutableList.size());
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory$Builder a = GraphQLStory$Builder.m3407a((GraphQLStory) feedUnit);
                i = this.f4604f;
                this.f4604f = i + 1;
                a.f3180F = (long) i;
                of = Optional.of(a.m3419a());
                break;
            }
        }
        of = Absent.INSTANCE;
        Optional optional = of;
        if (optional.isPresent()) {
            return new FetchSingleStoryResult((GraphQLStory) optional.get(), fetchSingleStoryResult.freshness, fetchSingleStoryResult.clientTimeMs);
        }
        BLog.b(f4598a, "None of the permalink injection stories are GraphQLStory type, not injecting");
        return fetchSingleStoryResult;
    }
}
