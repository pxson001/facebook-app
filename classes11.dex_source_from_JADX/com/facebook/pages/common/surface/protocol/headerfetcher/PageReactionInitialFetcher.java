package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionManager;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: resizeMode */
public class PageReactionInitialFetcher {
    public static final Surface f2535a = Surface.ANDROID_PAGE_HOME;
    private static volatile PageReactionInitialFetcher f2536d;
    public final ReactionSessionHelper f2537b;
    public final Lazy<ReactionSessionManager> f2538c;

    public static com.facebook.pages.common.surface.protocol.headerfetcher.PageReactionInitialFetcher m3468a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2536d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.surface.protocol.headerfetcher.PageReactionInitialFetcher.class;
        monitor-enter(r1);
        r0 = f2536d;	 Catch:{ all -> 0x003a }
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
        r0 = m3469b(r0);	 Catch:{ all -> 0x0035 }
        f2536d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2536d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.protocol.headerfetcher.PageReactionInitialFetcher.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.surface.protocol.headerfetcher.PageReactionInitialFetcher");
    }

    private static PageReactionInitialFetcher m3469b(InjectorLike injectorLike) {
        return new PageReactionInitialFetcher(ReactionSessionHelper.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9836));
    }

    @Inject
    public PageReactionInitialFetcher(ReactionSessionHelper reactionSessionHelper, Lazy<ReactionSessionManager> lazy) {
        this.f2537b = reactionSessionHelper;
        this.f2538c = lazy;
    }

    public final ReactionSession m3471a(Long l, GraphQLBatchRequest graphQLBatchRequest, int i, @Nullable DisposableFutureCallback disposableFutureCallback, @Nullable ExecutorService executorService, boolean z) {
        return this.f2537b.a(graphQLBatchRequest, i, f2535a, m3470b(l), disposableFutureCallback, executorService, z);
    }

    public static ReactionQueryParams m3470b(Long l) {
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.l = l;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.t = l;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.b = 2;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.i = NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf();
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.o = RequestPriority.INTERACTIVE;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.y = f2535a.toString();
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.w = "page_reaction_early_fetch";
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.x = "InitialLoad";
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.z = ImmutableSet.of("page_reaction_initial_fetch_tag");
        return reactionQueryParams;
    }
}
