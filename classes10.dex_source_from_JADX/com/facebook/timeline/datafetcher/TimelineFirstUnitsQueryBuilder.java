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
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQL.TimelineFirstUnitsUserString;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: groupInformation or groupId is null in createShortcut */
public class TimelineFirstUnitsQueryBuilder {
    private static volatile TimelineFirstUnitsQueryBuilder f10473l;
    public final GraphQLStoryHelper f10474a;
    public final GraphQLImageHelper f10475b;
    public final SizeAwareImageUtil f10476c;
    public final QeAccessor f10477d;
    public final FetchRecentActivityParamBuilderUtil f10478e;
    public final Provider<VideoDashConfig> f10479f;
    public final FetchVideoChannelParamBuilderUtil f10480g;
    private final FetchReactorsParamBuilderUtil f10481h;
    public final FetchTopicsParamBuilderUtil f10482i;
    private final SocialSearchParamBuilderUtil f10483j;
    public final AutomaticPhotoCaptioningUtils f10484k;

    public static com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder m10587a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10473l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder.class;
        monitor-enter(r1);
        r0 = f10473l;	 Catch:{ all -> 0x003a }
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
        r0 = m10588b(r0);	 Catch:{ all -> 0x0035 }
        f10473l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10473l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder");
    }

    private static TimelineFirstUnitsQueryBuilder m10588b(InjectorLike injectorLike) {
        return new TimelineFirstUnitsQueryBuilder(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), FetchReactorsParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public TimelineFirstUnitsQueryBuilder(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, QeAccessor qeAccessor, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, Provider<VideoDashConfig> provider, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f10474a = graphQLStoryHelper;
        this.f10475b = graphQLImageHelper;
        this.f10476c = sizeAwareImageUtil;
        this.f10478e = fetchRecentActivityParamBuilderUtil;
        this.f10479f = provider;
        this.f10477d = qeAccessor;
        this.f10480g = fetchVideoChannelParamBuilderUtil;
        this.f10481h = fetchReactorsParamBuilderUtil;
        this.f10482i = fetchTopicsParamBuilderUtil;
        this.f10483j = socialSearchParamBuilderUtil;
        this.f10484k = automaticPhotoCaptioningUtils;
    }

    public final TimelineFirstUnitsUserString m10589a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams) {
        ScaleInputPixelRatio a = GraphQlQueryDefaults.a();
        GraphQlQueryString timelineFirstUnitsUserString = new TimelineFirstUnitsUserString();
        timelineFirstUnitsUserString.a("profile_image_size", GraphQLStoryHelper.a()).a("nodeId", String.valueOf(fetchTimelineFirstUnitsParams.f12088a)).a("angora_attachment_cover_image_size", this.f10474a.r()).a("angora_attachment_profile_image_size", this.f10474a.s()).a("reading_attachment_profile_image_width", this.f10474a.L()).a("reading_attachment_profile_image_height", this.f10474a.M()).a("num_faceboxes_and_tags", this.f10474a.b).a("image_large_aspect_height", this.f10474a.z()).a("image_large_aspect_width", this.f10474a.y()).a("goodwill_small_accent_image", this.f10475b.h()).a("include_replies_in_total_count", Boolean.toString(this.f10477d.a(ExperimentsForUfiServiceQeModule.l, false))).a("default_image_scale", a).a("icon_scale", a).a("timeline_stories", String.valueOf(this.f10477d.a(ExperimentsForTimelineAbTestModule.bc, 4))).a("action_location", NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf()).a("omit_unseen_stories", String.valueOf(fetchTimelineFirstUnitsParams.f12090c)).a("with_actor_profile_video_playback", Boolean.toString(this.f10477d.a(ExperimentsForTimelineAbTestModule.aO, false))).a("inline_comments_experiment", Boolean.toString(this.f10477d.a(ExperimentsForTimelineAbTestModule.W, false))).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10484k.a())).a("enable_download", Boolean.toString(this.f10477d.a(ExperimentsForVideoAbTestModule.cW, false)));
        if (!StringUtil.a(fetchTimelineFirstUnitsParams.f12089b)) {
            timelineFirstUnitsUserString.a("timeline_filter", fetchTimelineFirstUnitsParams.f12089b);
        }
        this.f10476c.a(timelineFirstUnitsUserString, this.f10475b.c());
        this.f10478e.a(timelineFirstUnitsUserString);
        this.f10482i.a(timelineFirstUnitsUserString);
        SocialSearchParamBuilderUtil.a(timelineFirstUnitsUserString);
        if (this.f10479f != null && ((VideoDashConfig) this.f10479f.get()).b()) {
            timelineFirstUnitsUserString.a("scrubbing", "MPEG_DASH");
        }
        this.f10480g.a(timelineFirstUnitsUserString, EntryPointInputVideoChannelEntryPoint.PROFILE);
        return timelineFirstUnitsUserString;
    }
}
