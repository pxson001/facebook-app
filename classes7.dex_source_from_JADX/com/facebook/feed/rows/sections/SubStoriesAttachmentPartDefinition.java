package com.facebook.feed.rows.sections;

import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.PhotoPartDefinition.PhotoProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

/* compiled from: \r */
public class SubStoriesAttachmentPartDefinition<E extends HasInvalidate> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, ImageBlockLayout> {
    private static final CallerContext f20435a = CallerContext.a(SubStoriesPagePartDefinition.class, "native_newsfeed", "profile_image");
    private final float f20436b;
    private final SubStoriesSubtitlePartDefinition<E> f20437c;
    private final SubStoriesTitlePartDefinition<E> f20438d;
    private final ActionButtonPartDefinition<E, GenericActionButtonView> f20439e;
    private final PhotoPartDefinition f20440f;
    private final AttachmentLinkPartDefinition f20441g;
    private final FbDraweeControllerBuilder f20442h;
    private final FeedImageLoader f20443i;

    public final Object m23534a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(2131562971, this.f20437c, graphQLStoryAttachment);
        subParts.a(2131562970, this.f20438d, graphQLStoryAttachment);
        subParts.a(2131567739, this.f20439e, feedProps);
        subParts.a(2131562969, this.f20440f, new PhotoProps(((FbDraweeControllerBuilder) this.f20442h.a(f20435a).c(this.f20443i.a(graphQLStoryAttachment.r(), FeedImageType.Share))).s(), this.f20436b));
        subParts.a(this.f20441g, new Props(feedProps));
        return null;
    }

    @Inject
    public SubStoriesAttachmentPartDefinition(@Assisted Float f, PhotoPartDefinition photoPartDefinition, SubStoriesTitlePartDefinition subStoriesTitlePartDefinition, SubStoriesSubtitlePartDefinition subStoriesSubtitlePartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder, FeedImageLoader feedImageLoader) {
        this.f20436b = f.floatValue();
        this.f20437c = subStoriesSubtitlePartDefinition;
        this.f20438d = subStoriesTitlePartDefinition;
        this.f20439e = actionButtonPartDefinition;
        this.f20441g = attachmentLinkPartDefinition;
        this.f20443i = feedImageLoader;
        this.f20442h = fbDraweeControllerBuilder;
        this.f20440f = photoPartDefinition;
    }
}
