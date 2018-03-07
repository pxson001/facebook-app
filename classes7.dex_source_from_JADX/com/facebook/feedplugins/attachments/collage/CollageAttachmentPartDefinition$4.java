package com.facebook.feedplugins.attachments.collage;

import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;

/* compiled from: TOO_CLOSE_TO_PREVIOUS_COMMERCIAL_BREAK */
public class CollageAttachmentPartDefinition$4 implements AnimationParamProvider {
    final /* synthetic */ CollageAttachmentView f22554a;
    final /* synthetic */ int f22555b;
    final /* synthetic */ ImageRequest f22556c;
    final /* synthetic */ CollageAttachmentPartDefinition f22557d;

    public CollageAttachmentPartDefinition$4(CollageAttachmentPartDefinition collageAttachmentPartDefinition, CollageAttachmentView collageAttachmentView, int i, ImageRequest imageRequest) {
        this.f22557d = collageAttachmentPartDefinition;
        this.f22554a = collageAttachmentView;
        this.f22555b = i;
        this.f22556c = imageRequest;
    }

    public final AnimationParams mo47a(String str) {
        return new AnimationParams(DrawingRule.m12760a(this.f22554a.d(this.f22555b), this.f22554a, this.f22554a.c(this.f22555b)), this.f22556c);
    }
}
