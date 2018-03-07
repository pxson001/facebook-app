package com.facebook.feed.rows.sections.attachments;

import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyleUtil;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: hide_link */
public class PhotoAttachmentUtil {
    private final FeedStoryUtil f21042a;
    private final QeAccessor f21043b;
    private final PositionResolver f21044c;

    public static PhotoAttachmentUtil m28776b(InjectorLike injectorLike) {
        return new PhotoAttachmentUtil(FeedStoryUtil.m18578a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), PositionResolver.m19143a(injectorLike));
    }

    @Inject
    public PhotoAttachmentUtil(FeedStoryUtil feedStoryUtil, QeAccessor qeAccessor, PositionResolver positionResolver) {
        this.f21042a = feedStoryUtil;
        this.f21043b = qeAccessor;
        this.f21044c = positionResolver;
    }

    public final PaddingStyle m28777a(FeedProps<GraphQLStoryAttachment> feedProps, HasPositionInformation hasPositionInformation) {
        if (this.f21042a.m18592d((FeedProps) feedProps) && this.f21043b.mo596a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
            return BackgroundStyleUtil.a(feedProps, this.f21044c, hasPositionInformation);
        }
        return PaddingStyle.f13076f;
    }

    public static PhotoAttachmentUtil m28775a(InjectorLike injectorLike) {
        return m28776b(injectorLike);
    }
}
