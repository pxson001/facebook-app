package com.facebook.richdocument.view.transition;

import android.graphics.Rect;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: override_ids */
public abstract class MediaSlideTransitionStrategy extends MediaTransitionStrategy {

    /* compiled from: override_ids */
    public class AspectFitMediaSlideTransitionStrategy extends MediaSlideTransitionStrategy {
        public AspectFitMediaSlideTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(this, MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(0.0f)) {
                final /* synthetic */ AspectFitMediaSlideTransitionStrategy f6969e;

                protected final void mo416g() {
                    int i = 0;
                    float k = m7238k();
                    float l = m7239l();
                    if (((double) Math.abs(l - k)) <= RichDocumentUIConfig.f6561n) {
                        int round;
                        int width = this.f6967k.width();
                        int height = this.f6967k.height();
                        int i2;
                        if (l >= k) {
                            height = this.f6967k.height();
                            round = Math.round(((float) height) * l);
                            i2 = height;
                            height = (width - round) / 2;
                            width = i2;
                        } else {
                            round = Math.round(((float) width) / l);
                            i2 = width;
                            width = round;
                            round = i2;
                            i = (height - round) / 2;
                            height = 0;
                        }
                        m7231a(m7240m(), new ViewRect(new Rect(height, i, round + height, width + i)));
                        return;
                    }
                    super.mo416g();
                }
            });
            m7198a(new MediaLayoutStrategy(this, MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(1.0f)) {
                final /* synthetic */ AspectFitMediaSlideTransitionStrategy f6970e;

                protected final void mo416g() {
                    if (Math.abs(m7239l() - m7238k()) > RichDocumentUIConfig.f6564q) {
                        super.mo416g();
                        return;
                    }
                    int width = this.f6967k.width();
                    int height = this.f6967k.height();
                    int round = Math.round(((float) height) * m7239l());
                    width = (width - round) / 2;
                    m7231a(m7240m(), new ViewRect(new Rect(width, 0, round + width, height + 0)));
                }
            });
        }

        public final TransitionState mo420d() {
            try {
                return ((MediaTransitionState) m7257i().m7205e()).m7272e();
            } catch (Exception e) {
                return MediaTransitionState.f6977a;
            }
        }

        protected final void mo421k() {
            AbstractTransitionStrategy i = m7257i();
            ViewRect a = MediaTransitionStrategy.m7248a(i.m7196a(MediaTransitionState.f6977a, false), m7256h());
            m7244a(a.m7328e(), a.m7329f());
            ViewRect a2 = MediaTransitionStrategy.m7248a(i.m7196a(MediaTransitionState.f6978b, false), m7256h());
            m7246b(a2.m7328e(), a2.m7329f());
        }

        protected final void mo418g() {
            super.mo418g();
            m7199a(m7257i().f6952g);
        }
    }

    /* compiled from: override_ids */
    public class FullscreenMediaSlideTransitionStrategy extends MediaSlideTransitionStrategy {
        public FullscreenMediaSlideTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
            super(mediaFrame, transitionSpring);
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(0.0f)));
            m7198a(new MediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_FULLSCREEN, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_OVERLAY, Float.valueOf(1.0f)));
        }

        public final TransitionState mo420d() {
            return MediaTransitionState.f6978b;
        }

        protected final void mo421k() {
            ViewRect a = MediaTransitionStrategy.m7248a(m7257i().m7196a(MediaTransitionState.f6978b, false), m7256h());
            m7244a(a.m7328e(), a.m7329f());
            m7246b(a.m7328e(), a.m7329f());
        }

        protected final void mo418g() {
            Object obj;
            super.mo418g();
            if (Math.abs(((MediaFrame) this.f6946a).getMediaView().getMediaAspectRatio() - (((float) this.f6971a.width()) / ((float) this.f6971a.height()))) > RichDocumentUIConfig.f6564q) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                m7202c(MediaTransitionState.f6977a);
            }
        }
    }

    public MediaSlideTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        ((MarginLayoutParams) mediaFrame.mo480b().getLayoutParams()).setMargins(0, 0, 0, 0);
    }

    protected SlideshowView m7256h() {
        return (SlideshowView) m7255m().getParent();
    }

    protected final MediaTransitionStrategy m7257i() {
        return m7256h().getMediaFrame().getTransitionStrategy();
    }

    public boolean mo419j() {
        return false;
    }
}
