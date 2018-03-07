package com.facebook.slideshow.ui;

import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: PHOTO_CHECKUP_BULK_EDIT_ACCEPTED */
public class PlayableSlideshowViewControllerProvider extends AbstractAssistedProvider<PlayableSlideshowViewController> {
    public final PlayableSlideshowViewController m13014a(PlayableSlideshowView playableSlideshowView, String str) {
        return new PlayableSlideshowViewController(playableSlideshowView, str, FbDraweeControllerBuilder.b(this));
    }
}
