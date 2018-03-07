package com.facebook.instantshopping.view.transition;

import android.view.ViewParent;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.transition.MediaSlideTransitionStrategy.FullscreenMediaSlideTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: SPACER */
public class FullscreenInstantShoppingMediaSlideTransitionStrategy extends FullscreenMediaSlideTransitionStrategy {
    public FullscreenInstantShoppingMediaSlideTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        a(new MediaLayoutStrategy(MediaTransitionState.a, (MediaFrame) this.a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(0.0f)));
        a(new MediaLayoutStrategy(MediaTransitionState.b, (MediaFrame) this.a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
    }

    protected final SlideshowView m25128h() {
        ViewParent parent = m().getParent();
        while (!(parent instanceof SlideshowView)) {
            parent = parent.getParent();
        }
        return (SlideshowView) parent;
    }

    public final boolean m25129j() {
        return false;
    }
}
