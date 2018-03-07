package com.facebook.richdocument.view.transition;

import android.graphics.Rect;
import android.view.View;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import java.util.Iterator;

/* compiled from: overflow_first */
public abstract class MediaTransitionStrategy extends ResizeTransitionStrategy<MediaFrame, MediaTransitionState> {

    /* compiled from: overflow_first */
    public class AspectFitMediaTransitionStrategy extends MediaTransitionStrategy {
        public AspectFitMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        }
    }

    /* compiled from: overflow_first */
    public class AspectFitCoverMediaTransitionStrategy extends AspectFitMediaTransitionStrategy {
        public AspectFitCoverMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new CollapsedCoverMediaLayoutStrategy((MediaFrame) this.f6946a));
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(1.0f)));
        }
    }

    /* compiled from: overflow_first */
    public class AspectFitOnlyMediaTransitionStrategy extends MediaTransitionStrategy {
        public AspectFitOnlyMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        }
    }

    /* compiled from: overflow_first */
    public class AspectFitOnlyCoverMediaTransitionStrategy extends AspectFitOnlyMediaTransitionStrategy {
        public AspectFitOnlyCoverMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new CollapsedCoverMediaLayoutStrategy((MediaFrame) this.f6946a));
        }
    }

    /* compiled from: overflow_first */
    public class CollapsedCoverMediaLayoutStrategy extends MediaLayoutStrategy {
        public CollapsedCoverMediaLayoutStrategy(MediaFrame mediaFrame) {
            super(MediaTransitionState.f6977a, mediaFrame, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(0.0f));
        }

        protected final void mo416g() {
            int width = m7232e().width();
            int round = Math.round(((float) width) / m7239l());
            int p = m7273p();
            if (round > p) {
                p = (p - round) / 2;
            } else {
                p = 0;
            }
            m7231a(m7240m(), new ViewRect(new Rect(0, p, width + 0, round + p)));
        }

        protected final void mo423h() {
            m7231a(m7241n(), new ViewRect(new Rect(0, 0, m7232e().width(), Math.min(m7230a(m7240m()).m7329f(), m7273p()))));
            m7231a(m7241n(), new ViewAngle((float) this.f6958b.getDegree()));
        }

        protected final ViewRect mo425j() {
            Rect rect = new Rect(m7230a(this.f6962f.getOverlayView()).f7004a);
            rect.left = 0;
            rect.right = this.f6967k.width();
            return new ViewRect(rect);
        }

        private int m7273p() {
            return Math.round(((float) m7232e().width()) / 1.3333334f);
        }

        protected final void mo424i() {
            super.mo424i();
            Iterator it = m7241n().getAnnotationViews().iterator();
            while (it.hasNext()) {
                AnnotationView annotationView = (AnnotationView) it.next();
                AnnotationType annotationType = annotationView.getAnnotation().f5608a;
                AnnotationSlot annotationSlot = annotationView.getAnnotation().f5612e;
                if (annotationType == AnnotationType.COPYRIGHT && (annotationSlot == AnnotationSlot.TOP || annotationSlot == AnnotationSlot.CENTER || annotationSlot == AnnotationSlot.BOTTOM)) {
                    m7231a(annotationView.mo438b(), new ViewOpacity(1.0f));
                }
                m7231a(annotationView.mo438b(), new FadeWithControls(false));
            }
        }
    }

    /* compiled from: overflow_first */
    public class FullscreenMediaTransitionStrategy extends MediaTransitionStrategy {
        public FullscreenMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(0.0f)));
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(1.0f)));
        }

        public final boolean mo426a(MediaTransitionState mediaTransitionState, MediaTransitionState mediaTransitionState2) {
            if (mediaTransitionState == MediaTransitionState.f6977a && mediaTransitionState2 == MediaTransitionState.f6978b) {
                return false;
            }
            return super.mo426a(mediaTransitionState, mediaTransitionState2);
        }
    }

    /* compiled from: overflow_first */
    class LandscapeMediaLayoutStrategy extends MediaLayoutStrategy {
        public LandscapeMediaLayoutStrategy(MediaTransitionState mediaTransitionState, MediaFrame mediaFrame, Float f, Orientation orientation) {
            super(mediaTransitionState, mediaFrame, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_DEFAULT, f, orientation);
        }
    }

    /* compiled from: overflow_first */
    public class NonInteractiveMediaTransitionStrategy extends MediaTransitionStrategy {
        public NonInteractiveMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        }

        public final boolean mo419j() {
            return false;
        }
    }

    /* compiled from: overflow_first */
    public class NonInteractiveCoverMediaTransitionStrategy extends NonInteractiveMediaTransitionStrategy {
        public NonInteractiveCoverMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new CollapsedCoverMediaLayoutStrategy((MediaFrame) this.f6946a));
        }
    }

    public MediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        if (mo419j()) {
            m7198a(new LandscapeMediaLayoutStrategy(MediaTransitionState.f6979c, (MediaFrame) this.f6946a, Float.valueOf(0.0f), Orientation.LANDSCAPE_LEFT));
            m7198a(new LandscapeMediaLayoutStrategy(MediaTransitionState.f6980d, (MediaFrame) this.f6946a, Float.valueOf(0.0f), Orientation.LANDSCAPE_RIGHT));
        }
    }

    public final ViewLayout mo417a(boolean z) {
        ViewLayout a = super.mo417a(z);
        View m = m7255m();
        ViewRect a2 = m7248a(a, m);
        a2.m7325b(m.getLeft());
        a2.m7323a(m.getTop());
        return a;
    }

    protected final View m7255m() {
        return ((MediaFrame) this.f6946a).mo480b();
    }

    protected void mo418g() {
        mo421k();
        m7245a(MediaTransitionState.f6977a, this.f6971a);
        m7245a(MediaTransitionState.f6978b, this.f6972b);
        if (mo419j()) {
            m7245a(MediaTransitionState.f6979c, m7247q());
            m7245a(MediaTransitionState.f6980d, m7247q());
        }
    }

    public final boolean m7254l() {
        if (super.mo417a(false) != null) {
            return true;
        }
        return false;
    }

    protected void mo421k() {
        View view = (View) m7255m().getParent();
        m7244a(view.getWidth(), view.getHeight());
        m7246b(view.getWidth(), view.getHeight());
    }

    protected static ViewRect m7248a(ViewLayout viewLayout, View view) {
        return (ViewRect) viewLayout.mo428a(view, ViewAttributeType.RECT, ViewRect.class);
    }

    public boolean mo419j() {
        return true;
    }

    public boolean mo426a(MediaTransitionState mediaTransitionState, MediaTransitionState mediaTransitionState2) {
        return true;
    }
}
