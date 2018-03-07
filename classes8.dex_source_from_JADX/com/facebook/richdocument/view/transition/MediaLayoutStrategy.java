package com.facebook.richdocument.view.transition;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.common.util.CollectionUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.richdocument.ham.RichDocumentPaddingCalculator;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.AnnotationViews;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.MediaFrameBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: owner_profile_picture_url */
public class MediaLayoutStrategy implements InjectableComponentWithoutContext {
    public final OverlayLayoutType f6957a;
    public final Orientation f6958b;
    public final MediaLayoutType f6959c;
    @Inject
    public RichDocumentPaddingCalculator f6960d;
    public final MediaTransitionState f6961e;
    public final MediaFrame f6962f;
    public final AnnotationLayoutType f6963g;
    private final Float f6964h;
    private final Map<AnnotationView, Integer> f6965i;
    public final ViewLayout f6966j;
    public Rect f6967k;
    private Rect f6968l;

    /* compiled from: owner_profile_picture_url */
    public enum AnnotationLayoutType {
        ANNOTATION_DEFAULT,
        ANNOTATION_OVERLAY
    }

    /* compiled from: owner_profile_picture_url */
    public enum MediaLayoutType {
        MEDIA_ASPECT_FIT,
        MEDIA_FULLSCREEN
    }

    /* compiled from: owner_profile_picture_url */
    public enum OverlayLayoutType {
        OVERLAY_VIEWPORT,
        OVERLAY_MEDIA
    }

    public static void m7225a(Object obj, Context context) {
        ((MediaLayoutStrategy) obj).f6960d = RichDocumentPaddingCalculator.m5294a(FbInjector.get(context));
    }

    public MediaLayoutStrategy(MediaTransitionState mediaTransitionState, MediaFrame mediaFrame, MediaLayoutType mediaLayoutType, OverlayLayoutType overlayLayoutType, AnnotationLayoutType annotationLayoutType, Float f) {
        this(mediaTransitionState, mediaFrame, mediaLayoutType, overlayLayoutType, annotationLayoutType, f, Orientation.PORTRAIT);
    }

    public MediaLayoutStrategy(MediaTransitionState mediaTransitionState, MediaFrame mediaFrame, MediaLayoutType mediaLayoutType, OverlayLayoutType overlayLayoutType, AnnotationLayoutType annotationLayoutType, Float f, Orientation orientation) {
        this.f6965i = new HashMap();
        this.f6961e = mediaTransitionState;
        this.f6962f = mediaFrame;
        this.f6959c = mediaLayoutType;
        this.f6957a = overlayLayoutType;
        this.f6963g = annotationLayoutType;
        this.f6964h = f;
        this.f6958b = orientation;
        this.f6966j = new ViewLayoutImpl((TransitionState) mediaTransitionState);
        Class cls = MediaLayoutStrategy.class;
        m7225a((Object) this, mediaFrame.getContext());
    }

    protected final Rect m7232e() {
        if (this.f6968l == null && this.f6967k != null) {
            if (this.f6958b == Orientation.LANDSCAPE_LEFT || this.f6958b == Orientation.LANDSCAPE_RIGHT) {
                this.f6968l = new Rect(0, 0, this.f6967k.height(), this.f6967k.width());
            } else {
                this.f6968l = new Rect(this.f6967k);
            }
        }
        return this.f6968l;
    }

    public final ViewLayout m7233f() {
        Rect rect;
        mo416g();
        mo423h();
        mo424i();
        m7228q();
        if (this.f6957a == OverlayLayoutType.OVERLAY_MEDIA) {
            rect = m7230a(m7241n()).f7004a;
        } else {
            rect = this.f6967k;
        }
        m7231a(this.f6962f.getOverlayView(), new ViewRect(rect));
        m7229s();
        ViewRect j = mo425j();
        if (this.f6963g != AnnotationLayoutType.ANNOTATION_DEFAULT || (this.f6959c == MediaLayoutType.MEDIA_ASPECT_FIT && this.f6957a == OverlayLayoutType.OVERLAY_MEDIA)) {
            m7223a(j, this.f6967k);
        } else {
            Rect rect2 = m7230a(m7241n()).f7004a;
            ViewRect viewRect = new ViewRect(rect2);
            m7223a(viewRect, this.f6967k);
            j.m7325b(viewRect.f7004a.left - rect2.left);
            j.m7323a(viewRect.f7004a.top - rect2.top);
        }
        m7231a(this.f6962f.mo480b(), (ViewAttribute) j);
        return this.f6966j;
    }

    protected void mo416g() {
        int i;
        int i2 = 0;
        int width = m7232e().width();
        int height = m7232e().height();
        float k = m7238k();
        float l = m7239l();
        if (this.f6959c == MediaLayoutType.MEDIA_ASPECT_FIT) {
            if (l >= k) {
                height = Math.round(((float) width) / l);
                i = width;
                width = 0;
            } else {
                i = Math.round(((float) height) * l);
                width = (width - i) / 2;
            }
        } else if (((double) Math.abs(l - k)) > RichDocumentUIConfig.f6560m || l >= k) {
            i = Math.round(((float) height) * m7239l());
            width = (width - i) / 2;
        } else {
            i = Math.round(((float) width) / l);
            int i3 = i;
            i = width;
            width = 0;
            i2 = (height - i) / 2;
            height = i3;
        }
        m7231a(m7240m(), new ViewRect(new Rect(width, i2, i + width, height + i2)));
    }

    protected void mo423h() {
        Rect rect;
        ViewRect a = m7230a(m7240m());
        if (this.f6957a == OverlayLayoutType.OVERLAY_MEDIA) {
            rect = new Rect(0, 0, m7232e().width(), a.m7329f());
        } else {
            rect = m7232e();
        }
        m7223a(a, rect);
        m7231a(m7241n(), new ViewRect(rect));
        m7231a(m7241n(), new ViewAngle((float) this.f6958b.getDegree()));
    }

    protected void mo424i() {
        if (this.f6964h != null) {
            Iterator it = m7241n().getAnnotationViews().iterator();
            while (it.hasNext()) {
                AnnotationView annotationView = (AnnotationView) it.next();
                m7231a(annotationView.mo438b(), new ViewOpacity(this.f6964h.floatValue()));
                m7231a(annotationView.mo438b(), new FadeWithControls(true));
            }
        }
    }

    private void m7228q() {
        m7224a(m7241n().getAnnotationViews(), m7232e().width());
        m7226a(false);
        m7226a(true);
    }

    private void m7226a(boolean z) {
        ViewRect a = m7230a(m7241n());
        AnnotationViews annotationViews = m7241n().getAnnotationViews();
        m7219a(annotationViews, 0, a.m7330g(), true, false, z, AnnotationSlot.ABOVE, AnnotationSlot.TOP);
        m7219a(annotationViews, 0, (a.m7329f() / 2) - (m7220a(annotationViews, false, false, z, AnnotationSlot.CENTER) / 2), false, false, z, AnnotationSlot.CENTER);
        m7219a(annotationViews, 0, a.m7331h() - m7220a(annotationViews, false, true, z, AnnotationSlot.BOTTOM, AnnotationSlot.BELOW), false, true, z, AnnotationSlot.BOTTOM, AnnotationSlot.BELOW);
    }

    private void m7229s() {
        if (this.f6963g == AnnotationLayoutType.ANNOTATION_DEFAULT) {
            AnnotationViews annotationViews = this.f6962f.getAnnotationViews();
            m7224a(annotationViews, this.f6967k.width());
            int a = m7219a(annotationViews, 0, 0, false, true, false, AnnotationSlot.ABOVE);
            ViewRect a2 = m7230a(this.f6962f.getOverlayView());
            a2.m7323a(a + a2.m7330g());
            m7227b(m7230a(m7241n()), a2.m7324b());
            m7219a(annotationViews, 0, a2.m7331h(), true, false, false, AnnotationSlot.BELOW);
        }
    }

    public ViewRect mo425j() {
        Rect rect = new Rect(m7230a(this.f6962f.getOverlayView()).f7004a);
        rect.left = 0;
        rect.right = this.f6967k.width();
        Iterator it = this.f6962f.getAnnotationViews().iterator();
        while (it.hasNext()) {
            Rect rect2 = m7230a(((AnnotationView) it.next()).mo438b()).f7004a;
            rect.top = Math.min(rect.top, rect2.top);
            rect.bottom = Math.max(rect.bottom, rect2.bottom);
        }
        ViewRect viewRect = new ViewRect(rect);
        viewRect.m7323a(0);
        return viewRect;
    }

    public static void m7223a(ViewRect viewRect, Rect rect) {
        int height = (rect.height() - viewRect.f7004a.height()) / 2;
        viewRect.m7325b((rect.width() - viewRect.f7004a.width()) / 2);
        viewRect.m7323a(height);
    }

    private static void m7227b(ViewRect viewRect, Rect rect) {
        int height = (rect.height() - viewRect.f7004a.height()) / 2;
        viewRect.m7325b(((rect.width() - viewRect.f7004a.width()) / 2) + rect.left);
        viewRect.m7323a(rect.top + height);
    }

    private void m7224a(AnnotationViews annotationViews, int i) {
        Iterator it = annotationViews.iterator();
        while (it.hasNext()) {
            AnnotationView annotationView = (AnnotationView) it.next();
            this.f6962f.m7801a(annotationView.mo438b(), MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
            this.f6965i.put(annotationView, Integer.valueOf(annotationView.mo438b().getMeasuredHeight()));
        }
    }

    protected final float m7238k() {
        Rect e = m7232e();
        if (e.height() > 0) {
            return ((float) e.width()) / ((float) e.height());
        }
        throw new IllegalStateException("Unable to calculate viewport aspect ratio due to invalid viewport height: " + e.height());
    }

    protected final float m7239l() {
        return this.f6962f.getMediaView().getMediaAspectRatio();
    }

    protected final View m7240m() {
        return this.f6962f.getMediaView().getView();
    }

    public final MediaFrameBody m7241n() {
        return this.f6962f.getBody();
    }

    private int m7220a(AnnotationViews annotationViews, boolean z, boolean z2, boolean z3, AnnotationSlot... annotationSlotArr) {
        List a = annotationViews.m7393a(annotationSlotArr);
        if (z3) {
            a = m7222a(a);
        }
        return m7221a(a, z, z2);
    }

    private List<AnnotationView> m7222a(List<AnnotationView> list) {
        List<AnnotationView> arrayList = new ArrayList();
        for (AnnotationView annotationView : list) {
            Object obj;
            ViewOpacity viewOpacity = (ViewOpacity) this.f6966j.mo428a(annotationView.mo438b(), ViewAttributeType.OPACITY, ViewOpacity.class);
            if (viewOpacity == null || viewOpacity.m7318b().floatValue() > 0.0f) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(annotationView);
            }
        }
        return arrayList;
    }

    private int m7221a(List<AnnotationView> list, boolean z, boolean z2) {
        int i = 0;
        if (!CollectionUtil.a(list)) {
            int i2;
            if (z) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            int size = list.size();
            int i3 = i2;
            while (i3 < size) {
                AnnotationView annotationView = i3 == -1 ? null : (AnnotationView) list.get(i3);
                AnnotationView annotationView2 = i3 == size + -1 ? null : (AnnotationView) list.get(i3 + 1);
                if (annotationView != null) {
                    i2 = m7218a(annotationView) + i;
                } else {
                    i2 = i;
                }
                if (annotationView2 != null || z2) {
                    i2 += this.f6960d.m5297a(annotationView, annotationView2);
                }
                i3++;
                i = i2;
            }
        }
        return i;
    }

    private int m7218a(AnnotationView annotationView) {
        if (this.f6965i.containsKey(annotationView)) {
            return ((Integer) this.f6965i.get(annotationView)).intValue();
        }
        return 0;
    }

    public final void m7231a(View view, ViewAttribute viewAttribute) {
        ViewAttributes a = this.f6966j.mo429a(view);
        if (a == null) {
            a = new ViewAttributes();
            this.f6966j.mo431a(view, a);
        }
        a.m7297a(viewAttribute);
    }

    public final ViewRect m7230a(View view) {
        return (ViewRect) this.f6966j.mo428a(view, ViewAttributeType.RECT, ViewRect.class);
    }

    private int m7219a(AnnotationViews annotationViews, int i, int i2, boolean z, boolean z2, boolean z3, AnnotationSlot... annotationSlotArr) {
        List a = annotationViews.m7393a(annotationSlotArr);
        if (z3) {
            a = m7222a(a);
        }
        return m7217a(i, i2, z, z2, a);
    }

    private int m7217a(int i, int i2, boolean z, boolean z2, List<AnnotationView> list) {
        int i3 = 0;
        if (!CollectionUtil.a(list)) {
            int i4;
            if (z) {
                i4 = -1;
            } else {
                i4 = 0;
            }
            int size = list.size();
            int i5 = i4;
            while (i5 < size) {
                AnnotationView annotationView = i5 == -1 ? null : (AnnotationView) list.get(i5);
                AnnotationView annotationView2 = i5 == size + -1 ? null : (AnnotationView) list.get(i5 + 1);
                if (annotationView != null) {
                    i4 = m7216a(i, i2 + i3, annotationView) + i3;
                } else {
                    i4 = i3;
                }
                if (annotationView2 != null || z2) {
                    i4 += this.f6960d.m5297a(annotationView, annotationView2);
                }
                i5++;
                i3 = i4;
            }
        }
        return i3;
    }

    private int m7216a(int i, int i2, AnnotationView annotationView) {
        int i3;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) annotationView.mo438b().getLayoutParams();
        int a = m7218a(annotationView);
        int measuredWidth = annotationView.mo438b().getMeasuredWidth();
        int i4 = marginLayoutParams.leftMargin + i;
        int width = m7232e().width();
        switch (annotationView.getAnnotation().f5611d) {
            case CENTER:
                i3 = (((marginLayoutParams.leftMargin + width) - marginLayoutParams.leftMargin) - measuredWidth) / 2;
                break;
            case RIGHT:
                i3 = (width - measuredWidth) - marginLayoutParams.rightMargin;
                break;
            default:
                i3 = i4;
                break;
        }
        m7231a(annotationView.mo438b(), new ViewRect(new Rect(i3, i2, measuredWidth + i3, i2 + a)));
        return a;
    }
}
