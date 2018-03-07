package com.facebook.api.ufiservices;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQL.FetchSingleCommentQueryString;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.executor.DefaultCacheProcessorFactory;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;

/* compiled from: platform_metadata */
public final class FetchSingleCommentMethod {
    public final GraphQLStoryHelper f4558a;
    public final SizeAwareImageUtil f4559b;
    public final QeAccessor f4560c;
    public final FetchReactorsParamBuilderUtil f4561d;
    public DefaultCacheProcessorFactory f4562e;
    public FetchVideoChannelParamBuilderUtil f4563f;
    public AutomaticPhotoCaptioningUtils f4564g;

    public static FetchSingleCommentMethod m5065b(InjectorLike injectorLike) {
        return new FetchSingleCommentMethod(GraphQLStoryHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), DefaultCacheProcessorFactory.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public FetchSingleCommentMethod(GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, QeAccessor qeAccessor, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, DefaultCacheProcessorFactory defaultCacheProcessorFactory, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f4558a = graphQLStoryHelper;
        this.f4559b = sizeAwareImageUtil;
        this.f4560c = qeAccessor;
        this.f4561d = fetchReactorsParamBuilderUtil;
        this.f4562e = defaultCacheProcessorFactory;
        this.f4563f = fetchVideoChannelParamBuilderUtil;
        this.f4564g = automaticPhotoCaptioningUtils;
    }

    public final GraphQLRequest<GraphQLComment> m5066a(FetchSingleCommentParams fetchSingleCommentParams) {
        GraphQlQueryString fetchSingleCommentQueryString = new FetchSingleCommentQueryString();
        fetchSingleCommentQueryString.a("profile_image_size", GraphQLStoryHelper.a()).a("likers_profile_image_size", this.f4558a.c());
        fetchSingleCommentQueryString.a("comment_id", fetchSingleCommentParams.a);
        fetchSingleCommentQueryString.a("angora_attachment_cover_image_size", this.f4558a.r());
        fetchSingleCommentQueryString.a("angora_attachment_profile_image_size", this.f4558a.s());
        fetchSingleCommentQueryString.a("reading_attachment_profile_image_width", this.f4558a.L());
        fetchSingleCommentQueryString.a("reading_attachment_profile_image_height", this.f4558a.M());
        fetchSingleCommentQueryString.a("include_permalink_title", Boolean.valueOf(fetchSingleCommentParams.f));
        fetchSingleCommentQueryString.a("include_comments_disabled_fields", Boolean.valueOf(fetchSingleCommentParams.k));
        fetchSingleCommentQueryString.a("include_replies_in_total_count", Boolean.toString(this.f4560c.a(ExperimentsForUfiServiceQeModule.l, false)));
        fetchSingleCommentQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f4564g.a()));
        if (fetchSingleCommentParams.g == null || !this.f4560c.a(ExperimentsForFeedbackTestModule.f, false)) {
            fetchSingleCommentQueryString.a("max_comments", Integer.valueOf(fetchSingleCommentParams.c));
        } else {
            fetchSingleCommentQueryString.a("surround_comment_id", fetchSingleCommentParams.g).a("num_before_surround", Integer.valueOf((fetchSingleCommentParams.c - 1) / 2)).a("surround_max_comments", Integer.valueOf(fetchSingleCommentParams.c));
        }
        this.f4563f.a(fetchSingleCommentQueryString);
        this.f4561d.a(fetchSingleCommentQueryString);
        GraphQLRequest<GraphQLComment> a = GraphQLRequest.a(this.f4559b.a(fetchSingleCommentQueryString), GraphQLComment.class);
        a.a(GraphQLCachePolicy.d);
        a.h = new FetchCommentGQLCacheProcessor(this, fetchSingleCommentParams, this.f4562e.a(a));
        return a;
    }
}
