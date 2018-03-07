package com.facebook.timeline.datafetcher;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: greeting_card_dismissed */
public class TimelineStoriesQueryBuilder {
    private static volatile TimelineStoriesQueryBuilder f10659l;
    private final GraphQLStoryHelper f10660a;
    private final GraphQLImageHelper f10661b;
    private final SizeAwareImageUtil f10662c;
    private final Provider<VideoDashConfig> f10663d;
    private final FetchRecentActivityParamBuilderUtil f10664e;
    private final QeAccessor f10665f;
    private final FetchVideoChannelParamBuilderUtil f10666g;
    private final FetchReactorsParamBuilderUtil f10667h;
    private final FetchTopicsParamBuilderUtil f10668i;
    private final SocialSearchParamBuilderUtil f10669j;
    private final AutomaticPhotoCaptioningUtils f10670k;

    public static com.facebook.timeline.datafetcher.TimelineStoriesQueryBuilder m10730a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10659l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineStoriesQueryBuilder.class;
        monitor-enter(r1);
        r0 = f10659l;	 Catch:{ all -> 0x003a }
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
        r0 = m10731b(r0);	 Catch:{ all -> 0x0035 }
        f10659l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10659l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineStoriesQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineStoriesQueryBuilder");
    }

    private static TimelineStoriesQueryBuilder m10731b(InjectorLike injectorLike) {
        return new TimelineStoriesQueryBuilder(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public TimelineStoriesQueryBuilder(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, Provider<VideoDashConfig> provider, QeAccessor qeAccessor, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f10660a = graphQLStoryHelper;
        this.f10661b = graphQLImageHelper;
        this.f10662c = sizeAwareImageUtil;
        this.f10663d = provider;
        this.f10664e = fetchRecentActivityParamBuilderUtil;
        this.f10665f = qeAccessor;
        this.f10666g = fetchVideoChannelParamBuilderUtil;
        this.f10667h = fetchReactorsParamBuilderUtil;
        this.f10668i = fetchTopicsParamBuilderUtil;
        this.f10669j = socialSearchParamBuilderUtil;
        this.f10670k = automaticPhotoCaptioningUtils;
    }
}
