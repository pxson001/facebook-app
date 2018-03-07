package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.richdocument.view.transition.ViewAngle;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewOpacity;
import com.facebook.richdocument.view.transition.ViewRect;
import javax.annotation.Nullable;

/* compiled from: offer */
public class MediaFrameBody<V extends MediaView> extends FrameWithOverlay {
    public V f7587d;

    public MediaFrameBody(Context context) {
        this(context, null);
    }

    public MediaFrameBody(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaFrameBody(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7584i = true;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void setMediaView(V v) {
        this.f7587d = v;
    }

    public V getMediaView() {
        return this.f7587d;
    }

    public final boolean jb_() {
        return this.f7587d.ja_() && super.jb_();
    }

    public MediaFrame<V> getMediaFrame() {
        return (MediaFrame) getParent();
    }

    protected ViewLayout getCurrentLayout() {
        return getMediaFrame().getCurrentLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m7809c()) {
            m7791a(this.f7587d.getView(), mo471a(this.f7587d.getView()));
        }
        setRotation(getViewAngle());
    }

    protected final void mo472a(Canvas canvas) {
        if (m7809c()) {
            Rect overlayBounds = getOverlayBounds();
            Rect a = mo471a(this.f7587d.getView());
            if (overlayBounds != null && a != null && !overlayBounds.equals(a)) {
                canvas.save();
                canvas.clipRect(a, Op.DIFFERENCE);
                canvas.drawRect(overlayBounds, this.f7582g);
                canvas.restore();
                return;
            }
            return;
        }
        super.mo472a(canvas);
    }

    private boolean m7809c() {
        return this.f7587d != null && this.f7587d.getView().getVisibility() == 0;
    }

    protected float getViewAngle() {
        ViewAngle viewAngle = (ViewAngle) getCurrentLayout().mo428a(this, ViewAttributeType.ANGLE, ViewAngle.class);
        return viewAngle == null ? 0.0f : viewAngle.f6998a.floatValue();
    }

    protected final Rect mo471a(View view) {
        ViewRect viewRect = (ViewRect) getCurrentLayout().mo428a(view, ViewAttributeType.RECT, ViewRect.class);
        return viewRect == null ? null : viewRect.f7004a;
    }

    protected final Float mo473b(View view) {
        ViewOpacity viewOpacity = (ViewOpacity) getCurrentLayout().mo428a(view, ViewAttributeType.OPACITY, ViewOpacity.class);
        return viewOpacity == null ? null : viewOpacity.m7318b();
    }

    protected Rect getOverlayBounds() {
        Rect a = mo471a((View) this);
        return new Rect(0, 0, a.width(), a.height());
    }

    protected Rect getOverlayShadowBounds() {
        if (this.f7587d != null) {
            return mo471a(this.f7587d.getView());
        }
        return super.getOverlayShadowBounds();
    }
}
