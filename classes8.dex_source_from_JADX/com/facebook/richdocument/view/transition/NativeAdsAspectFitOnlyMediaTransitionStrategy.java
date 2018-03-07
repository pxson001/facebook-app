package com.facebook.richdocument.view.transition;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.MediaLayoutType;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.OverlayLayoutType;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: otd_permalink */
public class NativeAdsAspectFitOnlyMediaTransitionStrategy extends MediaTransitionStrategy {

    /* compiled from: otd_permalink */
    public class NativeAdsMediaLayoutStrategy extends MediaLayoutStrategy {
        @Inject
        public HamDimensions f6984e;

        public static void m7280a(Object obj, Context context) {
            ((NativeAdsMediaLayoutStrategy) obj).f6984e = HamDimensions.m5268a(FbInjector.get(context));
        }

        public NativeAdsMediaLayoutStrategy(MediaTransitionState mediaTransitionState, MediaFrame mediaFrame, MediaLayoutType mediaLayoutType, OverlayLayoutType overlayLayoutType, AnnotationLayoutType annotationLayoutType, Float f) {
            super(mediaTransitionState, mediaFrame, mediaLayoutType, overlayLayoutType, annotationLayoutType, f);
            Class cls = NativeAdsMediaLayoutStrategy.class;
            m7280a(this, mediaFrame.getContext());
        }

        protected final void mo416g() {
            int width;
            int i;
            int i2;
            if (m7232e() != null) {
                width = m7232e().width();
                if (this.f6957a == OverlayLayoutType.OVERLAY_MEDIA) {
                    width = m7232e().width() - (this.f6984e.m5276b(2131558654) * 2);
                }
                i = width;
                width = m7232e().height();
            } else {
                width = 0;
                i = 0;
            }
            float k = m7238k();
            float l = m7239l();
            if (this.f6959c != MediaLayoutType.MEDIA_ASPECT_FIT) {
                i2 = 0;
            } else if (l >= k) {
                width = Math.round(((float) i) / l);
                i2 = 0;
            } else {
                i2 = Math.round(((float) width) * l);
                int i3 = i2;
                i2 = (i - i2) / 2;
                i = i3;
            }
            m7231a(m7240m(), new ViewRect(new Rect(i2, 0, i + i2, width + 0)));
        }

        protected final void mo423h() {
            Rect rect;
            ViewRect a = m7230a(m7240m());
            if (this.f6957a == OverlayLayoutType.OVERLAY_MEDIA) {
                rect = new Rect(0, 0, a.m7328e(), a.m7329f());
            } else {
                rect = m7232e();
            }
            if (rect != null) {
                MediaLayoutStrategy.m7223a(a, rect);
            }
            m7231a(m7241n(), new ViewRect(rect));
            m7231a(m7241n(), new ViewAngle((float) this.f6958b.getDegree()));
        }
    }

    public NativeAdsAspectFitOnlyMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
        m7198a(new NativeAdsMediaLayoutStrategy(MediaTransitionState.f6977a, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_MEDIA, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
        m7198a(new NativeAdsMediaLayoutStrategy(MediaTransitionState.f6978b, (MediaFrame) this.f6946a, MediaLayoutType.MEDIA_ASPECT_FIT, OverlayLayoutType.OVERLAY_VIEWPORT, AnnotationLayoutType.ANNOTATION_DEFAULT, Float.valueOf(1.0f)));
    }

    protected final void mo421k() {
        View view = (View) m7255m().getParent();
        while (!(view instanceof RecyclerView) && view.getParent() != null) {
            view = (View) view.getParent();
        }
        m7244a(view.getWidth(), view.getHeight());
        m7246b(view.getWidth(), view.getHeight());
    }
}
