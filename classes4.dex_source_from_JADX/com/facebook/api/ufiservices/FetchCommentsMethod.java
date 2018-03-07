package com.facebook.api.ufiservices;

import com.facebook.api.graphql.fetchcomments.FetchCommentsGraphQL.UFIFeedbackQueryString;
import com.facebook.api.graphql.fetchcomments.FetchCommentsGraphQL.UFILastFeedbackQueryString;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchCommentsParams;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;

/* compiled from: platform_publish_open_graph_action_params */
public final class FetchCommentsMethod {
    private final FetchFeedbackMethod f4553a;
    public final GraphQLStoryHelper f4554b;
    public final SizeAwareImageUtil f4555c;
    public final ThreadedCommentParamBuilderUtil f4556d;
    public FetchVideoChannelParamBuilderUtil f4557e;

    public static FetchCommentsMethod m5062b(InjectorLike injectorLike) {
        return new FetchCommentsMethod(FetchFeedbackMethod.b(injectorLike), GraphQLStoryHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), ThreadedCommentParamBuilderUtil.b(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike));
    }

    @Inject
    public FetchCommentsMethod(FetchFeedbackMethod fetchFeedbackMethod, GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil) {
        this.f4553a = fetchFeedbackMethod;
        this.f4554b = graphQLStoryHelper;
        this.f4555c = sizeAwareImageUtil;
        this.f4556d = threadedCommentParamBuilderUtil;
        this.f4557e = fetchVideoChannelParamBuilderUtil;
    }

    public final GraphQLRequest<GraphQLFeedback> m5063a(FetchCommentsParams fetchCommentsParams) {
        GraphQlQueryString uFIFeedbackQueryString;
        if (fetchCommentsParams == null || fetchCommentsParams.b == CommentLoadDirection.LOAD_AFTER) {
            uFIFeedbackQueryString = new UFIFeedbackQueryString();
        } else {
            uFIFeedbackQueryString = new UFILastFeedbackQueryString();
        }
        uFIFeedbackQueryString.a("profile_image_size", GraphQLStoryHelper.a()).a("likers_profile_image_size", this.f4554b.c());
        if (fetchCommentsParams != null) {
            uFIFeedbackQueryString.a("feedback_id", fetchCommentsParams.a).a("max_comments", String.valueOf(fetchCommentsParams.b));
            if (fetchCommentsParams.c != null) {
                uFIFeedbackQueryString.a("before_comments", fetchCommentsParams.c);
            }
            if (fetchCommentsParams.d != null) {
                uFIFeedbackQueryString.a("after_comments", fetchCommentsParams.d);
            }
            if (!(fetchCommentsParams.a == null || fetchCommentsParams.a.equals(CommentOrderType.DEFAULT_ORDER))) {
                uFIFeedbackQueryString.a("comment_order", fetchCommentsParams.a.toString);
            }
        }
        uFIFeedbackQueryString.a("angora_attachment_cover_image_size", this.f4554b.r());
        uFIFeedbackQueryString.a("angora_attachment_profile_image_size", this.f4554b.s());
        uFIFeedbackQueryString.a("reading_attachment_profile_image_width", this.f4554b.L());
        uFIFeedbackQueryString.a("reading_attachment_profile_image_height", this.f4554b.M());
        ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil = this.f4556d;
        CommentOrderType commentOrderType = fetchCommentsParams.a;
        threadedCommentParamBuilderUtil.a(uFIFeedbackQueryString, false);
        this.f4557e.a(uFIFeedbackQueryString);
        this.f4555c.a(uFIFeedbackQueryString);
        GraphQLRequest<GraphQLFeedback> a = GraphQLRequest.a(uFIFeedbackQueryString);
        if (fetchCommentsParams.e == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a.a(GraphQLCachePolicy.d);
        } else {
            a.a(GraphQLCachePolicy.a);
        }
        a.h = this.f4553a.a(fetchCommentsParams, a);
        return a;
    }
}
