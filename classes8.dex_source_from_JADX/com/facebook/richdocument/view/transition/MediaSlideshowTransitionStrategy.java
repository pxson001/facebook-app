package com.facebook.richdocument.view.transition;

import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.CollapsedCoverMediaLayoutStrategy;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: other_end_cursor */
public class MediaSlideshowTransitionStrategy extends MediaTransitionStrategy {
    public boolean f6975a = false;

    /* compiled from: other_end_cursor */
    public class CoverMediaSlideshowTransitionStrategy extends MediaSlideshowTransitionStrategy {
        public CoverMediaSlideshowTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new CollapsedCoverMediaLayoutStrategy((MediaFrame) this.f6946a));
            m7198a(new MediaLayoutStrategy(this, MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(0.0f)) {
                final /* synthetic */ CoverMediaSlideshowTransitionStrategy f6974e;

                protected final void mo416g() {
                    m7231a(m7240m(), new ViewRect(this.f6967k));
                }
            });
        }

        public final TransitionState mo420d() {
            return MediaTransitionState.f6977a;
        }
    }

    public MediaSlideshowTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        m7198a(new MediaLayoutStrategy(this, MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)) {
            final /* synthetic */ MediaSlideshowTransitionStrategy f6973e;

            protected final void mo416g() {
                m7231a(m7240m(), new ViewRect(this.f6967k));
            }
        });
    }

    protected final void mo418g() {
        super.mo418g();
        if (mo420d() != MediaTransitionState.f6977a) {
            m7202c(MediaTransitionState.f6977a);
        }
    }

    public boolean mo419j() {
        return this.f6975a;
    }
}
