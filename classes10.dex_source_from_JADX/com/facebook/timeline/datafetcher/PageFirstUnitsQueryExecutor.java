package com.facebook.timeline.datafetcher;

import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLTimelineSectionsConnection;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.TimelineFirstUnits;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQL.TimelineFirstUnitsPageString;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.google.common.base.Function;

/* compiled from: group_edit_name_state */
public abstract class PageFirstUnitsQueryExecutor implements TimelineFirstUnitsQueryExecutor {
    public final GraphQLQueryExecutor f10398a;
    public final TimelineFirstUnitsQueryBuilder f10399b;

    /* compiled from: group_edit_name_state */
    class C15311 implements Function<GraphQLResult<GraphQLPage>, TimelineFirstUnits> {
        final /* synthetic */ PageFirstUnitsQueryExecutor f10420a;

        C15311(PageFirstUnitsQueryExecutor pageFirstUnitsQueryExecutor) {
            this.f10420a = pageFirstUnitsQueryExecutor;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            GraphQLTimelineSectionsConnection Y = ((GraphQLPage) graphQLResult.e).Y();
            FirstSectionChecker.m10525a(Y);
            return new TimelineFirstUnits(((GraphQLPage) graphQLResult.e).cc(), Y, graphQLResult.freshness);
        }
    }

    public PageFirstUnitsQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder) {
        this.f10398a = graphQLQueryExecutor;
        this.f10399b = timelineFirstUnitsQueryBuilder;
    }

    public final FirstUnitsObservables m10520a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder = this.f10399b;
        ScaleInputPixelRatio a = GraphQlQueryDefaults.a();
        GraphQlQueryString timelineFirstUnitsPageString = new TimelineFirstUnitsPageString();
        timelineFirstUnitsPageString.a("profile_image_size", GraphQLStoryHelper.a()).a("nodeId", String.valueOf(fetchTimelineFirstUnitsParams.f12088a)).a("angora_attachment_cover_image_size", timelineFirstUnitsQueryBuilder.f10474a.r()).a("angora_attachment_profile_image_size", timelineFirstUnitsQueryBuilder.f10474a.s()).a("reading_attachment_profile_image_width", timelineFirstUnitsQueryBuilder.f10474a.L()).a("reading_attachment_profile_image_height", timelineFirstUnitsQueryBuilder.f10474a.M()).a("image_large_aspect_height", timelineFirstUnitsQueryBuilder.f10474a.z()).a("image_large_aspect_width", timelineFirstUnitsQueryBuilder.f10474a.y()).a("include_replies_in_total_count", Boolean.toString(true)).a("default_image_scale", a).a("icon_scale", a).a("timeline_stories", "4").a("action_location", NegativeFeedbackExperienceLocation.TIMELINE.stringValueOf()).a("inline_comments_experiment", Boolean.toString(timelineFirstUnitsQueryBuilder.f10477d.a(ExperimentsForTimelineAbTestModule.W, true))).a("enable_download", Boolean.toString(timelineFirstUnitsQueryBuilder.f10477d.a(ExperimentsForVideoAbTestModule.cW, false))).a("automatic_photo_captioning_enabled", Boolean.toString(timelineFirstUnitsQueryBuilder.f10484k.a()));
        if (!StringUtil.a(fetchTimelineFirstUnitsParams.f12089b)) {
            timelineFirstUnitsPageString.a("timeline_filter", fetchTimelineFirstUnitsParams.f12089b);
        }
        timelineFirstUnitsQueryBuilder.f10476c.a(timelineFirstUnitsPageString, timelineFirstUnitsQueryBuilder.f10475b.c());
        timelineFirstUnitsQueryBuilder.f10478e.a(timelineFirstUnitsPageString);
        timelineFirstUnitsQueryBuilder.f10482i.a(timelineFirstUnitsPageString);
        SocialSearchParamBuilderUtil.a(timelineFirstUnitsPageString);
        if (timelineFirstUnitsQueryBuilder.f10479f != null && ((VideoDashConfig) timelineFirstUnitsQueryBuilder.f10479f.get()).b()) {
            timelineFirstUnitsPageString.a("scrubbing", "MPEG_DASH");
        }
        timelineFirstUnitsQueryBuilder.f10480g.a(timelineFirstUnitsPageString, EntryPointInputVideoChannelEntryPoint.PAGE);
        GraphQLRequest a2 = GraphQLRequest.a(timelineFirstUnitsPageString).a(RequestPriority.NON_INTERACTIVE);
        a2.f = callerContext;
        return m10519a(GraphQLResultNullChecker.m10533b(FutureToObservableConverter.m10531a(this.f10398a.a(a2.a(graphQLCachePolicy)))));
    }

    private FirstUnitsObservables m10519a(RequestObservable<GraphQLResult<GraphQLPage>> requestObservable) {
        return new FirstUnitsObservables(requestObservable.a(new C15311(this)), null, RequestObservable.b(), RequestObservable.b(), RequestObservable.b(), null, null, null, null);
    }
}
