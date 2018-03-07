package com.facebook.feed.rows.sections.attachments;

import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;

/* compiled from: [B>; */
public class CollageAttachmentAnimationUtil {

    /* compiled from: [B>; */
    final class C17681 implements AnimationParamProvider {
        final /* synthetic */ CollageAttachmentView f20552a;
        final /* synthetic */ int f20553b;
        final /* synthetic */ ImageRequest f20554c;

        C17681(CollageAttachmentView collageAttachmentView, int i, ImageRequest imageRequest) {
            this.f20552a = collageAttachmentView;
            this.f20553b = i;
            this.f20554c = imageRequest;
        }

        public final AnimationParams mo47a(String str) {
            return new AnimationParams(DrawingRule.m12760a(this.f20552a.d(this.f20553b), this.f20552a, this.f20552a.c(this.f20553b)), this.f20554c);
        }
    }

    public static AnimationParamProvider m23613a(CollageAttachmentView collageAttachmentView, ImageRequest imageRequest, int i) {
        return new C17681(collageAttachmentView, i, imageRequest);
    }
}
