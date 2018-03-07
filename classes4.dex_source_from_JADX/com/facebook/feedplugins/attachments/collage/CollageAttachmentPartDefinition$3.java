package com.facebook.feedplugins.attachments.collage;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.SnowflakeLauncherHelper;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition.4;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.google.common.collect.ImmutableList;

/* compiled from: oauth/access_token */
class CollageAttachmentPartDefinition$3 implements OnImageClickListener<StoryCollageItem> {
    final /* synthetic */ ImmutableList f6303a;
    final /* synthetic */ int f6304b;
    final /* synthetic */ FeedProps f6305c;
    final /* synthetic */ ImageRequest[] f6306d;
    final /* synthetic */ HasFeedListType f6307e;
    final /* synthetic */ FeedListType f6308f;
    final /* synthetic */ CollageAttachmentPartDefinition f6309g;

    CollageAttachmentPartDefinition$3(CollageAttachmentPartDefinition collageAttachmentPartDefinition, ImmutableList immutableList, int i, FeedProps feedProps, ImageRequest[] imageRequestArr, HasFeedListType hasFeedListType, FeedListType feedListType) {
        this.f6309g = collageAttachmentPartDefinition;
        this.f6303a = immutableList;
        this.f6304b = i;
        this.f6305c = feedProps;
        this.f6306d = imageRequestArr;
        this.f6307e = hasFeedListType;
        this.f6308f = feedListType;
    }

    public final void mo565a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        if (!storyCollageItem.mo563a() || (i == this.f6303a.size() - 1 && this.f6304b > 1)) {
            ImageRequest imageRequest;
            4 4;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) storyCollageItem.f6295a.a;
            ImageRequest a = this.f6309g.h.a(this.f6305c, graphQLStoryAttachment);
            if (a == null) {
                imageRequest = null;
            } else {
                ImageRequestBuilder a2 = ImageRequestBuilder.a(a);
                a2.j = CollageAttachmentPartDefinition.a(this.f6309g, this.f6307e, graphQLStoryAttachment.r());
                imageRequest = a2.m();
            }
            SnowflakeLauncherHelper snowflakeLauncherHelper = this.f6309g.i;
            FeedProps feedProps = this.f6305c;
            FeedListType feedListType = this.f6308f;
            String b = storyCollageItem.mo564b().b();
            boolean d = CollageAttachmentPartDefinition.d(this.f6309g);
            CollageAttachmentPartDefinition collageAttachmentPartDefinition = this.f6309g;
            if (imageRequest == null) {
                4 = null;
            } else {
                4 = new 4(collageAttachmentPartDefinition, collageAttachmentView, i, imageRequest);
            }
            snowflakeLauncherHelper.a(feedProps, i, collageAttachmentView, feedListType, b, d, 4, (HasInvalidate) this.f6307e);
            return;
        }
        CollageAttachmentPartDefinition.a(this.f6309g, collageAttachmentView, storyCollageItem.mo564b(), this.f6305c, this.f6306d, FullscreenGallerySource.NEWSFEED, i);
    }
}
