package com.facebook.api.story;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feed.FetchFeedbackType;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import javax.annotation.Nullable;

/* compiled from: platform_db */
public abstract class FetchSingleStoryMethod extends AbstractPersistedGraphQlApiMethod<FetchSingleStoryParams, FetchSingleStoryResult> {
    protected final Resources f4585c;
    protected final GraphQLStoryHelper f4586d;
    protected final GraphQLImageHelper f4587e;
    protected final GraphQLProtocolHelper f4588f;
    protected final SizeAwareImageUtil f4589g;
    protected final QeAccessor f4590h;
    private final Clock f4591i;
    private ThreadedCommentParamBuilderUtil f4592j;
    private final FetchReactorsParamBuilderUtil f4593k;
    private final FetchRecentActivityParamBuilderUtil f4594l;
    private final SocialSearchParamBuilderUtil f4595m;
    private final TopicFeedsTestUtil f4596n;
    private final AutomaticPhotoCaptioningUtils f4597o;

    public final int m5078b(Object obj, ApiResponse apiResponse) {
        return ((FetchSingleStoryParams) obj).d == FetchType.GRAPHQL_PHOTO_CREATION_STORY ? 2 : 1;
    }

    public FetchSingleStoryMethod(Resources resources, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, GraphQLProtocolHelper graphQLProtocolHelper, SizeAwareImageUtil sizeAwareImageUtil, Clock clock, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, QeAccessor qeAccessor, TopicFeedsTestUtil topicFeedsTestUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        super(graphQLProtocolHelper);
        this.f4585c = resources;
        this.f4587e = graphQLImageHelper;
        this.f4586d = graphQLStoryHelper;
        this.f4588f = graphQLProtocolHelper;
        this.f4589g = sizeAwareImageUtil;
        this.f4591i = clock;
        this.f4592j = threadedCommentParamBuilderUtil;
        this.f4593k = fetchReactorsParamBuilderUtil;
        this.f4594l = fetchRecentActivityParamBuilderUtil;
        this.f4595m = socialSearchParamBuilderUtil;
        this.f4590h = qeAccessor;
        this.f4596n = topicFeedsTestUtil;
        this.f4597o = automaticPhotoCaptioningUtils;
    }

    protected final GraphQlQueryString m5076a(@Nullable FetchSingleStoryParams fetchSingleStoryParams, GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.a("profile_image_size", GraphQLStoryHelper.a());
        if (fetchSingleStoryParams != null) {
            graphQlQueryString.a("node_id", fetchSingleStoryParams.a);
            graphQlQueryString.a("include_comments_disabled_fields", Boolean.valueOf(fetchSingleStoryParams.h));
            if (FetchFeedbackType.getQueryType(fetchSingleStoryParams) == FetchFeedbackType.COMMENTS_AND_LIKERS) {
                graphQlQueryString.a("likers_profile_image_size", this.f4586d.c());
                if (!(fetchSingleStoryParams.f == null || fetchSingleStoryParams.f.equals(CommentOrderType.DEFAULT_ORDER))) {
                    graphQlQueryString.a("comment_order", fetchSingleStoryParams.f.toString);
                }
                if (fetchSingleStoryParams.g != null && fetchSingleStoryParams.f == CommentOrderType.THREADED_CHRONOLOGICAL_ORDER && this.f4590h.a(ExperimentsForFeedbackTestModule.f, false)) {
                    graphQlQueryString.a("surround_comment_id", fetchSingleStoryParams.g).a("num_before_surround", Integer.valueOf((fetchSingleStoryParams.e - 1) / 2)).a("surround_max_comments", Integer.valueOf(fetchSingleStoryParams.e));
                } else {
                    graphQlQueryString.a("max_comments", Integer.valueOf(fetchSingleStoryParams.e));
                    if (fetchSingleStoryParams.f == CommentOrderType.RANKED_ORDER) {
                        graphQlQueryString.a("comment_id", fetchSingleStoryParams.g);
                    }
                }
            }
        }
        graphQlQueryString.a("angora_attachment_cover_image_size", this.f4586d.r());
        graphQlQueryString.a("angora_attachment_profile_image_size", this.f4586d.s());
        graphQlQueryString.a("reading_attachment_profile_image_width", this.f4586d.L());
        graphQlQueryString.a("reading_attachment_profile_image_height", this.f4586d.M());
        graphQlQueryString.a("question_poll_count", GraphQLStoryHelper.c);
        graphQlQueryString.a("poll_voters_count", GraphQLStoryHelper.d);
        graphQlQueryString.a("poll_facepile_size", this.f4586d.P());
        graphQlQueryString.a("fetch_reshare_counts", Boolean.valueOf(this.f4590h.a(ExperimentsForFeedbackTestModule.T, false)));
        graphQlQueryString.a("topic_feeds_enabled", Boolean.valueOf(this.f4596n.b()));
        graphQlQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f4597o.a()));
        Enum a = GraphQlQueryDefaults.a();
        String str = "default_image_scale";
        if (a == null) {
            a = GraphQlQueryDefaults.a;
        }
        graphQlQueryString.a(str, a);
        graphQlQueryString.a("action_location", NegativeFeedbackExperienceLocation.NEWSFEED.stringValueOf());
        mo403b(fetchSingleStoryParams, graphQlQueryString);
        this.f4589g.a(graphQlQueryString, this.f4587e.c());
        graphQlQueryString.a("image_large_aspect_height", this.f4586d.z());
        graphQlQueryString.a("image_large_aspect_width", this.f4586d.y());
        this.f4592j.b(graphQlQueryString);
        this.f4593k.a(graphQlQueryString);
        this.f4594l.a(graphQlQueryString);
        SocialSearchParamBuilderUtil.a(graphQlQueryString);
        return graphQlQueryString;
    }

    public final Object m5077a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f4588f.a(jsonParser, GraphQLStory.class, "fetch_single_story");
        long a = this.f4591i.a();
        FetchTimeMsHelper.a(graphQLStory, a);
        if (graphQLStory.l() != null) {
            graphQLStory.l().s = a;
        }
        return new FetchSingleStoryResult(graphQLStory, DataFreshnessResult.FROM_SERVER, a);
    }

    protected void mo403b(@Nullable FetchSingleStoryParams fetchSingleStoryParams, GraphQlQueryString graphQlQueryString) {
    }
}
