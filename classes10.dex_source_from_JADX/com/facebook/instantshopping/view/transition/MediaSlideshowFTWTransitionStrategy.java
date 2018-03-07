package com.facebook.instantshopping.view.transition;

import android.graphics.Rect;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: SJIS */
public class MediaSlideshowFTWTransitionStrategy extends MediaTransitionStrategy {
    public MediaSlideshowFTWTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        a(new MediaLayoutStrategy(this, MediaTransitionState.a, (MediaFrame) this.a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)) {
            final /* synthetic */ MediaSlideshowFTWTransitionStrategy f23856e;

            protected final void m25142g() {
                float l = l();
                if (e() != null) {
                    int width = e().width();
                    a(m(), new ViewRect(new Rect(0, 0, width + 0, Math.round(((float) width) / l) + 0)));
                    return;
                }
                super.g();
            }
        });
        a(new MediaLayoutStrategy(this, MediaTransitionState.b, (MediaFrame) this.a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)) {
            final /* synthetic */ MediaSlideshowFTWTransitionStrategy f23857e;

            protected final void m25143g() {
                a(m(), new ViewRect(this.k));
            }
        });
    }

    protected final void m25144g() {
        super.g();
        if (d() != MediaTransitionState.a) {
            c(MediaTransitionState.a);
        }
    }

    public final boolean m25145j() {
        return false;
    }
}
