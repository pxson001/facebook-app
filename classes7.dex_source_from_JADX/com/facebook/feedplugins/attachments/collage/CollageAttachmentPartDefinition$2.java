package com.facebook.feedplugins.attachments.collage;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;

/* compiled from: TOO_CLOSE_TO_PREVIOUS_COMMERCIAL_BREAK */
class CollageAttachmentPartDefinition$2 implements OnImageClickListener<StoryCollageItem> {
    final /* synthetic */ FeedProps f22549a;
    final /* synthetic */ ImageRequest[] f22550b;
    final /* synthetic */ FullscreenGallerySource f22551c;
    final /* synthetic */ boolean f22552d;
    final /* synthetic */ CollageAttachmentPartDefinition f22553e;

    CollageAttachmentPartDefinition$2(CollageAttachmentPartDefinition collageAttachmentPartDefinition, FeedProps feedProps, ImageRequest[] imageRequestArr, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        this.f22553e = collageAttachmentPartDefinition;
        this.f22549a = feedProps;
        this.f22550b = imageRequestArr;
        this.f22551c = fullscreenGallerySource;
        this.f22552d = z;
    }

    public final void m25255a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        boolean z = false;
        if (storyCollageItem.a()) {
            CollageAttachmentPartDefinition.a(this.f22553e, collageAttachmentView, storyCollageItem.b(), this.f22549a, this.f22550b, this.f22551c, i);
            return;
        }
        if (!this.f22552d && this.f22553e.o.a(ExperimentsForMediaGalleryAbTestModule.f10688l, false)) {
            z = true;
        }
        ((CollageMediaGalleryLaunchHelper) this.f22553e.g.get()).m25262a(collageAttachmentView, i, this.f22549a, this.f22550b[i], this.f22551c, this.f22552d, z);
    }
}
