package com.facebook.timeline.datafetcher;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQL.TimelineUserSectionQueryString;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: greeting_card_share */
public class TimelineSectionQueryBuilder {
    private static volatile TimelineSectionQueryBuilder f10573l;
    private final GraphQLStoryHelper f10574a;
    private final GraphQLImageHelper f10575b;
    private final SizeAwareImageUtil f10576c;
    private final Provider<VideoDashConfig> f10577d;
    private final FetchRecentActivityParamBuilderUtil f10578e;
    private final QeAccessor f10579f;
    private final FetchVideoChannelParamBuilderUtil f10580g;
    private final FetchReactorsParamBuilderUtil f10581h;
    private final FetchTopicsParamBuilderUtil f10582i;
    private final SocialSearchParamBuilderUtil f10583j;
    private final AutomaticPhotoCaptioningUtils f10584k;

    public static com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder m10657a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10573l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder.class;
        monitor-enter(r1);
        r0 = f10573l;	 Catch:{ all -> 0x003a }
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
        r0 = m10658b(r0);	 Catch:{ all -> 0x0035 }
        f10573l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10573l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder");
    }

    private static TimelineSectionQueryBuilder m10658b(InjectorLike injectorLike) {
        return new TimelineSectionQueryBuilder(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public TimelineSectionQueryBuilder(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, Provider<VideoDashConfig> provider, QeAccessor qeAccessor, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f10574a = graphQLStoryHelper;
        this.f10575b = graphQLImageHelper;
        this.f10576c = sizeAwareImageUtil;
        this.f10577d = provider;
        this.f10578e = fetchRecentActivityParamBuilderUtil;
        this.f10579f = qeAccessor;
        this.f10580g = fetchVideoChannelParamBuilderUtil;
        this.f10581h = fetchReactorsParamBuilderUtil;
        this.f10582i = fetchTopicsParamBuilderUtil;
        this.f10583j = socialSearchParamBuilderUtil;
        this.f10584k = automaticPhotoCaptioningUtils;
    }

    public final TimelineUserSectionQueryString m10659a(TimelineSectionFetchParams timelineSectionFetchParams, int i) {
        GraphQlQueryString timelineUserSectionQueryString = new TimelineUserSectionQueryString();
        if (!StringUtil.a(timelineSectionFetchParams.f10699c)) {
            timelineUserSectionQueryString.a("nodeId", timelineSectionFetchParams.f10699c);
        }
        if (timelineSectionFetchParams.f10700d != null) {
            timelineUserSectionQueryString.a("nodeId", timelineSectionFetchParams.f10700d);
        }
        timelineUserSectionQueryString.a("profile_image_size", GraphQLStoryHelper.a()).a("timeline_stories", Integer.toString(i)).a("angora_attachment_cover_image_size", this.f10574a.r()).a("angora_attachment_profile_image_size", this.f10574a.s()).a("reading_attachment_profile_image_width", this.f10574a.L()).a("reading_attachment_profile_image_height", this.f10574a.M()).a("goodwill_small_accent_image", this.f10575b.h()).a("image_large_aspect_height", this.f10574a.z()).a("image_large_aspect_width", this.f10574a.y()).a("num_faceboxes_and_tags", this.f10574a.b).a("default_image_scale", GraphQlQueryDefaults.a()).a("icon_scale", GraphQlQueryDefaults.a()).a("include_replies_in_total_count", Boolean.toString(this.f10579f.a(ExperimentsForUfiServiceQeModule.l, false))).a("action_location", NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf()).a("with_actor_profile_video_playback", Boolean.toString(this.f10579f.a(ExperimentsForTimelineAbTestModule.aO, false))).a("inline_comments_experiment", Boolean.toString(this.f10579f.a(ExperimentsForTimelineAbTestModule.W, false))).a("enable_download", Boolean.toString(this.f10579f.a(ExperimentsForVideoAbTestModule.cW, false))).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10584k.a()));
        if (this.f10577d != null && ((VideoDashConfig) this.f10577d.get()).a()) {
            timelineUserSectionQueryString.a("scrubbing", "MPEG_DASH");
        }
        if (!StringUtil.a(timelineSectionFetchParams.f10701e)) {
            timelineUserSectionQueryString.a("timeline_section_after", timelineSectionFetchParams.f10701e);
        }
        if (timelineSectionFetchParams.f10702f != null) {
            timelineUserSectionQueryString.a("timeline_section_after", timelineSectionFetchParams.f10702f);
        }
        if (!StringUtil.a(timelineSectionFetchParams.f10707k)) {
            timelineUserSectionQueryString.a("timeline_filter", timelineSectionFetchParams.f10707k);
        }
        this.f10576c.a(timelineUserSectionQueryString, this.f10575b.c());
        this.f10580g.a(timelineUserSectionQueryString, EntryPointInputVideoChannelEntryPoint.PAGE);
        timelineUserSectionQueryString.b(true);
        this.f10578e.a(timelineUserSectionQueryString);
        this.f10582i.a(timelineUserSectionQueryString);
        SocialSearchParamBuilderUtil.a(timelineUserSectionQueryString);
        return timelineUserSectionQueryString;
    }
}
