package com.facebook.timeline.datafetcher;

import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.protocol.FetchTimelineUnseenSectionQuery.TimelineUnseenStoriesQueryString;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: graphql_query_params */
public class TimelineUnseenStoriesQueryBuilder {
    private static volatile TimelineUnseenStoriesQueryBuilder f10671i;
    private final GraphQLStoryHelper f10672a;
    private final GraphQLImageHelper f10673b;
    private final SizeAwareImageUtil f10674c;
    private final FetchRecentActivityParamBuilderUtil f10675d;
    private final QeAccessor f10676e;
    private final FetchReactorsParamBuilderUtil f10677f;
    private final FetchTopicsParamBuilderUtil f10678g;
    private final SocialSearchParamBuilderUtil f10679h;

    public static com.facebook.timeline.datafetcher.TimelineUnseenStoriesQueryBuilder m10733a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10671i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineUnseenStoriesQueryBuilder.class;
        monitor-enter(r1);
        r0 = f10671i;	 Catch:{ all -> 0x003a }
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
        r0 = m10734b(r0);	 Catch:{ all -> 0x0035 }
        f10671i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10671i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineUnseenStoriesQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineUnseenStoriesQueryBuilder");
    }

    private static TimelineUnseenStoriesQueryBuilder m10734b(InjectorLike injectorLike) {
        return new TimelineUnseenStoriesQueryBuilder(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike));
    }

    @Inject
    public TimelineUnseenStoriesQueryBuilder(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, QeAccessor qeAccessor, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil) {
        this.f10672a = graphQLStoryHelper;
        this.f10673b = graphQLImageHelper;
        this.f10674c = sizeAwareImageUtil;
        this.f10675d = fetchRecentActivityParamBuilderUtil;
        this.f10676e = qeAccessor;
        this.f10677f = fetchReactorsParamBuilderUtil;
        this.f10678g = fetchTopicsParamBuilderUtil;
        this.f10679h = socialSearchParamBuilderUtil;
    }

    public final TimelineUnseenStoriesQueryString m10735a(long j) {
        GraphQlQueryString timelineUnseenStoriesQueryString = new TimelineUnseenStoriesQueryString();
        timelineUnseenStoriesQueryString.a("profile_id", String.valueOf(j)).a("profile_image_size", GraphQLStoryHelper.a()).a("angora_attachment_cover_image_size", this.f10672a.r()).a("angora_attachment_profile_image_size", this.f10672a.s()).a("reading_attachment_profile_image_width", this.f10672a.L()).a("reading_attachment_profile_image_height", this.f10672a.M()).a("num_faceboxes_and_tags", this.f10672a.b).a("goodwill_small_accent_image", this.f10673b.h()).a("image_large_aspect_height", this.f10672a.z()).a("image_large_aspect_width", this.f10672a.y()).a("include_replies_in_total_count", Boolean.toString(this.f10676e.a(ExperimentsForUfiServiceQeModule.l, false))).a("default_image_scale", GraphQlQueryDefaults.a()).a("action_location", NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf());
        this.f10674c.a(timelineUnseenStoriesQueryString, this.f10673b.c());
        this.f10675d.a(timelineUnseenStoriesQueryString);
        this.f10678g.a(timelineUnseenStoriesQueryString);
        SocialSearchParamBuilderUtil.a(timelineUnseenStoriesQueryString);
        return timelineUnseenStoriesQueryString;
    }
}
