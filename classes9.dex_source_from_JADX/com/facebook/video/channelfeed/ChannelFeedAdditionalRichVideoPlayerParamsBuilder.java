package com.facebook.video.channelfeed;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: terms_uri */
public class ChannelFeedAdditionalRichVideoPlayerParamsBuilder {
    private final VideoSizer f2084a;

    public static ChannelFeedAdditionalRichVideoPlayerParamsBuilder m2099b(InjectorLike injectorLike) {
        return new ChannelFeedAdditionalRichVideoPlayerParamsBuilder(VideoSizer.a(injectorLike));
    }

    @Inject
    public ChannelFeedAdditionalRichVideoPlayerParamsBuilder(VideoSizer videoSizer) {
        this.f2084a = videoSizer;
    }

    @Nullable
    public final Builder<String, Object> m2100a(FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return null;
        }
        FeedProps i = StoryProps.i(feedProps);
        if (i == null) {
            return null;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) i.a;
        GraphQLMedia r = graphQLStoryAttachment.r();
        if (r == null) {
            return null;
        }
        if (r.j() == null || r.j().g() != 82650203) {
            return null;
        }
        ImageRequest imageRequest;
        Builder<String, Object> b = new Builder().b("GraphQLStoryProps", feedProps).b("VideoAspectRatioKey", Double.valueOf(this.f2084a.c(i, 0.0f))).b("SubtitlesLocalesKey", r.bl()).b("ShowDeleteOptionKey", Boolean.valueOf(r.t())).b("ShowReportOptionKey", Boolean.valueOf(r.y()));
        Preconditions.checkNotNull(graphQLStoryAttachment);
        if (graphQLStoryAttachment.r() == null || !GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment) || graphQLStoryAttachment.r().S() == null) {
            imageRequest = null;
        } else {
            imageRequest = ImageRequest.a(graphQLStoryAttachment.r().S().b());
        }
        ImageRequest imageRequest2 = imageRequest;
        if (imageRequest2 != null) {
            b.b("CoverImageParamsKey", imageRequest2);
        }
        return b;
    }
}
