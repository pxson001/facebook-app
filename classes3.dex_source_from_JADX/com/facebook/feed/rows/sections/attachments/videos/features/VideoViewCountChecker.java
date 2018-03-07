package com.facebook.feed.rows.sections.attachments.videos.features;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ufi/reactions/v2/16x16/wow */
public class VideoViewCountChecker {
    public final GraphQLStoryUtil f180a;

    public static VideoViewCountChecker m166b(InjectorLike injectorLike) {
        return new VideoViewCountChecker(GraphQLStoryUtil.a(injectorLike));
    }

    @Inject
    public VideoViewCountChecker(GraphQLStoryUtil graphQLStoryUtil) {
        this.f180a = graphQLStoryUtil;
    }

    public final boolean m168a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return m167c(feedProps) && this.f180a.i(AttachmentProps.e(feedProps)) > 0;
    }

    public static boolean m167c(@Nullable FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        return (graphQLStoryAttachment == null || AttachmentProps.c(feedProps) == null || !GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment) || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().j() == null || graphQLStoryAttachment.r().j().g() != 82650203 || graphQLStoryAttachment.r().aJ() <= 0) ? false : true;
    }
}
