package com.facebook.instantshopping.view.transition;

import android.graphics.Rect;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.transition.MediaSlideshowTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: SKIPPED */
public class MediaAdjustedHeightSlideShowTransitionStratergy extends MediaSlideshowTransitionStrategy {
    public MediaAdjustedHeightSlideShowTransitionStratergy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        a(new MediaLayoutStrategy(MediaTransitionState.a, (MediaFrame) this.a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        a(new MediaLayoutStrategy(this, MediaTransitionState.b, (MediaFrame) this.a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(1.0f)) {
            final /* synthetic */ MediaAdjustedHeightSlideShowTransitionStratergy f23855e;

            protected final void m25140g() {
                float k = k();
                float l = l();
                if (e() == null || l >= k) {
                    a(m(), new ViewRect(this.k));
                    return;
                }
                int width = e().width();
                a(m(), new ViewRect(new Rect(0, 0, width + 0, Math.round(((float) width) / l) + 0)));
            }
        });
    }

    public final boolean m25141j() {
        return false;
    }
}
