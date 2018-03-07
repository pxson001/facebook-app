package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.utils.OffUiThreadImageDecoder;
import com.facebook.richdocument.utils.OffUiThreadImageDecoder.DrawableDecodedCallback;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableView;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableViewFactory;
import com.facebook.richdocument.view.widget.AnnotatableView;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.AnnotationViews;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.MoreObjects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: offer_claim_fbid */
public abstract class FrameWithOverlay extends CustomViewGroup implements AnnotatableView {
    @Inject
    public CompositeRecyclableViewFactory f7576a;
    @Inject
    public GatekeeperStoreImpl f7577b;
    @Inject
    public OffUiThreadImageDecoder f7578c;
    private int f7579d;
    private final AnnotationViews f7580e;
    private final View f7581f;
    public final Paint f7582g;
    private final Map<OverlaySlot, View> f7583h;
    public boolean f7584i;
    public int f7585j;
    public int f7586k;

    /* compiled from: offer_claim_fbid */
    class OverlayShadowView extends View {

        /* compiled from: offer_claim_fbid */
        class C08711 implements DrawableDecodedCallback {
            final /* synthetic */ OverlayShadowView f7575a;

            C08711(OverlayShadowView overlayShadowView) {
                this.f7575a = overlayShadowView;
            }

            public final void mo470a(int i, Drawable drawable) {
                this.f7575a.setBackground(drawable);
            }
        }

        public OverlayShadowView(Context context, OffUiThreadImageDecoder offUiThreadImageDecoder, boolean z) {
            super(context);
            if (!z || offUiThreadImageDecoder == null) {
                setBackground(context.getResources().getDrawable(2130840800));
            } else {
                offUiThreadImageDecoder.m6859a(getContext(), 2130840800, new C08711(this));
            }
        }
    }

    /* compiled from: offer_claim_fbid */
    enum OverlaySlot {
        TOP,
        CENTER,
        BOTTOM
    }

    public static void m7785a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FrameWithOverlay frameWithOverlay = (FrameWithOverlay) obj;
        CompositeRecyclableViewFactory a = CompositeRecyclableViewFactory.m7356a(injectorLike);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        OffUiThreadImageDecoder a3 = OffUiThreadImageDecoder.m6857a(injectorLike);
        frameWithOverlay.f7576a = a;
        frameWithOverlay.f7577b = a2;
        frameWithOverlay.f7578c = a3;
    }

    public abstract Rect mo471a(View view);

    protected abstract Float mo473b(View view);

    protected abstract Rect getOverlayBounds();

    public FrameWithOverlay(Context context) {
        this(context, null);
    }

    public FrameWithOverlay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameWithOverlay(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7580e = new AnnotationViews();
        this.f7582g = new Paint();
        this.f7583h = new HashMap();
        this.f7586k = 0;
        Class cls = FrameWithOverlay.class;
        m7785a((Object) this, getContext());
        this.f7579d = ViewIdUtil.a();
        this.f7581f = new View(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MediaFrame);
            this.f7585j = obtainStyledAttributes.getDimensionPixelSize(1, RichDocumentUIConfig.f6567t);
            this.f7582g.setColor(obtainStyledAttributes.getColor(0, -16777216));
            obtainStyledAttributes.recycle();
        }
    }

    public void setOverlayBackgroundColor(int i) {
        this.f7582g.setColor(i);
    }

    public void mo407a(AnnotationView annotationView) {
        if (annotationView != null) {
            this.f7580e.f7086a.add(annotationView);
            addView(annotationView.mo438b());
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) instanceof AnnotationView) {
                    this.f7586k = i;
                    return;
                }
            }
            this.f7586k = getChildCount();
        }
    }

    public AnnotationViews getAnnotationViews() {
        return this.f7580e;
    }

    public View getOverlayView() {
        return this.f7581f;
    }

    public boolean jb_() {
        return this.f7584i;
    }

    public void mo437a() {
        this.f7580e.f7086a.clear();
        this.f7583h.clear();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = childCount - 1; i >= 0; i--) {
                View childAt = getChildAt(i);
                if ((childAt instanceof AnnotationView) || (childAt instanceof OverlayShadowView)) {
                    if (childAt instanceof RecyclableView) {
                        RecyclableView recyclableView = (RecyclableView) childAt;
                        for (RecyclableViewFactory recyclableViewFactory : this.f7576a.f7049b.values()) {
                            if (recyclableViewFactory.f7044e.contains(recyclableView)) {
                                Object obj;
                                if (recyclableViewFactory.f7043d.contains(recyclableView)) {
                                    obj = null;
                                } else {
                                    recyclableView.mo437a();
                                    recyclableViewFactory.f7043d.add(recyclableView);
                                    obj = 1;
                                }
                                Object obj2 = obj;
                            }
                        }
                    }
                    removeViewAt(i);
                }
            }
        }
    }

    public final void m7790a(View view, int i, int i2) {
        super.measureChildWithMargins(view, i, 0, i2, 0);
    }

    protected void onMeasure(int i, int i2) {
        Rect a = mo471a((View) this);
        super.onMeasure(MeasureSpec.makeMeasureSpec(a.width(), 1073741824), MeasureSpec.makeMeasureSpec(a.height(), 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Rect overlayBounds = getOverlayBounds();
        Iterator it = this.f7580e.iterator();
        while (it.hasNext()) {
            AnnotationView annotationView = (AnnotationView) it.next();
            m7784a(annotationView.mo438b(), mo473b(annotationView.mo438b()));
            Rect a = mo471a(annotationView.mo438b());
            if (a != null) {
                annotationView.setIsOverlay(overlayBounds.contains(a.centerX(), a.centerY()));
                m7791a(annotationView.mo438b(), a);
            }
        }
        if (jb_()) {
            m7786g();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        mo472a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void mo472a(Canvas canvas) {
        Rect a = mo471a(getOverlayView());
        if (a != null) {
            canvas.save();
            canvas.drawRect(a, this.f7582g);
            canvas.restore();
        }
    }

    public final void m7791a(View view, Rect rect) {
        super.layoutChild(rect.left, rect.right, rect.top, rect.bottom, view);
    }

    private void m7786g() {
        Rect overlayShadowBounds = getOverlayShadowBounds();
        m7783a(overlayShadowBounds, OverlaySlot.TOP, AnnotationSlot.ABOVE, AnnotationSlot.TOP);
        m7783a(overlayShadowBounds, OverlaySlot.CENTER, AnnotationSlot.CENTER);
        m7783a(overlayShadowBounds, OverlaySlot.BOTTOM, AnnotationSlot.BOTTOM, AnnotationSlot.BELOW);
    }

    private void m7783a(Rect rect, OverlaySlot overlaySlot, AnnotationSlot... annotationSlotArr) {
        if (this.f7583h.containsKey(overlaySlot)) {
            ((View) this.f7583h.get(overlaySlot)).setVisibility(4);
        }
        List<AnnotationView> a = this.f7580e.m7393a(annotationSlotArr);
        Rect rect2 = null;
        for (AnnotationView annotationView : a) {
            if (annotationView.mo439c() && annotationView.mo438b().getVisibility() == 0) {
                Rect a2 = mo471a(annotationView.mo438b());
                if (a2 != null) {
                    if (rect2 == null) {
                        rect2 = new Rect(a2);
                    } else {
                        rect2.union(a2);
                    }
                }
            }
        }
        if (rect2 != null) {
            rect2.intersect(rect);
        }
        Rect rect3 = rect2;
        if (rect3 != null) {
            View a3 = m7782a(overlaySlot);
            a3.layout(rect3.left - this.f7585j, rect3.top - this.f7585j, rect3.right + this.f7585j, rect3.bottom + this.f7585j);
            a3.setVisibility(0);
            m7784a(a3, Float.valueOf(m7781a((List) a)));
        }
    }

    private float m7781a(List<AnnotationView> list) {
        float f = 0.0f;
        for (AnnotationView annotationView : list) {
            float max;
            if (annotationView.mo439c() && annotationView.mo438b().getVisibility() == 0) {
                max = Math.max(((Float) MoreObjects.firstNonNull(mo473b(annotationView.mo438b()), Float.valueOf(1.0f))).floatValue(), f);
            } else {
                max = f;
            }
            f = max;
        }
        return RichDocumentUIConfig.f6568u * f;
    }

    private View m7782a(OverlaySlot overlaySlot) {
        if (this.f7583h.containsKey(overlaySlot)) {
            return (View) this.f7583h.get(overlaySlot);
        }
        View overlayShadowView = new OverlayShadowView(getContext(), this.f7578c, this.f7577b.a(697, false));
        overlayShadowView.setAlpha(RichDocumentUIConfig.f6568u);
        this.f7583h.put(overlaySlot, overlayShadowView);
        addViewInLayout(overlayShadowView, this.f7586k, generateDefaultLayoutParams(), true);
        return overlayShadowView;
    }

    private static void m7784a(View view, Float f) {
        if (f != null) {
            view.setAlpha(f.floatValue());
            if (f.floatValue() <= RichDocumentUIConfig.f6566s) {
                view.setVisibility(4);
                return;
            } else {
                view.setVisibility(0);
                return;
            }
        }
        view.setAlpha(1.0f);
        view.setVisibility(0);
    }

    protected Rect getOverlayShadowBounds() {
        return getOverlayBounds();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f7579d + ")";
    }
}
