package com.facebook.photos.mediagallery.launcher.animation;

import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: is_untitled_album */
public class AnimationParams {
    public final ImageRequest f10717a;
    public final DrawingRule f10718b;

    @Nullable
    public static AnimationParams m12756a(DraweeView draweeView, ImageRequest imageRequest) {
        Preconditions.checkNotNull(draweeView);
        if (draweeView == null || draweeView.getController() == null) {
            return null;
        }
        return new AnimationParams(DrawingRule.m12761a(draweeView), imageRequest);
    }

    public AnimationParams(DrawingRule drawingRule, ImageRequest imageRequest) {
        this.f10718b = (DrawingRule) Preconditions.checkNotNull(drawingRule);
        this.f10717a = (ImageRequest) Preconditions.checkNotNull(imageRequest);
    }
}
